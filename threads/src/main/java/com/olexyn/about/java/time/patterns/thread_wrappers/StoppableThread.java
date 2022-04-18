package com.olexyn.about.java.time.patterns.thread_wrappers;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Pattern to avoid problematic Thread.interrupt() .
 */
public abstract class StoppableThread implements Runnable {

    private final AtomicBoolean running = new AtomicBoolean(false);

    public final void start(String name) {
        var worker = new Thread(this, name);
        worker.start();
    }

    public final void stop() {
        running.set(false);
    }

    @Override
    public final void run() {
        running.set(true);
        while (running.get()) {
            work();
        }
    }

    protected abstract void work();

}
