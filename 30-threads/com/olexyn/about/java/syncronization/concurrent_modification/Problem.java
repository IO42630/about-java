package com.olexyn.about.java.syncronization.concurrent_modification;

public class Problem {

    private static int variable = 1;

    public static void main(String... args) throws InterruptedException {

        Job job = new Job();

        Thread t1 = new Thread(job);
        t1.setName("T1");
        Thread t2 = new Thread(job);
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
     * Main injects T1 into Main.
     * T1 evaluates condition as true.
     * T1 sleeps.
     * Main wakes up (100ms<200ms).
     * Main injects T2 into Main.
     * T2 evaluates condition as true.
     * T2 sleeps.
     * T1 modifies.
     * T2 modifies.
     */
    private static class Job implements Runnable {

        @Override
        public void run() {
            try {modifyVariable(); } catch (InterruptedException ignored) { }
        }

        public void modifyVariable() throws InterruptedException {
            if (variable > 0) {
                printThread(" found: " + variable);

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

