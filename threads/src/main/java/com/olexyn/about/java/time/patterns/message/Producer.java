package com.olexyn.about.java.time.patterns.message;

import com.olexyn.about.java.time.patterns.thread_wrappers.CountedThread;

import java.util.Random;

public class Producer extends CountedThread {

    private static final Random RNG = new Random();

    public final String name;
    private final Medium medium;

    public Producer(String name, Medium medium) {
        this.name = name;
        this.medium = medium;
    }

    @Override
    protected void work() {
        var message = new Message();
        synchronized(message) {
            message.setContent("MESSAGE_" + RNG.nextInt(0, 100));
            message.setSender(this);
            medium.messages.push(message);
            System.out.println("Sent " + message.getContent() + " from " + name);
            try {
                message.wait(); // release monitor
            } catch (InterruptedException ignored) { }
        }

        synchronized(message) { // wait till monitor is acquired again.
            System.out.println("Confirmation of delivery of " + message.getContent() + " to " + message.getReceiver().name + " received by " + name);
        }

    }

}
