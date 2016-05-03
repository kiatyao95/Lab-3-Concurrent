import java.util.ArrayList;
import java.util.Random;

public class Task implements Runnable {
	double[] data = new double[100];
	Random rand = new Random();
	int counter=0;
	double sumOfRow;
	
	


	public Task(double[] data) {
		this.data = data;
	}
	
	public double getSum(){
		return this.sumOfRow;
	}

	public void run() {
	
		performFunction();
	
		
	}

	public void performFunction() {
		double sumOfRow;
		double[] tempData = new double[100];
		double tempSumOfRow ;
		double min = 99999999.99;

		while(counter<350){
			sumOfRow = 0;
			tempSumOfRow = 0;
			
			for(int i=0; i<data.length;i++){
				sumOfRow=sumOfRow + (i*(data[i]*data[i]));
			}
			if(sumOfRow<min){
				min=sumOfRow;
			}

			for(int i=0; i<data.length;i++){
				double randValue = (rand.nextInt(100) - 50);
				randValue=randValue/100;
				tempData[i]=data[i] - randValue;
				
				if(tempData[i]>5.12 || tempData[i]<-5.12){
					tempData[i]=0;
				}

			
			}
			for(int i=0; i<data.length;i++){
				tempSumOfRow=tempSumOfRow + (i*(tempData[i]*tempData[i]));
			}
			if(tempSumOfRow<min){
				for(int i=0; i<data.length;i++){
					data[i]=tempData[i];
				}
			}
			
			
			counter++;


	}
		System.out.println("Min value: "+min);

	
	
	}


}