package app;

/**
 * Account
 */
public class Account {
    private int balance = 10000;

    public void deposite(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account acc1, Account acc2, int amount) {
        acc1.deposite(amount);
        acc2.withdraw(amount);
    }

}