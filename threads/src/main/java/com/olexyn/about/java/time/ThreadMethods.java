package com.olexyn.about.java.time;

public class ThreadMethods {

    void staticMethods(){
        Thread.currentThread(); // returns reference to the currently executing thread object.
    }

    void instanceMethods(){
        Thread thread = new Thread();
        thread.setName("foo");
        thread.getName(); // Thread-0 by default,
        thread.getId(); // long

    }

    public static void main(String... args){
        Thread.currentThread().getName(); // name is "main"
    }
}
