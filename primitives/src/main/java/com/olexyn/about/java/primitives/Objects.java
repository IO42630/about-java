package com.olexyn.about.java.primitives;

public class Objects {


    public static void main(String... args){

        Object a = new Object();
        Object b = a;


        System.out.println(a);

        new Objects().fool(a);

        // 3 variables a,b,c
        // 2 references (a,b


    }



    void fool (Object c){

        System.out.println(c);
    }


}
