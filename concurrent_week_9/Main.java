import java.util.concurrent.atomic.AtomicInteger;


public class Main {

	public static void main(String[] args) {

		AtomicInteger balance = new AtomicInteger(100);
		
		Withdraw user1= new Withdraw(40,balance);
		Deposit user2= new Deposit(10,balance,2000);
		Deposit user3= new Deposit(20,balance,1500);
		
		Thread t1 = new Thread(user1);
		Thread t2 = new Thread(user2);
		Thread t3 = new Thread(user3);
		
		t1.start();
		t2.start();
		t3.start();
		
		try{
			t1.join();
			t2.join();
			t3.join();
		}catch (InterruptedException e) {
            e.printStackTrace();
        }

	}

}
