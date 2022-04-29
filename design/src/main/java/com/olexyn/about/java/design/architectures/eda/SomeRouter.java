package com.olexyn.about.java.design.architectures.eda;

import com.olexyn.about.java.time.patterns.thread_wrappers.StoppableThread;

import java.util.ArrayList;
import java.util.List;

public class SomeRouter extends StoppableThread {

    private final List<SomeEvent> events = new ArrayList<>();

    private final List<SomeConsumer> consumers = new ArrayList<>();

    public void push(SomeEvent event) {
        synchronized(event) {
            events.add(event);
        }

    }

    public void register(SomeConsumer consumer) {
        consumers.add(consumer);
    }

    @Override
    protected void work() {
        for (var event : events) {
                for (var consumer : consumers) {
                    consumer.consume(event);
                }
        }
    }
}
