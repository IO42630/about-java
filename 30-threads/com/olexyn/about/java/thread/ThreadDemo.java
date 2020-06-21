package com.olexyn.about.java.thread;

public class ThreadDemo {

    static Thread t = null;
    static Thread t2=null;
    static Runnable r = null;

    public static void main(String... args){

        r = ()-> System.out.println("Hello!"); // Runnable is a functional interface.

        t = new MyThread();

        r = new MyRunnable();
        t = new Thread(r); // here r is called a `target`
        t2 = new Thread(r); // r will be performed multiple times.


        Thread t4 = new Thread(()-> System.out.println("Hello!"));

        // Thread implements Runnable.
        // The Constructor of Thread may take an Object which is implementing Runnable as a Parameter.
        // This Parameter is called Target.
        // The run() in the Thread is overridden by the run() in the Target.
        // Thus the Target may be a Thread.
        // However it is wasteful to use Thread as a Target as only the run() is used.
        // If Thread is initialied through the no-args Constructor, it's run is not overridden.
        // Or if Thread is extended, then the overriding happens by the extending class and not throught Constructor.


        // available Constructors for Thread
        new Thread();
        new Thread(r);
        new Thread(r, "foo");
        new Thread("foo");

        // thread started





    }


}


/**
 * Bad Pattern.
 */
class MyThread extends Thread{

    public void start(){
        //TODO when exactly is the current Thread not main anymore.
        System.out.println(Thread.currentThread());
        super.start();
    }

    public void run(){
        System.out.println("Hello!");
    }
}

/**
 * Good Pattern
 */
class MyRunnable implements Runnable{

    public void run(){
        System.out.println("Hello!");

    }
}


class Priorities{

    public static void main(String... args){
        System.out.println(Thread.MIN_PRIORITY);

    }
}

