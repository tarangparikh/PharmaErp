package com.pharma.erp.LoginServlet;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.pharma.erp.Validate.Data;
import com.pharma.erp.Validate.UserValidation;
import com.schema.User;
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
                    _session.save(new User("tarangparikh","aggarwal"));
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
