package com.olexyn.about.java.design.architectures.eda;

import com.olexyn.about.java.time.patterns.thread_wrappers.StoppableThread;

import java.util.ArrayList;
import java.util.List;

public class SomeConsumer extends StoppableThread {

    List<SomeEvent> inbox = new ArrayList<>();
    List<SomeEvent> consumed = new ArrayList<>();

    String name;

    SomeConsumer(String name) {
        this.name = name;
    }


    public void consume(SomeEvent event) {
        inbox.add(event);
        System.out.println(name + "received: " + event.content());
    }

    @Override
    protected void work() {
        for (var event : inbox) {
            consumed.add(event);
            System.out.println(name + "received: " + event.content());
        }
        inbox.clear();

    }
}
