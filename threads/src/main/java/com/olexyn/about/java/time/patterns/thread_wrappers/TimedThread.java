package com.olexyn.about.java.time.patterns.thread_wrappers;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Pattern to avoid problematic Thread.interrupt() .
 */
public abstract class TimedThread implements Runnable {

    Instant maxTime;

    public final void start(String name, Duration duration) {
        maxTime = Instant.now().plus(duration);
        var worker = new Thread(this, name);
        worker.start();
    }

    @Override
    public final void run() {
        while (Instant.now().isBefore(maxTime)) {
            work();
        }
    }

    protected abstract void work();

}
