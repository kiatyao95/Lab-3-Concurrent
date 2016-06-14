import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class Main {

	public static void main(String[] args) {

		AtomicInteger balance = new AtomicInteger(100);
		ReentrantLock lock = new ReentrantLock();
		Condition myCondition = lock.newCondition();
		
		Withdraw user1= new Withdraw(40,balance,lock,myCondition);
		Deposit user2= new Deposit(10,balance,2000,lock,myCondition);
		Deposit user3= new Deposit(20,balance,1500,lock,myCondition);
		
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
