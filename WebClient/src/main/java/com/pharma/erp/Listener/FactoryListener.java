/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharma.erp.Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.hibernate.SessionFactory;
import com.pharma.erp.Database.SessionFactory_Helper;
import com.schema.Student;

/**
 *
 * @author tarang
 */
@WebListener()
public class FactoryListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext _context = sce.getServletContext();
        SessionFactory _factory = SessionFactory_Helper.getSessionFactory(Student.class, null);
        _context.setAttribute("student_factory", _factory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    
    }
    
}
