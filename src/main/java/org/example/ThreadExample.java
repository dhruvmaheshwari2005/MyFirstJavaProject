package org.example;

class Bank {
    private static float balance = 0;

    synchronized static void deposit(float amount) {
        balance += amount;
    }

    synchronized static void withdraw(float amount) {
        balance -= amount;
    }

    static void showBalance() {
        System.out.println(Thread.currentThread().getName());
        synchronized (Bank.class) {
            System.out.printf("Your balance is %f\n", balance);
        }
    }


}

class Thread1 implements Runnable {
    @Override
    public void run() {
        Bank.deposit(1000f);
        Bank.withdraw(1000f);
        Bank.deposit(1000f);
        Bank.showBalance();
    }
}

class Thread2 implements Runnable {
    @Override
    public void run() {
        Bank.deposit(900f);
        Bank.deposit(100f);
        Bank.showBalance();
    }
}

class Thread3 implements Runnable {
    @Override
    public void run() {
        Bank.deposit(1f);
        Bank.withdraw(900f);
        Bank.showBalance();
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1(), "Thread1");
        Thread t2 = new Thread(new Thread2(), "Thread2");
        Thread t3 = new Thread(new Thread3(), "Thread3");
        t1.start();
        t2.start();
        t3.start();
    }
}
