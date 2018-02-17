/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharma.erp.Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pharma.erp.Database.SessionFactory_Helper;
import com.schema.Student;
import java.io.IOException;
import javax.servlet.ServletContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
/**
 *
 * @author tarang
 */
@WebServlet(name = "hello",urlPatterns = {"hello"})
public class HelloServlet extends HttpServlet{
    public void doGet(HttpServletRequest _request , HttpServletResponse _response) throws IOException{
         ServletContext _context = getServletContext();
         SessionFactory _factory = (SessionFactory) _context.getAttribute("student_factory");
        
         Session _session = _factory.getCurrentSession();
        
        
        _session.beginTransaction();
        
        _session.save(new Student("Solance","Choko","schoko@gamil.com"));
        
        _session.getTransaction().commit();
        
        _factory.close();
        
        _response.getWriter().println("Saved the object");
    
    
    
    }
    
    
    
    
}
