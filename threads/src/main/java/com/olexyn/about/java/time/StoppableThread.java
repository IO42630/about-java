package com.olexyn.about.java.time;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Pattern to avoid problematic Thread.interrupt() .
 */
public class StoppableThread  implements Runnable {

    private final AtomicBoolean running = new AtomicBoolean(false);

    public void start() {
        var worker = new Thread(this, "FLOW_WORKER");
        worker.start();
    }

    public void stop() {
        running.set(false);
    }

    @Override
    public void run() {
        running.set(true);
        while (running.get()) {
            // Do work.
        }
    }

    public static void main(String... args){
        var flow = new StoppableThread();
        flow.start();
        // Do something else.
        flow.stop();
    }

}
