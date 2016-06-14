import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Withdraw implements Runnable {
	int decrease;
	int amount;
	private AtomicInteger balance;
	ReentrantLock lock = new ReentrantLock();
	Condition myCondition = lock.newCondition();

	public Withdraw(int decrease, AtomicInteger balance,ReentrantLock lock, Condition myCondition) {
		this.decrease = decrease;
		this.balance = balance;
		this.lock = lock;
		this.myCondition = myCondition;
	}

	public void run() {
		while (true) {
			lock.lock();
			try {
				while (this.balance.intValue() < this.decrease) {
					System.out
							.println("Not enough balance, waiting for more deposit");
		
						try {
							myCondition.await();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
				}
						
		
				
			} finally {
				lock.unlock();
				balance.set(balance.get() - decrease);
				System.out.println("Reduce by 40, Balance is: " + balance.get());
				try {
					Thread.sleep(1000);

				} catch (Exception e) {

				}
			}



		}
	}

}
