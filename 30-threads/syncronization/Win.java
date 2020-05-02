package syncronization;

public class Win {

    static int varible = 1;

    public static void main(String... args) throws InterruptedException {

        Runnable r = new Job();

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(varible); // 0
    }


    protected static class Job implements Runnable {

        @Override
        public void run() { modifyVariable(); }

        public synchronized void modifyVariable() {
            if (Win.varible > 0) {
                try {Thread.sleep(500);} catch (InterruptedException ignored) {}
                Win.varible--;
            }
        }
    }
}