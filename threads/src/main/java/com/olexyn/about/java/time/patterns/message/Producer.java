package com.olexyn.about.java.time.patterns.message;

import com.olexyn.about.java.time.patterns.thread_wrappers.CountedThread;

import java.util.Random;

public class Producer extends CountedThread {

    private static final Random RNG = new Random();

    private final Medium medium;

    public Producer(Medium medium) {
        this.medium = medium;
    }

    @Override
    protected void work() {
        medium.messages.push(new Message("MESSAGE_" + RNG.nextInt(0, 10)));
    }

}
