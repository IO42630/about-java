package com.olexyn.about.java.deployment.pkg;

import other.pkg.OtherPkg;
import jar.src.no_main.ClassInJar;

public class Main {
    public Main() {
    }

    public static void main(String[] var0) {


        System.out.println("Main says Hi!");
        new Helper().helperSaysHi();
        new OtherPkg().otherPkgSaysHi();
        new ClassInJar().hi();

        //Date foo = new Date();
        java.util.Date date ; // fully qualified class name
    }
}
