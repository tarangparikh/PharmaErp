package com.pharma.erp.StoredObject;

import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import java.io.*;

public class Serialized {

    public static Object deserilaize(InputStream istream) throws IOException, ClassNotFoundException {


        ObjectInputStream oin = new ObjectInputStream(istream);
        Object obj  = oin.readObject();
        oin.close();
        return obj;
    }


}
