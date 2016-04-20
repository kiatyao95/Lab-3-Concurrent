import java.util.LinkedList;

public class Main {
	public static void main(String arg[]) {
		LinkedList<Integer> numberList = new LinkedList<Integer>();
		
		Task1 test = new Task1(numberList);
		Task2 test2= new Task2(numberList);
		
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test2);
		
		t1.start();
		t2.start();
		
		try{
			t1.join();
			t2.join();
		}catch (InterruptedException e) {
            e.printStackTrace();
        }

	}
}
