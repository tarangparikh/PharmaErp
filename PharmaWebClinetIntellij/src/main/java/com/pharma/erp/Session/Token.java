package com.pharma.erp.Session;

import com.google.gson.Gson;
import com.pharma.erp.Database.SessionFactory_Helper;
import com.pharma.erp.StoredObject.Serialized;
import io.jsonwebtoken.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.*;
import java.util.Base64;
import java.util.Date;

@WebServlet(name = "token",urlPatterns = ("/token"))
public class Token extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException, ClassNotFoundException {

        KeyPair kp = (KeyPair) getServletContext().getAttribute("Key_Pair");
        Key pubic = kp.getPublic();
        PrivateKey priva = kp.getPrivate();

        String _jwt = Jwts.builder().setSubject("user/login")
                        .setExpiration(new Date(System.currentTimeMillis()+3600*1000))
                        .claim("username","tarangparikh")
                        .claim("scope","admin")
                        .signWith(SignatureAlgorithm.RS256, priva)
                        .compact();
        HttpSession session = request.getSession();
        response.addCookie(new Cookie("token",_jwt));
        Gson gson = new Gson();
        gson.toJson(_jwt);
        response.setContentType("application/json");

        response.getWriter().println(gson.toJson(_jwt));
        String _get = gson.fromJson(gson.toJson(_jwt),String.class);
        Jws<Claims> token = Jwts.parser().setSigningKey(priva).parseClaimsJws(_get);




    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            doProcess(request,response);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            doProcess(request,response);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
