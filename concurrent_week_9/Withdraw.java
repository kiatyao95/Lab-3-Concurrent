import java.util.concurrent.atomic.AtomicInteger;

public class Withdraw implements Runnable {
	int decrease;
	int amount;
	private AtomicInteger balance;

	public Withdraw(int decrease, AtomicInteger balance) {
		this.decrease = decrease;
		this.balance = balance;
	}

	public void run() {
		while (true) {
			synchronized(this.balance){
			while (this.balance.intValue() < this.decrease) {
				System.out
				.println("Not enough balance, waiting for more deposit");
				try {
				
					this.balance.wait();
				} catch (Exception e) {

				}
			}
			}
			
			balance.set(balance.get()- decrease); 
			System.out.println("Reduce by 40, Balance is: "+balance.get());
			try {
				Thread.sleep(1000);

			} catch (Exception e) {

			}
		}
	}

}
