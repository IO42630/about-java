package com.olexyn.about.java.time.patterns.thread_wrappers;

public abstract class CountedThread implements Runnable {

    private int counter;
    private int max;

    public final void start(String name, int max) {
        this.max = max;
        var worker = new Thread(this, name);
        worker.start();
    }


    @Override
    public final void run() {
        while (counter < max ) {
            work();
            counter++;
        }
    }

    protected abstract void work();

}
