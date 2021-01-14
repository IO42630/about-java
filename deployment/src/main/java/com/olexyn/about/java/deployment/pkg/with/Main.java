package com.olexyn.about.java.deployment.pkg.with;

import com.olexyn.about.java.deployment.jar.src.no_main.ClassInJar;
import com.olexyn.about.java.deployment.pkg.with.other_pkg.OtherPkg;

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
