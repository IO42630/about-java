package com.olexyn.about.java.declarations;

public class StaticAbout {

    static void staticM() {}
    void instanceM() {}

    static void staticCallsX() {
        // static -> instance
        new StaticAbout().instanceM();
        // instanceM();                 // C-Err
        // static -> static
        new StaticAbout().staticM();
        staticM();
    }

    void instanceCallsX() {
        // instance -> instance
        new StaticAbout().instanceM();
        instanceM();
        // instance -> static
        new StaticAbout().staticM();
        staticM();
    }
}
