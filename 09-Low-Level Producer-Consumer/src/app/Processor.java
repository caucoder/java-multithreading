package app;

import java.util.LinkedList;
import java.util.Random;

/**
 * Processor
 */
public class Processor {

    private LinkedList<Integer> list = new LinkedList<Integer>();
    final int LIMIT = 10;
    Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
                while (list.size() == LIMIT) {
                    lock.wait();
                }
                // add to the end
                list.add(value++);
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {
        Random random = new Random();
        while (true) {
            synchronized (lock) {

                while (list.size() == 0) {
                    lock.wait();
                }

                System.out.print("list size: " + list.size());
                int value = list.removeFirst();
                System.out.println(";take value: " + value);
                lock.notify();
            }

            Thread.sleep(random.nextInt(1000));
        }
    }
}