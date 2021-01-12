package com.olexyn.about.java.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Print {


    public static void main(String... args) throws FileNotFoundException {
        PrintWriter out = new PrintWriter("zoo.log");
        out.print(5); // PrintWriter method
        out.write(String.valueOf(5)); // Writer method
        out.print(2.0); // PrintWriter method
        out.write(String.valueOf(2.0)); // Writer method
        Object obj = new Object();
        out.print(obj); // PrintWriter method
        out.write(obj==null ? "null": obj.toString()); // Writer method
    }


}
