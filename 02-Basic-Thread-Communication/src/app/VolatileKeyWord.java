package app;

import java.util.Scanner;

/**
 * VolatileKeyWord
 * 
 * stop a thread
 */

class Processor extends Thread {

    private volatile boolean running = true;

    @Override
    public void run() {
        // reading variable
        while (running) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    public void shutdown() {
        this.running = false;
    }
}

public class VolatileKeyWord {

    public static void main(String[] args) {
        Processor p = new Processor();
        p.start();
        System.out.println("Press enter to stop");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        // writting in main thread
        p.shutdown();
    }
}