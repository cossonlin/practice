package learning;

import java.util.concurrent.atomic.AtomicInteger;

public class AccountDanger implements Runnable {
    private volatile AtomicInteger acct = new AtomicInteger(50);

    public static void main(String[] args) {
        AccountDanger r = new AccountDanger();
        Thread one = new Thread(r);
        Thread two = new Thread(r);
        one.setName("Fred");
        two.setName("Lucy");
        one.start();
        two.start();
    }

    @Override
    public void run() {
        for (int x = 0; x < 5; x++) {
            makeWithdrawal(10);
            if (acct.intValue() < 0) {
                System.out.println("account is overdrawn!");
            }
        }
    }

    private void makeWithdrawal(int amt) {
        if (acct.intValue() >= amt) {
            System.out.println(Thread.currentThread().getName()
                    + " is going to withdraw");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            int result = acct.addAndGet(-amt);
            acct = new AtomicInteger(result);
            System.out.println(Thread.currentThread().getName()
                    + " completes the withdrawal with " + acct + " remaining");
        } else {
            System.out.println("Not enough in account for "
                    + Thread.currentThread().getName()
                    + " to withdraw. Current balance is " + acct);
        }
    }
}