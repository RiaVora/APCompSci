package three_sorts;
import java.util.Scanner;

public class Main {
	
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Introduction
		int[] arr = {6, 1, 4, 2, 5, 3};		
		pln("Array to be sorted: " + print(arr));
		
		//Bubble Sort (perhaps called a bubble because only looking at two elements?)
		check("Bubble Sort", input);
		String bsarr = print(BubbleSort.sort(arr));
		pln("Bubble Sort: " + bsarr);
		
		//Insertion Sort
		int[] arr2 = {6, 1, 4, 2, 5, 3};
		check("Insertion Sort", input);
		String isarr = print(InsertionSort.sort(arr2));
		pln("Insertion Sort: " + isarr);
		
		//Selection Sort
		int[] arr3 = {6, 1, 4, 2, 5, 3};
		check("Selection Sort", input);
		String ssarr = print(SelectionSort.sort(arr3));
		pln("Selection Sort: " + ssarr);
		
	}
	
	public static void check(String condition, Scanner input) {
		boolean cont = false;
		while (!cont) {
			p("\nReady to continue to " + condition + "?: ");
			String ans = input.next().toLowerCase();
			cont = ((ans.equals("y")) || (ans.equals("yes"))) ? true : false;
		}
	}
	
	public static String print(int[] arr) {
		String retval = "[";
		for (int i = 0; i < (arr.length - 1); i++) {
			retval += (arr[i] + ", ");
		}
		retval += (arr[arr.length - 1] + "]");
		return retval;
	}
	
	
	public static void p (String args) {
		System.out.print(args);
	}

	public static void pln (String args) {
		System.out.println(args);
	}
}
