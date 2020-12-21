package com.olexyn.about.java.primitives;

public class Short {

    short foo = 'd'; // OK
    // short bar = 65535 ; // DOES NOT COMPILE

    {


    }

    public static void main(String[] args) {
        var b = (short) 10;
        b = (byte) 5;
        b = (int) 4;
        // b = 10_000_000; // NO too big
    }


    //static void
}



