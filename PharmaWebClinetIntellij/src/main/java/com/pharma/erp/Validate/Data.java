package com.pharma.erp.Validate;

import org.hibernate.SessionFactory;

public class Data {
    private Class classType;
    private SessionFactory factory = null;

    public Data(Class classType, SessionFactory factory) {
        this.classType = classType;
        this.factory = factory;
    }

    @Override
    public String toString() {
        return "Data{" +
                "classType=" + classType +
                ", factory=" + factory +
                '}';
    }

    public Class getClassType() {
        return classType;
    }

    public void setClassType(Class classType) {
        this.classType = classType;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }
}
