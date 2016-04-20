import java.util.LinkedList;

public class Task2 implements Runnable {
	private LinkedList<Integer> numberList = new LinkedList<Integer>();

	public Task2(LinkedList<Integer> numberList) {
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
				
				System.out.println("Remove: " + numberList.get(0));
				numberList.remove(0);
				this.numberList.notifyAll();
			}
			try {
				Thread.sleep(1200);
				
			} catch (Exception e) {

			}
		}

	}
}
