package app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 200; i++) {
            executor.submit(() -> {
                Connection.getConnectionn().connect();
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}