import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Genetic implements Runnable {
	private double[][] population;
	double sumOfRow;
	int generation;
	ArrayList<Double> arrayOfMin = new ArrayList<Double>();

	// init
	Genetic(double[][] population) {
		this.population = new double[population.length][population[0].length];

		for (int i = 0; i < population.length; i++) {
			System.arraycopy(population[i], 0, this.population[i], 0,
					population[i].length);
		}
	}

	public void run() {
		generation = 0;
		double[][] newGeneration = new double[this.population.length][this.population[0].length];

		System.out.println("START");

		while (generation < 500000) {
			printStatus(generation);
			int counter = 0;

			while (counter < this.population.length) {

				int parent1 = tournamentSelection(-1);
				int parent2 = tournamentSelection(parent1);
				double child[][] = new double[2][this.population[0].length];
				child = crossover(parent1, parent2);
				mutate(child);
				System.arraycopy(child[0], 0, newGeneration[counter], 0,
						child[0].length);
				System.arraycopy(child[1], 0, newGeneration[counter + 1], 0,
						child[0].length);

				counter += 2;
			}

			replace(newGeneration);
			generation++;
		}
		System.out.println("END");
	}

	/*
	 * get fitness value according to formula provided
	 */
	public double getFitness(int index) {
		double sum = 0;
		for (int i = 0; i < this.population[index].length - 1; i++) {
			// RosenBrock Function
			sum += 100
					* Math.pow(
							(this.population[index][i + 1])
									- Math.pow(this.population[index][i], 2), 2)
					+ Math.pow((this.population[index][i]) - 1, 2);

		}

		return sum;
	}

	/*
	 * random first parent and second parent check if duplicated compare fitness
	 * return index of parent
	 */
	public int tournamentSelection(int i) {
		Random rand = new Random();
		int firstSelection = rand.nextInt(this.population.length);
		int secondSelection = rand.nextInt(this.population.length);
		int thirdSelection = rand.nextInt(this.population.length);

		// check if 2 same parent is choosen
		while (firstSelection == secondSelection || firstSelection == i
				|| secondSelection == i
				|| getFitness(firstSelection) > getFitness(secondSelection)
				|| getFitness(firstSelection) > getFitness(thirdSelection)) {
			firstSelection = rand.nextInt(this.population.length);
			secondSelection = rand.nextInt(this.population.length);
			thirdSelection = rand.nextInt(this.population.length);
		}

		// compare and return parent with best fitness
		// lower is better
		return firstSelection;
	}

	/*
	 * random a cut off point crossover return child
	 */
	public double[][] crossover(int parent1, int parent2) {
		Random rand = new Random();
		int cutOffPoint = rand.nextInt(this.population[parent1].length);
		int cutOffPoint2 = rand.nextInt(this.population[parent1].length);
		double[][] child = new double[2][this.population[parent1].length];

		if (rand.nextInt(10) <= 7) // 70% chance of crossover
		{
			for (int i = 0; i < this.population[parent1].length; i++) {
				double val = i > cutOffPoint && i < cutOffPoint2 ? this.population[parent2][i]
						: this.population[parent1][i];
				double val2 = i > cutOffPoint && i < cutOffPoint2 ? this.population[parent1][i]
						: this.population[parent2][i];
				child[0][i] = val;
				child[1][i] = val2;
			}

		} else // 30% chance of direct copy of best parent
		{
			int bestParent = getFitness(parent1) < getFitness(parent2) ? parent1
					: parent2;
			System.arraycopy(this.population[bestParent], 0, child[0], 0,
					this.population[bestParent].length);
			System.arraycopy(this.population[bestParent], 0, child[1], 0,
					this.population[bestParent].length);

		}
		return child;
	}

	/*
	 * loop through every cell with a 1% chance of mutating child
	 */
	public void mutate(double[][] child) {
		Random rand = new Random();
		for (int r = 0; r < child.length; r++) {
			for (int i = 0; i < child[1].length; i++) {
				if (rand.nextInt(100) < 1) {

					double RandomValue = rand.nextInt(1000) - 500;
					if (generation < 500) {
						RandomValue = RandomValue / 1000;
					} else {
						RandomValue = RandomValue / 10000;
					}
					double newNumber = child[r][i] + (RandomValue);

					if (child[r][i] > 2.048 || child[r][i] < -2.048) {
						child[r][i] = 0;
					} else {
						child[r][i] = newNumber;
					}

				}

			}

		}
	}

	/*
	 * replace population with new generation
	 */
	public void replace(double[][] newGen) {
		for (int i = 0; i < newGen.length; i++) {
			System.arraycopy(newGen[i], 0, this.population[i], 0,
					newGen[i].length);
		}

	}

	// print min, max, median
	public void printStatus(int generation) {
		sumOfRow = 0;
		double[] results = new double[this.population.length];
		for (int i = 0; i < this.population.length; i++) {
			double fitness = getFitness(i);
			sumOfRow += fitness;
			results[i] = fitness;
		}
		Arrays.sort(results);
		System.out.println("Generation : " + generation);
		System.out.println("Max : " + results[this.population.length - 1]);
		System.out.println("Min : " + results[0]);
		System.out.println("Median : " + sumOfRow / this.population.length);
		System.out
				.println("----------------------------------------------------------");
		this.arrayOfMin.add(results[0]);

	}

	public ArrayList<Double> getArrayOfMin() {

		return this.arrayOfMin;

	}
}
