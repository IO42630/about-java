package com.olexyn.about.java.time;

public class InfluencingScheduler {




    public static void main(String... args) throws InterruptedException {
        // from Thread
        Thread thread = new Thread();

        // Static method, always refers to current Thread.
        thread.sleep(1L); //
        thread.yield(); // Thread signals it's ready to yield it's use of the processor.

        thread.join();
        thread.setPriority(1);

        // from Object
        thread.wait();
        thread.notify();
        thread.notifyAll();
    }


}
