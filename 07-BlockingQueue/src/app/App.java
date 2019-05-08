package app;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);
    private static Random random = new Random();

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");

        Thread t1 = new Thread(() -> {
            try {
                producer();
            } catch (InterruptedException e) {
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(3000);
                consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }

    public static void consumer() throws InterruptedException {
        while (true) {
            if (random.nextInt(10) == 0) {
                // Retrieves and removes the head of this queue,
                // waiting if necessary until an element becomes available.
                Integer value = queue.take();
                System.out.println("Take value: " + value);
            }
        }
    }

    public static void producer() throws InterruptedException {
        while (true) {
            // 当添加到最大容量的时候会阻塞,而不是使用add方法
            queue.put(random.nextInt(100));
            System.out.println("queue's size: " + queue.size());
            Thread.sleep(1000);
        }
    }
}