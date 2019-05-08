package app;

public class AppSynchronized {
    private int count = 0;

    public static void main(String[] args) throws Exception {
        AppSynchronized app = new AppSynchronized();
        app.doWork();
    }

    // thread获取内部锁，确保原子操作
    private synchronized void increment() {
        count++;
    }

    public void doWork() {
        Thread t1 = new Thread(() -> {
            System.out.println("start thread01");
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("start thread02");
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();

        // after t1,t2 finished
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println("The count: " + count);

    }
}