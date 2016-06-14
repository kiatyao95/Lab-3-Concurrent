import java.util.concurrent.atomic.AtomicInteger;


public class Deposit implements Runnable {

	private int increase;
	private int amount;
	private int sleepTime;
	private AtomicInteger balance;
	
	public Deposit(int increase,AtomicInteger balance, int sleepTime){
		this.increase = increase;
		this.balance= balance;
		this.sleepTime = sleepTime;
	}
	public void run() {
		while(true){
			synchronized(balance){
			System.out.println("Adding Balance by: "+ increase);
			balance.addAndGet(increase);
			System.out.println("Balance: "+balance.get());
			
			this.balance.notifyAll();

			}
			try {
				Thread.sleep(sleepTime);
				
			} catch (Exception e) {

			}
		}
		
	}
	
	

}
