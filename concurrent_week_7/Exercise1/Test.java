import java.util.Random;


public class Test {

	public static void main(String[] args) {

Random rand = new Random();
double random=rand.nextInt(1024)-512;
random = random/100;

System.out.printf("%.2f",random);


	}

}
