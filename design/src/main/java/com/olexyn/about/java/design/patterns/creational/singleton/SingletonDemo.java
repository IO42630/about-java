package com.olexyn.about.java.design.patterns.creational.singleton;

/**
 * Singleton => one instance + global access to it - - - - -
 */
public class SingletonDemo {

    private static SingletonDemo instance = null;

    private SingletonDemo() { /* avoids instantiation */ }

    // sync for thread safety
    public static synchronized SingletonDemo getInstance() {
        // this is called <lazy instantiatin> (also a pattern)
		if (instance == null) { instance = new SingletonDemo(); }
        return instance;
    }


    // double-checked locking
    private static volatile SingletonDemo instance2;

    public static SingletonDemo getInstance2() {
        if (instance2 == null) {
            synchronized (SingletonDemo.class) {
                if (instance2 == null) {
                    instance2 = new SingletonDemo();
                }
            }
        }
        return instance2;
    }


}
