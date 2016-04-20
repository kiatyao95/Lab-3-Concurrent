import java.util.Random;

public class Move implements Runnable {
	private int[][] array=new int[8][8];

	public Move(int[][] array) {
		this.array = array;
	}

	public void run() {	
		moveRobot();
	}

	public void moveRobot() {
	
			Random rand = new Random();

			int randomRow;
			int randomColumn;

			int previousRow = 0;
			int previousColumn = 0;

			int newRow;
			int newColumn;

			while (true) {
				synchronized (this.array) {
				if (previousRow == 0) {
					randomRow = rand.nextInt(2);
				} else if (previousRow == 7) {
					randomRow = rand.nextInt(2) - 1;
				}else{
					randomRow = rand.nextInt(3) - 1;
				}
				
				if (previousColumn == 0) {
					randomColumn = rand.nextInt(2);
				} else if (previousColumn == 7) {
					randomColumn = rand.nextInt(2) - 1;
				}else{
					randomColumn = rand.nextInt(3) - 1;
				}

				newRow = previousRow + randomRow;
				newColumn = previousColumn + randomColumn;

				array[previousRow][previousColumn] = 0;
				array[newRow][newColumn] = 1;

				previousRow = newRow;
				previousColumn = newColumn;
				
				}
				/*printArray(array);
				System.out.println();*/
				try {
					Thread.sleep(600);
				} catch (Exception e) {
				}
			
		}
	}

	/*public void printArray(int[][] array) {
		synchronized(this){
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array.length; column++) {
				System.out.print(array[row][column]);
				System.out.print("\t");
			}
			System.out.println();
		}
		
		}
	} */
}
