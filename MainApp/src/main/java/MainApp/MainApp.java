/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;


import com.schema.User;
import org.hibernate.SessionFactory;
import com.pharma.erp.Database.SessionFactory_Helper;
import com.schema.Student;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


/**
 *
 * @author tarang
 */
public class MainApp {
    public static void main(String[] args){
        System.out.println("Sone");
        SessionFactory _factory = SessionFactory_Helper.getSessionFactory(User.class, null, SessionFactory_Helper.Type.MAIN);
        Session _session = _factory.getCurrentSession();
        _session.beginTransaction();

        _session.save(new User("Jums","Baggi"));
        _session.getTransaction().commit();
        _factory.close();
    }
}
