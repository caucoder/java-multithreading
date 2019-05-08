package app;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Runner
 */
public class Runner {

    private Account acc1 = new Account();
    private Account acc2 = new Account();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    private Random random = new Random();

    // account1 to account 2
    public void firstThread() {
        lock1.lock();
        lock2.lock();
        try {
            for (int i = 0; i < 10000; i++) {
                Account.transfer(acc1, acc2, random.nextInt(100));
            }
        } finally {
            lock2.unlock();
            lock1.unlock();
        }

    }

    // account2 to account1
    public void secondThread() {
        lock1.lock();
        lock2.lock();
        try {
            for (int i = 0; i < 10000; i++) {
                Account.transfer(acc2, acc1, random.nextInt(100));
            }
        } finally {
            lock2.unlock();
            lock1.unlock();
        }
    }

    public void finished() {
        System.out.println("Account1 balance: " + acc1.getBalance());
        System.out.println("Account2 balance: " + acc2.getBalance());
        System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));
    }
}