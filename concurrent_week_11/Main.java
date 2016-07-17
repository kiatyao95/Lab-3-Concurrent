import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
	public static void main(String args[]){
		Fork[] fork = new Fork[5];
		Task[] task = new Task[5];
		for(int i=0; i<fork.length;i++){
			fork[i] = new Fork(i);
		}
		task[0] = new Task(fork[0],fork[1],1);
		task[1] = new Task(fork[1],fork[2],2);
		task[2] = new Task(fork[2],fork[3],3);
		task[3] = new Task(fork[3],fork[4],4);
		task[4] = new Task(fork[4],fork[0],5);
		
		ExecutorService exec = Executors.newFixedThreadPool(5);
		
		for(int i=0; i<fork.length;i++){
		exec.execute(task[i]);
		}
	}

}
