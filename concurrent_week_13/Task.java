import java.util.concurrent.Semaphore;


public class Task implements Runnable{
	Semaphore semaphore = new Semaphore(4);

	public void run(){
		try{
			
			try {
				semaphore.acquire();
				System.out.println(Thread.currentThread().getName()+ " has arrived");
				System.out.println(Thread.currentThread().getName()+ " is eating");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}finally{
			semaphore.release();
			System.out.println(Thread.currentThread().getName()+ " has left");
		}
	}
}
