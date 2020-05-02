package syncronization;

public class TwoJobsFail {

    static int varible = 1;

    public static void main(String... args) throws InterruptedException {

        Thread t1 = new Thread(new Job());
        Thread t2 = new Thread(new Job());
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(varible);
    }


    protected static class Job implements Runnable {

        @Override
        public void run() { modifyVariable(); }

        public synchronized void modifyVariable() {
            if (TwoJobsFail.varible > 0) {
                try {Thread.sleep(500);} catch (InterruptedException ignored) {}
                TwoJobsFail.varible--;
            }
        }
    }
}



