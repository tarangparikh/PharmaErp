package com.pharma.erp.Validation;

import org.hibernate.SessionFactory;

public class Data<T>{
    private SessionFactory _factory;
    private Class<T> _data_class;
    
    public Data(SessionFactory _factory,Class _data_class){
        this._factory = _factory;
        this._data_class = _data_class;
    }

    public SessionFactory getFactory() {
        return _factory;
    }

    public void setFactory(SessionFactory _factory) {
        this._factory = _factory;
    }

    public Class getData_class() {
        return _data_class;
    }

    public void setData_class(Class _data_class) {
        this._data_class = _data_class;
    }

    @Override
    public String toString() {
        return "Data{" + "_factory=" + _factory + ", _data_class=" + _data_class + '}';
    }
    
    

    

    
    
    
    
    
    
    
}