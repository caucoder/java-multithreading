package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in  = new Scanner(System.in);
        System.out.println("Please input something.");
        String content = in.nextLine();
        System.out.println("hello "+content);
    }
}