package ex02_encapsulation;

import java.util.Random;

public class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    public static void main(String[] args) {
        BankAccount alice = new BankAccount("Alice", 500.00);
        System.out.println(alice.getAccountNumber());
        // Bbob   = new BankAccount("Bob",   0.00);
    }

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;

        Random rand = new Random();
        int num = rand.nextInt(100000);

        this.accountNumber = String.valueOf(num);
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean deposit(double amount) {
        if (amount < 0) {
            return false;
        }

        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount < 0) {
            return false;
        }

        if (amount > getBalance()) {
            System.out.println("Insufficient funds");
            return false;
        }

        this.balance -= amount;
        return true;
    }

    public String getAccountHolder() {
        return this.accountHolder;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }
}
