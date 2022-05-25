package com.olexyn.about.java.jakarta.jndi;

import javax.naming.CompositeName;
import javax.naming.InvalidNameException;
import javax.naming.Name;
import java.util.Enumeration;

public class Example {

    public static void main(String... args) throws InvalidNameException {


        Name objectName = new CompositeName("java:comp/env/jdbc");
        Enumeration<String> elements = objectName.getAll();
        while(elements.hasMoreElements()){
            System.out.println(elements.nextElement());
        }

        objectName.add("example");
        boolean b = objectName.get(objectName.size() - 1).equals("example");

    }



}
