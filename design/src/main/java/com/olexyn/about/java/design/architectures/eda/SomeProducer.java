package com.olexyn.about.java.design.architectures.eda;

import com.olexyn.about.java.time.patterns.thread_wrappers.StoppableThread;

import java.util.Random;

public class SomeProducer extends StoppableThread {

    private static final Random RNG = new Random(10);

    private SomeRouter router;

    private int count;

    SomeProducer(SomeRouter router) {
        this.router = router;
    }

    @Override
    protected void work() {
        var event = new SomeEvent("EVENT_" + RNG.nextInt());
        synchronized(event) {
            router.push(event);
        }
        count++;
        if (count > 10) {
            stop();
        }
    }

}
