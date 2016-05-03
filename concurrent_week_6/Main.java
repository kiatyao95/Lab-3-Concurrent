import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String args[]){
		
		double[][] data = new double[200][100];
		double randValue;
		 Task[] myTask = new Task[200];
		Random rand = new Random();
		double min=999999999999.99;
		long time = System.currentTimeMillis();
		
		Executor exec = Executors.newFixedThreadPool(4);
	
		
		Thread[] threadArray = new Thread[200];
		
		for(int row=0; row<data.length;row++){
			for(int column=0;column<data[1].length;column++){
				randValue= (rand.nextInt(1024) - 512);
				randValue = randValue/100;
				data[row][column]=randValue;
			}

		}

		
		

	for(int i=0; i<threadArray.length ; i++){
		
		 myTask[i] = new Task(data[i]);
		 exec.execute(myTask[i]);
		 
		 

		}
	
	try{
		while(!((ExecutorService) exec).awaitTermination(1, TimeUnit.SECONDS)){
			((ExecutorService) exec).shutdownNow();
		}
	}catch (InterruptedException e) {
            e.printStackTrace();
        }



		System.out.println("EXE TIME : " + (System.currentTimeMillis() - time));

}
}