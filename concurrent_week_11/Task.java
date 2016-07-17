import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Task implements Runnable {

	Fork leftFork;
	Fork rightFork;
	int philosopherID;
	Random rand = new Random();

	public Task(Fork leftFork, Fork rightFork, int philosopherID) {
		this.leftFork = leftFork;
		this.rightFork = rightFork;
		this.philosopherID = philosopherID;

	}

	public void run() {
		while (true) {

			if (leftFork.get() == false) {
				rightFork.release();
				leftFork.release();
				System.out.println("Philosopher: " + philosopherID
						+ " cant eat");
				try {
					Thread.sleep(rand.nextInt(2)*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (rightFork.get() == false) {
				rightFork.release();
				leftFork.release();
				System.out.println("Philosopher: " + philosopherID
						+ " cant eat");
				try {
					Thread.sleep(rand.nextInt(2)*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				leftFork.get();
				System.out.println("Fork: " + leftFork.getForkID() + " taken & Fork: " + rightFork.getForkID() + " taken \nPhilosopher: " + philosopherID
						+ " is eating");
				try {
					Thread.sleep((rand.nextInt(3)+3)*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Fork: " + leftFork.getForkID()
						+ " released");
				System.out.println("Fork: " + rightFork.getForkID()
						+ " released");

			}
			this.leftFork.release();
			this.rightFork.release();
			try {
				Thread.sleep((rand.nextInt(3)+4)*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
