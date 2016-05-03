import java.util.ArrayList;
import java.util.Random;

public class Main{
	public static void main(String args[]){
		
		double[][] data = new double[200][100];
		double randValue;
		Random rand = new Random();
		double min=999999999999.99;
		long time = System.currentTimeMillis();
		
	
		
		Thread[] threadArray = new Thread[200];
		
		for(int row=0; row<data.length;row++){
			for(int column=0;column<data[1].length;column++){
				randValue= (rand.nextInt(1024) - 512);
				randValue = randValue/100;
				data[row][column]=randValue;
			}

		}

		
		

	for(int i=0; i<threadArray.length ; i++){
		 Task t1 = new Task(data,i);
		 threadArray[i]= new Thread(t1);
		 threadArray[i].start();
		 try{
				threadArray[i].join();
			}catch (InterruptedException e) {
	            e.printStackTrace();
	        }

		}
	
	

	


	System.out.println("EXE TIME : "+ (System.currentTimeMillis() - time));
	
	
	}
}