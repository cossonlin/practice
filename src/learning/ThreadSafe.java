package learning;

import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafe implements Runnable {
	private static ConcurrentHashMap<String, Integer> acct = new ConcurrentHashMap<>();

	public static void main(String[] args) {
		acct.put("account", 50);
		ThreadSafe r = new ThreadSafe();
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
			if (acct.get("account") < 0) {
				System.out.println("account is overdrawn!");
			}
		}
	}

	private void makeWithdrawal(int amt) {
		if (acct.get("account") >= amt) {
			System.out.println(Thread.currentThread().getName()
					+ " is going to withdraw");
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
			}*/
			int result = acct.computeIfPresent("account", (k, v) -> v - amt);
			System.out.println(Thread.currentThread().getName()
					+ " completes the withdrawal with " + result + " remaining");
		} else {
			System.out.println("Not enough in account for "
					+ Thread.currentThread().getName()
					+ " to withdraw. Current balance is " + acct.get("account"));
		}
	}
}