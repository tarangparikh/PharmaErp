/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharma.erp.Validation;

import com.schema.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.text.CollationElementIterator;
import java.util.List;

/**
 *
 * @author tarang
 */
public class UserValidation implements Validation<User>{
    private enum TypeError{NULL_VALUE,ONLY_NUMBER,INVALID_CHARACTER,NO_ERROR,CONTAINS_SPACE, LENGTH_ERROR};
    private enum Present{PRESENT,NOT_PRESENT,DATA_ERROR};
    private enum PassWordTypeError{NULL_VALUE,INVALID,CONTAINS_SPACE,VALID,LENGTH_ERROR};
    private Data<User> _data_user;
    private Session _session;
    public UserValidation(Data<User> _data_user,Session _session) {
        this._data_user = _data_user;
        this._session = _session;
    }

    private void trimData(User _data){
        _data.username = _data.username.trim();
        _data.password = _data.password.trim();
    }

    public TypeError usernameValidation(User _data){
        trimData(_data);

        String _username = _data.username;
        if(_username==null){
            return TypeError.NULL_VALUE;
        }
        if(_username.contains(" "))
            return TypeError.CONTAINS_SPACE;
        if(_username.matches("(\\d)+"))
            return TypeError.ONLY_NUMBER;
        if(!_username.matches("(\\w|\\d)+"))
            return TypeError.INVALID_CHARACTER;
        if(!_username.matches("(\\w|\\d){8,12}"))
            return TypeError.LENGTH_ERROR;
        else
            return TypeError.NO_ERROR;
    }
    public PassWordTypeError passwordValidation(User _data){
        trimData(_data);

        String _password = _data.password;
        if(_password==null){
            return PassWordTypeError.NULL_VALUE;
        }
        System.out.println(_password);
        if(_password.contains(" ")){
            return PassWordTypeError.CONTAINS_SPACE;
        }
        if(!_password.matches(("(.{8,})"))){
            return PassWordTypeError.LENGTH_ERROR;
        }else{
            return PassWordTypeError.VALID;
        }
        
        
    }


    //Checks if username and password are according to given criteria

    public boolean isValid(User _data) {
        //Trim data before use
        trimData(_data);

        TypeError _user = usernameValidation(_data);
        PassWordTypeError _password = passwordValidation(_data);
        if(_user==TypeError.NO_ERROR&&_password==PassWordTypeError.VALID)
            return true;
        else
            return false;
   }

    @Override
    public boolean isInsertable(User _data) {

        return isValid(_data)&&!isPresent(_data);


    }
    @Override
    public boolean isRemovable(User _data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    //Matches the complete user object with with the given parameter
    @Override
    public boolean isPresent(User _data) {
        _data.username=_data.username.trim();
        SessionFactory _factory = _data_user.getFactory();
        String _username = _data.username;
        String query = new StringBuilder().append("FROM User U WHERE U.username='").append(_username).append("'").toString();
        Query<User> q = _session.createQuery(query,User.class);
        List<User> result  = q.getResultList();



        if(result.size()>0){
            return User.areEqual(_data,result.get(0));
        }else{
            return false;
        }


    }


    
    
}
