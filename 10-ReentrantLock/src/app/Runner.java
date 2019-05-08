package app;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Scanner;

/**
 * Processor
 */
public class Runner {
    private int count = 0;
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition condition = reentrantLock.newCondition();

    private void increment() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }

    public void firstThread() {
        reentrantLock.lock();
        try {
            increment();
            System.out.println("waiting");
            condition.await();
            System.out.println("Woke up");
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            reentrantLock.unlock();
        }

    }

    public void secondThread() {
        reentrantLock.lock();
        try {
            System.out.println("Press the return Key");
            new Scanner(System.in).nextLine();
            System.out.println("Got the return key");
            condition.signal();
            increment();
        } catch (Exception e) {
        } finally {
            reentrantLock.unlock();

        }

    }

    public void finished() {
        System.out.println("The value is: " + this.count);
    }
}