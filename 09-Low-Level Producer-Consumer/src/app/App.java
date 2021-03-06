package app;

public class App {
    public static void main(String[] args) throws Exception {
        Processor processor = new Processor();
        Thread t1 = new Thread(() -> {
            try {
                processor.produce();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                processor.consume();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

/**
 * list size: 10;take value: 0
 * 
 * list size: 10;take value: 1
 * 
 * list size: 10;take value: 2
 * 
 * list size: 10;take value: 3
 * 
 * list size: 10;take value: 4
 * 
 * list size: 10;take value: 5
 */