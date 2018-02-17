/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharma.erp.Database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author tarang
 */
public class SessionFactory_Helper {
    
    public static SessionFactory getSessionFactory(Class _class,String _path_configuration){
        SessionFactory _factory;
        if(_path_configuration!=null)
        {
            _factory = new Configuration()
                        .configure(_path_configuration)
                        .addAnnotatedClass(_class)
                        .buildSessionFactory();
        }else{
            _factory = new Configuration()
                        .configure()
                        .addAnnotatedClass(_class)
                        .buildSessionFactory();
        }
        return _factory;
    
    }
    
    
}
