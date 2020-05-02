public class WaitNotify {


    public static void main(String... args) {

        Runnable r = new Runnable33();
        Thread t = new Thread(r);

        t.start();

        synchronized (r) {

            try {
                System.out.println("Waiting...");
                r.wait(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted.");
            }
            System.out.println("Done.");

        }
    }
}


class Runnable33 implements Runnable {


    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("Loop.");
                    Thread.sleep(500);
                    if (i == 5) {
                        notify();
                    }
                } catch (InterruptedException ignored) { }
            }

        }
    }
}