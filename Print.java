public class Print implements Runnable {

	private int[][] array=new int[8][8];

	public Print(int[][] array) {
		this.array = array;
	}

	public void run() {
		printArray();

	}

	public void printArray() {
	
			while (true) {
				synchronized (this.array) {
				for (int row = 0; row < array.length; row++) {
					for (int column = 0; column < array.length; column++) {
						System.out.print(array[row][column]);
						System.out.print("\t");
					}
					System.out.println();
				}
				System.out.println("==========================================================");
				}
				try {
					Thread.sleep(300);
				} catch (Exception e) {
				}
			

		}
	}
}
