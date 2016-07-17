import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {

	int forkID;
	ReentrantLock lock = new ReentrantLock();
	

	

	public Fork(int forkID) {
		this.forkID = forkID;
	}

	public boolean get() {
		boolean test;
		if (lock.tryLock()) {
			test = true;
		} else {
		
			test = false;
		}
		return test;

	}

	public void release() {
		if(lock.isHeldByCurrentThread()){
		lock.unlock();
		}

	}
	
	public int getForkID(){
		return forkID;
	}

}
