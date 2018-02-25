package com.schema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name = "username", nullable = false)
    public String username;

    @Column(name = "password",nullable = false)
    public String password;

    public User(){
        username = null;
        password=null;
    }
    public User(String username,String password) {
        this.username = username;
        this.password = password;
    }

    public static boolean areEqual(User _main , User _compare){
        if(_main.username==null||_compare.username==null||_main.password==null||_compare.password==null){
            return false;
        }else{
            return _main.username.equals(_compare.username)&&_main.password.equals(_compare.password);
        }
    }
}
