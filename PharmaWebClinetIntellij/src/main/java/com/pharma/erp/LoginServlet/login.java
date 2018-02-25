package com.pharma.erp.LoginServlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.util.Date;


import com.google.gson.Gson;
import com.pharma.erp.Validation.Data;
import com.pharma.erp.Validation.UserValidation;
import com.schema.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@WebServlet(name = "login",urlPatterns = {"/login"})
public class login extends HttpServlet {
    protected void doProcess(HttpServletRequest request,HttpServletResponse response) throws IOException {
            synchronized (getServletContext()){
                SessionFactory _user_factory = (SessionFactory) getServletContext().getAttribute("User_Factory");
                Session _session = _user_factory.getCurrentSession();


                try{
                    _session.beginTransaction();

                    String _user_name = request.getParameter("email");
                    String _password = request.getParameter("password");
                    if(_user_name==null||_password==null){
                        request.getRequestDispatcher("/redirect").forward(request,response);
                    }
                    User _user = new User(_user_name,_password);







                    UserValidation _user_validation = new UserValidation(new Data<User>(_user_factory,User.class),_session);
                    if(_user_validation.isPresent(_user)){
                        KeyPair kp = (KeyPair) getServletContext().getAttribute("Key_Pair");
                        Key pubic = kp.getPublic();
                        PrivateKey priva = kp.getPrivate();

                        String _jwt = Jwts.builder().setSubject("user/login")
                                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))
                                .claim("username",_user.username)
                                .claim("scope","admin")
                                .signWith(SignatureAlgorithm.RS256, priva)
                                .compact();

                        response.setContentType("application/json");
                        response.addCookie(new Cookie("token",_jwt));
                        response.getWriter().println(new Gson().toJson(_jwt));

                    }else{
                        //response.getWriter().println(getServletContext().getContextPath()+"/");

                        request.getRequestDispatcher("/redirect").forward(request,response);

                    }
                    //_session.save(new User("tarangparikh","aggarwal"));*/
                    _session.flush();

                    _session.clear();

                    _session.getTransaction().commit();

                    _session.close();





                }catch (Exception e){
                    _session.close();
                    response.getWriter().println(e.toString());



                }



            }
    }




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request,response);
    }
}
