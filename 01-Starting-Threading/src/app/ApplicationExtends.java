package app;

class Runner extends Thread {
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
 * ApplicationExtends
 */
public class ApplicationExtends {
    public static void main(String[] args) {
        Runner runner1 = new Runner();
        Runner runner2 = new Runner();
        runner1.start();
        runner2.start();
    }

}