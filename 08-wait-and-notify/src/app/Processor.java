package app;

/**
 * Processor
 */
public class Processor {

    private Object lock = new Object();

    public void produce() throws InterruptedException {
        synchronized (lock) {
            System.out.println("Start produce ...");
            lock.wait();
            System.out.println("Resume produce");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(3000);
        synchronized (lock) {
            System.out.println("Start consumer");
            lock.notify();
            Thread.sleep(5000);
            System.out.println("End consume method");
        }
    }

}