package app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {
    private int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("starting " + id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Completed: " + id);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        // 创建线程，有两个线程
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // 提交5个任务
        for (int i = 0; i < 5; i++) {
            executor.submit(new Processor(i));
        }
        // 禁止提交任务
        executor.shutdown();
        System.out.println("All task submitted");
        // 如果在指定时间内阻塞，时间过后则执行接下来的代码
        executor.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("All tasks completed.");
    }
}