package com.pharma.erp.Validate;


import com.schema.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

enum TypeError{ONLY_NUMBER,INVALID_CHARACTER,NO_ERROR,CONTAINS_SPACE, LENGTH_ERROR};
enum Present{PRESENT,NOT_PRESENT,DATA_ERROR};
public class UserValidation {
    Data data =  null;

    public UserValidation(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }

    public TypeError validateAndTrim(String _username){
        _username = _username.trim();
        if(_username.contains("_user.trim().contains(\" \")"))
            return TypeError.CONTAINS_SPACE;
        if(_username.matches("(\\d)+"))
            return TypeError.ONLY_NUMBER;
        if(_username.matches("(\\w|\\d)+"))
            return TypeError.INVALID_CHARACTER;
        if(!_username.matches("(\\w|\\d){8,12}"))
            return TypeError.LENGTH_ERROR;
        else
            return TypeError.NO_ERROR;
        }



        public Present isPresent(String _username){
            if(validateAndTrim(_username)!=TypeError.NO_ERROR)
                return Present.DATA_ERROR;
                    Session _session = data.getFactory().getCurrentSession();
                    Query<User> _query = _session.createQuery("from "+data.getClassType().getName()+" as U where U.username ="+_username);
                    List<User> _list = _query.getResultList();
                if(_list.size()>0){
                    return Present.PRESENT;
                }else{
                    return Present.NOT_PRESENT;
                }

    }
}
