import java.util.*;

public class Task1 implements Runnable {

	private LinkedList<Integer> numberList = new LinkedList<Integer>();
	Random rand = new Random();
	int num;
	int counter = 0;

	public Task1(LinkedList<Integer> numberList) {
		this.numberList = numberList;
	}

	public void generateNumber() {
		num = rand.nextInt(100);
		numberList.add(num);

		for (int i = 0; i < numberList.size(); i++) {
			System.out.print(numberList.get(i) + ",");
		}
		System.out.println("");
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
							.println("5 number generated, waiting for 5 seconds");
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
