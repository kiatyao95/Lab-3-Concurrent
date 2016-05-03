import java.util.ArrayList;
import java.util.Random;

public class Task implements Runnable {
	double[][] data = new double[200][100];
	Random rand = new Random();
	int row;
	int counter=0;
	double sumOfRow;
	
	


	public Task(double[][] data, int row) {
		this.data = data;
		this.row = row;
	}
	
	public double getSum(){
		return this.sumOfRow;
	}

	public void run() {
	
		performFunction();
	
		
	}

	public void performFunction() {
		double sumOfRow = 0;
		double min = 99999999.99;
		while(counter<2){
			
			for(int i=0; i<data[1].length;i++){
				sumOfRow=sumOfRow + (i*(data[row][i]*data[row][i]));
			}
			if(sumOfRow<min){
				min=sumOfRow;
			}

			for(int i=0; i<data[1].length;i++){
				double randValue = (rand.nextInt(100) - 50);
				randValue=randValue/100;
				data[row][i]=data[row][i]+ randValue;
				
				if(data[row][i]>5.12){
					data[row][i]=5.12;
				}else if(data[row][i]<-5.12){
					data[row][i]=-5.12;
				}
			
			}
			counter++;


	}
		System.out.println("Min value: "+sumOfRow);

		this.sumOfRow = sumOfRow;
	
	}


}