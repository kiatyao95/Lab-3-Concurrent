import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Task1 implements Runnable {

	private BlockingQueue<Integer> numberList = new ArrayBlockingQueue<Integer>(5);
	Random rand = new Random();
	int num;
	int counter = 0;

	public Task1(BlockingQueue<Integer> numberList) {
		this.numberList = numberList;
	}

	public void generateNumber() {
		num = rand.nextInt(100);
		numberList.add(num);


			System.out.println(numberList);


	}

	public void run() {
		task();
	}

	public void task() {
		while (true) {
			synchronized (this.numberList) {
				while (numberList.size() >= 5) {
					System.out.println("Queue full, System waiting");
					try {
						this.numberList.wait();
					} catch (Exception e) {

					}
				}

				generateNumber();
				this.numberList.notifyAll();
				counter++;

			}
			if (counter >= 5) {
				try {
					System.out
							.println("5 numbers generated, waiting for 5 seconds");
					counter = 0;
					Thread.sleep(5000);

				} catch (Exception e) {
				}
			} else {

				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
			}

		}
	}

}
