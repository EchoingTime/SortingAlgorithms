package sorters;
import java.util.ArrayList;
import java.util.Random;
/**
 * SortingAlgorithms Class - A class that creates several sorting algorithms 
 * @author Dante Anzalone
 * @version 2023-09 (4.29.0)
 * @references 
 * https://www.tutorialspoint.com/data_structures_algorithms/shell_sort_algorithm.htm
 * https://www.youtube.com/watch?v=t0Cq6tVNRBA&t=295s&ab_channel=HackerRank
 * https://www.educative.io/answers/how-to-build-a-heap-from-an-array
 * https://www.youtube.com/watch?v=t0Cq6tVNRBA&t=295s&ab_channel=HackerRank
 * https://www.educative.io/answers/how-to-build-a-heap-from-an-array
 * https://www.baeldung.com/java-quicksort#:~:text=We%20choose%20an%20element%20from,is%20in%20its%20final%20position.
 * @NOTE - Heap sort does not work all the way
 */
public class SortingAlgorithms 
{
	private int loopCount; // Used in the bubble sorting methods
	private int sizeOfArray; 
	
	/**
	 * SortingAlgorithms Constructor - Initializes loopCount to zero
	 */
	public SortingAlgorithms ()
	{
		loopCount = 0;
	}
	
	/**
	 * selectAndSort Method - Is a selection sort and sorts an array from least to greatest. The method
	 * accepts an array, uses two for loops to loop through the array and compare elements, lowest element
	 * saved into lowest variable (but this has to be in index i's when comparing to index j's). Will repeat until
	 * sorted.
	 * @param array - Array passed through
	 * @referenced via board (11/3/2023)
	 */
	public void selectAndSort (int [] array)
	{
		int lowest, temp;
		
		lowest = array[0]; // Storing the first array integer into lowest integer variable
		temp = 0; // Temporary variable initialized to zero
				
		for (int i = 0; i < array.length; i++) // Starts off with the outer for loop which gets the index to compare with in second for loop
		{
			for (int j = 0; j < array.length; j++) // Second for loop that gets the second variable to compare with the first
			{
				if (i != j) // Ensures that the same value is not being compared with itself
				{
					if (array[i] <= array[j]) // If the value in index i (outer loop) is less than or equal to element value in index k (inner loop)
					{
						lowest = array[j]; 	// Swap equals array at index j
						temp = array[i]; 	// storing index i's element to temporary value
						array[i] = lowest; 	// lowest is now in array[i]'s position
						array[j] = temp; 	// And temporary value, previously in array[i]'s position, is stored in array[j] position
					}
				}
			}
		}
	}
	
	/**
	 * insertsIntoSort Method - Passes through an array of integers
	 * @param array - The passed through array of integers
	 */
	public void insertsIntoSort (int [] array)
	{
		int next, j;
		
		next = 0;
		
		for (int i = 0; i < array.length; i++)
		{
			next = array[i]; // Saves a value via position into next variable 
			
			j = i; // Setting j to equal i, and while the position before it is greater than the next variable
			// swap them, with the position of the next variable becoming the one before it. After the while loop,
			// the spot gone (where next's position was replaced) is filled with next
			
			while (j > 0 && array[j - 1] > next)
			{
				array[j] = array[j - 1];
				j--;
			}
			array[j] = next;
		}
	}
	
	/**
	 * insersIntoSortR Method - Similar to insertsIntoSort method but it returns the array created
	 * @param array - The passed through array of integers
	 * @return array - The sorted array
	 */
	public int [] insertsIntoSortR (int [] array)
	{
		int next, j;
		
		next = 0;
		
		for (int i = 0; i < array.length; i++)
		{
			next = array[i];
			j = i;
			while (j > 0 && array[j - 1] > next)
			{
				array[j] = array[j - 1];
				j--;
			}
			array[j] = next;
		}
		return array;
	}
	
	/**
	 * bubbleSortLeast Method - Passes through an ArrayList of integers to sort it from
	 * least to greatest.
	 * @param list - The ArrayList of integers
	 * @return list - The sorted ArrayList of integers
	 */
	public ArrayList<Integer> bubbleSortLeast (ArrayList<Integer> list)
	{
		int current, temp, swaps;
		boolean run;
		current = list.get(0);
		swaps = 0;
		run = true;
		
		while (run == true)
		{
			for (int index = 1; index < list.size(); index++)
			{
				current = list.get(index - 1);

				if (list.get(index) < current) 	// The next index's element after current index's element is greater than current's element
				{
					temp = list.get(index); 	// Saving the bigger element into temporary variable
					list.add(index - 1, temp); 	// adding bigger value at index
					list.remove(index + 1); 	// removing the pushed variable copy
					swaps++;
					loopCount++;
				}
			}
			
			if (swaps > 0) // Tells the program when to end if swaps == 0, meaning no swaps were done!
			{
				swaps = 0;
			}
			else
			{
				run = false;
			}
			
		}
		return list;
	}
	
	/**
	 * bubbleSortGreat Method - Passes through an ArrayList of integers to sort it from
	 * greatest to least.
	 * @param list - The ArrayList of integers
	 * @return list - The sorted ArrayList of integers
	 */
	public ArrayList<Integer> bubbleSortGreat (ArrayList<Integer> list)
	{
		int current, temp, swaps;
		boolean run;
		current = list.get(0);
		swaps = 0;
		run = true;
		
		while (run == true)
		{
			for (int index = 1; index < list.size(); index++)
			{
				current = list.get(index - 1);

				if (list.get(index) > current) 	// The next index's element after current index's element is greater than current's element
				{
					temp = list.get(index); 	// Saving the bigger element into temporary variable
					list.add(index - 1, temp); 	// adding bigger value at index
					list.remove(index + 1); 	// removing the pushed variable copy
					swaps++;
					loopCount++;
				}
			}
			
			if (swaps > 0)
			{
				swaps = 0;
			}
			else
			{
				run = false;
			}
			
		}
		return list;
	}
	
	/**
	 * mergeSort Method
	 * @param array
	 */
	public void mergeSort (int [] array)
	{
		int half;		// Splits array in half
		int [] left;	// Creates left array
		int [] right;	// Creates right array
		
		half = array.length / 2; // Divides array in half
		
		if (array.length <= 1) // Ends the recursion if size is 0 or 1, meaning only one element is in the array
		{
			return;
		}
		
		left = new int [half]; // First half of the array
		right = new int [array.length - half]; // Second half

		for (int i = 0; i < half; i++)
		{
			left[i] = array[i];
		}
		for (int i = half; i < array.length; i++)
		{
			right[i - half] = array[i];
		}
		
		mergeSort(left); 	// Call sort on left
		mergeSort(right); 	// Call sort on right
		
		actuallyMerge(array, left, right); // The other recursive portion for left and right
	}
	
	/**
	 * actuallyMerge Method - The private portion, which is the recursive portion
	 * @param array
	 * @param left
	 * @param right
	 */
	private void actuallyMerge (int [] array, int [] left, int [] right)
	{
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < left.length && j < right.length)
		{
			if (left[i] <= right[j])
			{
				array[k] = left[i];
				i++;
			}
			else 
			{
				array[k] = right[j];
				j++;
			}
			k++;
		}
		
		while (i < left.length)
		{
			array[k] = left[i];
			i++;
			k++;
		}
		
		while (j < right.length)
		{
			array[k] = right[j];
			j++;
			k++;
		}
	}
	
	/**
	 * quickSort Method - Sorting based on the divide-and-conquer principle, a recursive sorting
	 * @param array - Array of integers passed through
	 * @param firstIndex - First index of the array
	 * @param lastIndex - Last index of the array
	 * @referneced https://www.baeldung.com/java-quicksort#:~:text=We%20choose%20an%20element%20from,is%20in%20its%20final%20position.
	 */
	public void quickSort (int [] array, int firstIndex, int lastIndex)
	{
		int partIndex; // called partitionIndex in referenced link
		
		if (firstIndex < lastIndex)
		{
			partIndex = parting(array, firstIndex, lastIndex);
			quickSort (array, firstIndex, partIndex - 1);
			quickSort (array, partIndex + 1, lastIndex);
		}		
	}
	
	/**
	 * parting Method - Called partition, the private recursive method for quick-sorting
	 * @param array - Array of integers
	 * @param firstIndex - First index of the array
	 * @param lastIndex - Last index of the array
	 * @return i+1 - Returns the partition Index to be used in the quickSort method
	 * @referenced https://www.baeldung.com/java-quicksort#:~:text=We%20choose%20an%20element%20from,is%20in%20its%20final%20position.
	 */
	private int parting (int [] array, int firstIndex, int lastIndex)
	{
		int pivot, i, swap;
		
		pivot = array[lastIndex];
		i = firstIndex - 1;
		
		for (int k = firstIndex; k < lastIndex; k++)
		{
			if (array[k] <= pivot)
			{
				i++;
				swap = array[i];
				array[i] = array[k];
				array[k] = swap;
			}
		}
		
		swap = array[i+1];
		array[i+1] = array[lastIndex];
		array[lastIndex] = swap;
		
		return i+1;
	}
	
	/**
	 * shellSort Method - Will sort an array.
	 * @param array - Array of integers passed through
	 * @referenced https://www.tutorialspoint.com/data_structures_algorithms/shell_sort_algorithm.htm. Mostly had to rely on the code provided
	 */
	public void shellSort (int [] array)
	{
		int h, insertion, in;
		h = 1;
		
		while (h <= array.length/3) // Finding the interval using Knuth's Formula (h = h * 3 + 1 where h is interval with initial value 1)
		{
			h = h * 3;
			h++;
		}
		
		while (h > 0)
		{
			for (int out = h; out < array.length; out++)
			{
				insertion = array[out];
				in = out;
				
				while (in > h - 1 && array[in - h] >= insertion)
				{
					array[in] = array[in - h];
					in -= h;
				}
				array[in] = insertion;
			}
			h = h - 1;
			h = h/3;
		}
	}
	
	/**
	 * heapMadness Method - Retrieved from my heap lab which referenced two sources. Max heap worked, and will
	 * be called. heapMadness will call the heap private methods and recursive methods.
	 * @param array - The array passed through
	 */
	public void heapMadness (int [] array)
	{
		sizeOfArray = array.length;
		maxHeap (array);
	}
	
	/**
	 * compare Method - Will run through the recursive portion for a number of times, which is determined via the size of the array
	 * @referenced via Heap Lab problem 2's code (the links for heaps)
	 */
	private void maxHeap (int [] array) 
	{
		for (int index = sizeOfArray; index >= 0; index--)
		{
			maxHeap(array, index);
		}
	}
	
	/**
	 * maxHeap Method - Recursive portion of the comparing method for max-heap sort
	 * @param nodes - An array of integers
	 * @param location - A specific index of an element in nodes array
	 * @referenced via Heap Lab problem 2's code (the links for heaps)
	 */
	public void maxHeap (int [] nodes, int location)
	{	
		int biggest, leftChild, rightChild;
		
		biggest = location;
		leftChild = 2 * location + 1; // Gets the Left Child
		rightChild = 2 * location + 2; // Gets the right child
		
		// Will see if the left child is bigger than their parent
		if (leftChild < sizeOfArray && nodes[leftChild] > nodes[biggest])
		{
			biggest = leftChild;
		}
		
		// Will now see if the right child is bigger than the bigger found
		if (rightChild < sizeOfArray && nodes[rightChild] > nodes[biggest])
		{
			biggest = rightChild;
		}
		
		// Lastly if smallest is actually not the parent
		if (biggest != location)
		{
			swap(location, biggest, nodes);
			
			// Then going through the recursive portion
			maxHeap(nodes, biggest);
		}
	}
	
	/**
	 * swap Method - Swaps the locations of two array elements with one another
	 * @param locationOne - Position of element one
	 * @param locationTwo - Position of element two
	 * @param array - Passed through array of integers
	 * @return array - The new array with swapped variables
	 * @referenced via Heap Lab problem 2's code (the links for heaps)
	 */
	private int [] swap (int locationOne, int locationTwo, int [] array)
	{
		int temporary;
		temporary = array[locationOne];
		
		array[locationOne] = array[locationTwo];
		array[locationTwo] = temporary;
		return array;
	}
	
	/**
	 * createNewArray Method - Creates an amount with a size according to the passed
	 * in parameter, integer amount variable. Creates the array with random integers between 0 and 4999
	 * @param amount - The amount of elements that the array will contain
	 * @return array - The new constructed array
	 */
	public int [] createNewArray (int amount)
	{
		int [] array;
		Random rand;

		array = new int [amount];
		rand = new Random ();
		
		for (int i = 0; i < array.length; i++)
		{
			array[i] = rand.nextInt(5000);
		}
		
		return array;
	}
	
	/**
	 * validate Method - Validates if array was sorted correctly
	 * @param array - An array of integers
	 * @return true if sorted, else false
	 */
	public boolean validate (int [] array)
	{
		boolean checking; 
		int checkNext;
		checkNext = 1;

		for (int i = 0; i < array.length; i++)
		{
			for (int j = checkNext; j < array.length; j++)
			{
				if (j != i)
				{
					checking = true;
					while (checking)
					{
						if (array[i] <= array[j])
						{
							checking = false;
							j = array.length;
							checkNext++;
						}
						else
						{
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * validateArrayList Method - Validates if ArrayList was sorted correctly
	 * @param array - An ArrayList of integers
	 * @return true if sorted, else false
	 */
	public boolean validate (ArrayList<Integer> array)
	{
		boolean checking; 
		int checkNext;
		checkNext = 1;

		for (int i = 0; i < array.size(); i++)
		{
			for (int j = checkNext; j < array.size(); j++)
			{
				if (j != i)
				{
					checking = true;
					while (checking)
					{
						if (array.get(i) <= array.get(j))
						{
							checking = false;
							j = array.size();
							checkNext++;
						}
						else
						{
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * printArray Method - Accepts an array via parameter and prints out each element formatted 
	 * @param array - Array passed through
	 */
	public void printArray (int [] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			System.out.printf("| %s |", array[i]);
		}
		System.out.printf("%n");
	}
	
	/**
	 * getLoopCount method - Gets and returns the loopCount
	 * @return
	 */
	public int getLoopCount ()
	{
		return loopCount;
	}
}
