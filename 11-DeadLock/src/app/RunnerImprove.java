package app;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Runner
 */
public class RunnerImprove {

    private Account acc1 = new Account();
    private Account acc2 = new Account();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    private Random random = new Random();

    private void acquireLocks(Lock lock1, Lock lock2) throws InterruptedException {
        while (true) {
            boolean gotFirstLock = false;
            boolean gotSecondLock = false;

            try {
                gotFirstLock = lock1.tryLock();
                gotSecondLock = lock2.tryLock();
            } finally {
                if (gotFirstLock && gotSecondLock) {
                    return;
                }

                if (gotFirstLock) {
                    lock1.unlock();
                }

                if (gotSecondLock) {
                    lock2.unlock();
                }
            }
            // Locks not acquired
            Thread.sleep(1);
        }
    }

    // account1 to account 2
    public void firstThread() throws InterruptedException {

        acquireLocks(lock1, lock2);
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
    public void secondThread() throws InterruptedException {
        acquireLocks(lock1, lock2);
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