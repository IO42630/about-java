package com.olexyn.about.java.time.patterns.message;

import com.olexyn.about.java.time.patterns.thread_wrappers.TimedThread;

public class Consumer extends TimedThread {

    private final Medium medium;


    Consumer(Medium medium) {
        this.medium = medium;
    }

    @Override
    protected void work() {
        if (!medium.messages.isEmpty()) {
            var message = medium.messages.pop();
            System.out.println("Consumed " + message.content());
        }



    }
}
