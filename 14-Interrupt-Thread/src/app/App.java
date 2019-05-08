package app;

public class App {
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            System.out.println("Starting...");

            for (int i = 0; i < 10E8; i++) {

                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Interrupt");
                    break;
                }
                /**
                 * try { Thread.sleep(1); } catch (InterruptedException e) {
                 * System.out.println("Interrupt"); }
                 */
            }

        });

        t1.start();
        t1.interrupt();

        t1.join();

        System.out.println("Finished");
    }
}