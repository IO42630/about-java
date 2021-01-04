package com.olexyn.about.java.time;

public class WaitNotify {


    public static void main(String... args) {

        final Runnable runnable = new Runnable33();
        final Thread thread = new Thread(runnable);
        thread.setName("Thread33");


        System.out.println("Main entered the monitor.");
        synchronized (runnable) {
            System.out.println("Main acquired the monitor.");
            System.out.println("Main owns the monitor.");

            thread.start();

            try {
                System.out.println("Main released the monitor for 1000ms.");
                runnable.wait(1000);


                System.out.println("Main acquired the monitor.");

                System.out.println("Main sleeps for 1000ms.");
                Thread.sleep(1000);

                System.out.println("Main notified all.");
                runnable.notifyAll();
            } catch (InterruptedException e) {
                System.out.println("Interrupted.");
            }
        }
    }
}


class Runnable33 implements Runnable {


    @Override
    public void run() {


        System.out.println("Thread33 entered the monitor.");
        synchronized (this) {
            System.out.println("Thread33 acquired the monitor.");
            System.out.println("Thread33 owns the monitor.");


            for (int i = 0; i < 4; i++) {
                try {

                    System.out.println("Thread33 sleeps for 500ms.");
                    Thread.sleep(500);



                    System.out.println("Thread33 released the monitor for 100ms.");
                    wait(100);
                    System.out.println("Thread33 acquired the monitor.");

                } catch (InterruptedException ignored) { }
            }

        }
    }
}
