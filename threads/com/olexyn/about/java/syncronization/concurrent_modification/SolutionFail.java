package com.olexyn.about.java.syncronization.concurrent_modification;

public class SolutionFail {

    private static int variable = 1;

    public static void main(String... args) throws InterruptedException {

        Thread t1 = new Thread(new Job());
        t1.setName("T1");
        Thread t2 = new Thread(new Job());
        t2.setName("T2");

        // set both threads to RUNNABLE.
        t1.start();
        t2.start();

        // inject both threads
        t1.join();
        Thread.sleep(100);
        t2.join();

        printThread(" concluded with: " + variable); // 0
    }


    /**
     * Because two job instances are created ?? synchronization is ineffective.
     */
    private static class Job implements Runnable {

        @Override
        public void run() {
            try {modifyVariable(); } catch (InterruptedException ignored) { }
        }

        public synchronized void modifyVariable() throws InterruptedException {
            printThread(" finds: (variable > 0) is " + (variable>0));
            if (variable > 0) {
                Thread.sleep(200); // add delay between condition and modification.
                variable--;
                printThread(" reduced to: " + variable);
            }
        }
    }

    private static void printThread(String s){
        System.out.println(Thread.currentThread().getName() + s);
    }
}

