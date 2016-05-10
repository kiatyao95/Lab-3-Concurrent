import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Task2 implements Runnable {
	private BlockingQueue<Integer> numberList = new ArrayBlockingQueue<Integer>(5);

	public Task2(BlockingQueue<Integer> numberList) {
		this.numberList = numberList;
	}

	public void run() {
		task();
		
	}
	
	public void task(){
		while (true) {
			synchronized (this.numberList) {
				while (this.numberList.size() <= 0) {
					System.out.println("System empty, waiting for queue to be added");
					try {
						this.numberList.wait();
					} catch (Exception e) {

					}

				}
				
				System.out.println("Remove: " + numberList.peek());
				numberList.poll();
				this.numberList.notifyAll();
			}
			try {
				Thread.sleep(1200);
				
			} catch (Exception e) {

			}
		}

	}
}
