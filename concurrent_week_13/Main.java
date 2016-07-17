import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main {
	
	public static void main(String args[]){
		Task task = new Task();
		ExecutorService exec = Executors.newFixedThreadPool(5);
		
		for(int i=0;i<5;i++){
			exec.execute(task);
		}
		try {
			while(!exec.awaitTermination(0, TimeUnit.SECONDS)){
				exec.shutdown();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
