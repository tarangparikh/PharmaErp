/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;

import org.hibernate.SessionFactory;
import com.pharma.erp.Database.SessionFactory_Helper;
import com.schema.Student;
import org.hibernate.Session;
/**
 *
 * @author tarang
 */
public class MainApp {
    public static void main(String[] args){
        System.out.println("Sone");
        SessionFactory _factory = SessionFactory_Helper.getSessionFactory(Student.class, null);
        Session _session = _factory.getCurrentSession();
        
        _session.beginTransaction();
        
        _session.save(new Student("TarangHibernate","Parikh","tp0265@gmail.com"));
    
        _session.getTransaction().commit();
    
        _factory.close();
    }
}
