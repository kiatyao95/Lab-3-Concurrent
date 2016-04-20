import java.util.*;

public class Main {

	public static void main(String[] args) {
		int[][] map = new int[8][8];
		map[0] = new int[8];
		map[1] = new int[8];
		map[2] = new int[8];
		map[3] = new int[8];
		map[4] = new int[8];
		map[5] = new int[8];
		map[6] = new int[8];
		map[7] = new int[8];
		
		

		Move robot1 = new Move(map);
		Print print1= new Print(map);

		Thread t1 = new Thread(robot1);
		Thread t2 = new Thread(print1);

		t1.start();
		t2.start();

  
		
		 try {
	            // wait for the threads to finish
	            t1.join();
	            t2.join();
	          
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		

	}

}
