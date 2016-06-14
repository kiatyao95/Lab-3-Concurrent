import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Deposit implements Runnable {

	private int increase;
	private int amount;
	private int sleepTime;
	private AtomicInteger balance;
	ReentrantLock lock = new ReentrantLock();
	Condition myCondition = lock.newCondition();

	public Deposit(int increase, AtomicInteger balance, int sleepTime,ReentrantLock lock, Condition myCondition) {
		this.increase = increase;
		this.balance = balance;
		this.sleepTime = sleepTime;
		this.lock = lock;
		this.myCondition = myCondition;
	}

	public void run() {
while(true){
		lock.lock();
		try {
			System.out.println("Adding Balance by: " + increase);
			balance.addAndGet(increase);
			System.out.println("Balance: " + balance.get());
			myCondition.signalAll();


		} finally {
			lock.unlock();
			try {
				Thread.sleep(sleepTime);

			} catch (Exception e) {

			}
		}


	}
	}

}
