package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Worker 注意时间
 */
public class Worker {
    private Random random = new Random();
    Object lock1 = new Object();
    Object lock2 = new Object();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void main() {
        System.out.println("Starting ...");
        long start = System.currentTimeMillis();

        // work
        Thread t1 = new Thread(() -> {
            process();
        });

        Thread t2 = new Thread(() -> {
            process();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            // TODO: handle exception
        }

        long end = System.currentTimeMillis();
        System.out.println("Time take: " + (end - start));
        System.out.println("list1: " + list1.size() + " list2: " + list2.size());

    }

    private void stageOne() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                // TODO: handle exception
            }
            list1.add(random.nextInt(100));
        }
    }

    private void stageTwo() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                // TODO: handle exception
            }
            list2.add(random.nextInt(100));
        }
    }

    private void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }
}