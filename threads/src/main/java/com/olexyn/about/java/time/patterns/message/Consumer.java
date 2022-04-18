package com.olexyn.about.java.time.patterns.message;

import com.olexyn.about.java.time.patterns.thread_wrappers.TimedThread;

public class Consumer extends TimedThread {

    public final String name;
    private final Medium medium;

    Consumer(String name, Medium medium) {
        this.name = name;
        this.medium = medium;
    }

    @Override
    protected void work() {
        if (!medium.messages.isEmpty()) {
            var message = medium.messages.pop();
            synchronized(message) {
                message.setReceiver(this);
                System.out.println("Received " + message.getContent() + " by " + name);
                message.notifyAll();
            }
        }
    }

}
