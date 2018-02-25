/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApp;


import com.schema.User;
import org.hibernate.SessionFactory;
import com.pharma.erp.Database.SessionFactory_Helper;
import com.pharma.erp.Validation.Data;
import com.pharma.erp.Validation.UserValidation;
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
        SessionFactory _user_factory = SessionFactory_Helper.getSessionFactory(User.class,null, SessionFactory_Helper.Type.MAIN);
        Session _session = _user_factory.getCurrentSession();
        User user = new User("tarang","parisdkh");
        _session.beginTransaction();
        UserValidation userValidation = new UserValidation(new Data<User>(_user_factory,User.class),_session);
        System.out.println(userValidation.isPresent(user));

    }
}
