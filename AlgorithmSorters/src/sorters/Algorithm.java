package sorters;
import java.io.FileNotFoundException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
/**
 * Algorithm Class - Tests the SortingAlgorithms class by creating an array or arrayList and calling the class'
 * methods, then calculating the total time it took to run the specific algorithm and saving it into a csv file 
 * called algorithm.csv 
 * @author Dante Anzalone
 * @version 2023-09 (4.29.0)
 */
public class Algorithm 
{
	public static void main (String [] args) throws FileNotFoundException
	{		
		int AMOUNT, AMOUNTBUBBLE;
		long before;
		int [] array;

		ArrayList <Integer> list;
		
		PrintWriter write;
		Random rand;
		SortingAlgorithms solver;
		
		solver = new SortingAlgorithms();

		AMOUNT = 100;
		AMOUNTBUBBLE = 100;
		write = new PrintWriter ("algorithmLowest.csv");
		
		rand = new Random ();
		
		array = new int [AMOUNT];
		list = new ArrayList <Integer> ();
				
		for (int i = 0; i < AMOUNTBUBBLE; i++)
		{
			list.add(rand.nextInt(5000));
		}
		
		write.printf("Sort Algorithm, Time (milliseconds), Total Elements%n");
		
		// For insertion sort
		array = solver.createNewArray(AMOUNT);
		before = System.currentTimeMillis();
		solver.insertsIntoSort(array);
		write.printf("Insertion, %s, %s %n", System.currentTimeMillis() - before, AMOUNT);
		System.out.printf("%nValidation of Insertion Sort : %s", solver.validate(array));
		
		// For selection sort
		array = solver.createNewArray(AMOUNT);
		before = System.currentTimeMillis();
		solver.selectAndSort(array);
		write.printf("Selection, %s, %s %n", System.currentTimeMillis() - before, AMOUNT);
		System.out.printf("%nValidation of Selection Sort : %s", solver.validate(array));
		
		//For bubble sort
		before = System.currentTimeMillis();
		solver.bubbleSortLeast(list);
		write.printf("Bubble, %s, %s %n", System.currentTimeMillis() - before, AMOUNTBUBBLE);
		System.out.printf("%nValidation of Bubble Sort Sort : %s", solver.validate(list));
		
		// For merge sort
		array = solver.createNewArray(AMOUNT);
		before = System.currentTimeMillis();
		solver.mergeSort(array);
		write.printf("Merge, %s, %s %n", System.currentTimeMillis() - before, AMOUNT);
		System.out.printf("%nValidation of Merge Sort : %s", solver.validate(array));

		// For max-heap sort (referenced)
		array = solver.createNewArray(AMOUNT);
		before = System.currentTimeMillis();
		solver.heapMadness(array);
		write.printf("Max-Heap Sort, %s, %s %n", System.currentTimeMillis() - before, AMOUNT);
		System.out.printf("%nValidation of Heap Sort : %s", solver.validate(array));

		// For shell sort (referenced)
		array = solver.createNewArray(AMOUNT);
		before = System.currentTimeMillis();
		solver.shellSort(array);
		write.printf("Shell Sort, %s, %s %n", System.currentTimeMillis() - before, AMOUNT);
		System.out.printf("%nValidation of Shell Sort : %s", solver.validate(array));

		// For quick-sort (referenced)
		array = solver.createNewArray(AMOUNT);
		before = System.currentTimeMillis();
		solver.quickSort(array, 0, array.length - 1);
		write.printf("Quick-Sort, %s, %s %n", System.currentTimeMillis() - before, AMOUNT);
		System.out.printf("%nValidation of Quick Sort : %s", solver.validate(array));

		write.close();
	}
}
