package app;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                System.out.println("Starting...");
                int duration = random.nextInt(4000);

                if (duration > 2000) {
                    throw new IOException("Sleep too long.");
                }

                Thread.sleep(duration);
                System.out.println("Finished...");
                return duration;
            }
        });

        executor.shutdown();

        try {
            System.out.println("The Result is: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            IOException ex = (IOException) e.getCause();
            System.out.println(ex.getMessage());

        }

    }
}