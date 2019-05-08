package app;

class Runnerr implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Index: " + i);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}

/**
 * ApplicationImplement
 */
public class ApplicationImplement {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnerr());
        Thread t2 = new Thread(new Runnerr());
        t1.start();
        t2.start();
    }

}