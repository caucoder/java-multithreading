package app;

/**
 * ApplicationAnonymous
 */
public class ApplicationAnonymous {

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Index: " + i);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }).start();

    }
}