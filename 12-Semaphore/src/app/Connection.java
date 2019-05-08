package app;

import java.util.concurrent.Semaphore;

/**
 * Connectionn
 */
public class Connection {
    private static Connection connection = new Connection();
    private int connections = 0;
    // allow 10 permits
    private Semaphore semaphore = new Semaphore(10);

    private Connection() {
    }

    public static Connection getConnectionn() {
        return connection;
    }

    public void connect() {
        try {
            semaphore.acquire();
            doConnect();
        } catch (InterruptedException e) {
        }

        semaphore.release();
    }

    public void doConnect() {
        synchronized (this) {
            connections++;
            System.out.println("Current connections (max 10 allowed): " + connections);
        }
        try {
            System.out.println("Working on connections " + Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        synchronized (this) {
            connections--;
            System.out.println("I'm done " + Thread.currentThread().getName()
                    + " Connection is released , connection count: " + connections);
        }
    }
}