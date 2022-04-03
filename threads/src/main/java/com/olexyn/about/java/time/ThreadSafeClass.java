package com.olexyn.about.java.time;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadSafeClass {

    static List<String> list = Collections.synchronizedList(new ArrayList<>());


    public static void main(String... args) {

        list.add("foo");


        Runnable r = new Runnable32();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        //t2.start();

    }
}


class Runnable32 implements Runnable {

    @Override
    public void run() {
        if (ThreadSafeClass.list.size() > 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) { }
            ThreadSafeClass.list.remove(0);
        }

    }
}
