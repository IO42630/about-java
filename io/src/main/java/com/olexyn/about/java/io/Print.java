package com.olexyn.about.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

public class Print {


    public static void main(String... args) throws IOException {
        PrintWriter out = new PrintWriter("zoo.log");
        out.print(5); // PrintWriter method
        out.write(String.valueOf(5)); // Writer method
        out.print(2.0); // PrintWriter method
        out.write(String.valueOf(2.0)); // Writer method
        Object obj = new Object();
        out.print(obj); // PrintWriter method
        out.write(obj==null ? "null": obj.toString()); // Writer method


        File source = new File("zoo.log");
        try (PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter(source)))) {
            out2.print("Today's weather is: ");
            out2.println("Sunny");
            out2.print("Today's temperature at the zoo is: ");
            out2.print(1/3.0);
            out2.println('C');
            out2.format("It has rained 10.12 inches this year");
            out2.println();
            out2.printf("It may rain 21.2 more inches this year");
        }

        Reader in = new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
    }


}
