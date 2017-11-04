import java.util.Scanner;

public class ExcerciseTwelve {
	/*
	Exercise 1.12.  The following pattern of numbers is called Pascal's triangle.

	The numbers at the edge of the triangle are all 1, and each number inside the triangle is the sum of the two numbers
	above it.
	Write a procedure that computes elements of Pascal's triangle by means of a recursive process.
	**/
	
	public static void main(String args[]) {
		//Scanner for console input
		Scanner input = new Scanner(System.in);

		pln("An example of a recursive method is one for calculating a number in Pascal's Triangle given the row and index");
		pln("The method has been created and demonstrated here for you, with the ability to also input your own numbers!");
		
		//Tests pascals triangle function for r1 c0, r1 c1, r2 c1, r2 c2, r3, c2, r4,
		pln("\nPascals Triangle for row 1 index 0 is " + pT(1, 0));
		pln("Pascals Triangle for row 1 index 1 is " + pT(1, 1));
		pln("The numbers for row 1 index 0 and row 1 index 1 should add up to row 2 index 1");
		pln("Pascals Triangle for row 2 index 1 is " + pT(2, 1));
		
		pln("\nPascals Triangle for row 4 index 2 is " + pT(4, 2));
		pln("Pascals Triangle for row 4 index 3 is " + pT(4, 3));
		pln("The numbers for row 4 index 2 and row 4 index 3 should add up to row 5 index 3");
		pln("Pascals Triangle for row 5 index 3 is " + pT(5, 3));
		
		//boolean for checking if the user wants to try more numbers
		boolean again = true;
		
		//asks the user to try additional numbers
		while (again) {
			
			pln("\nTry out some numbers! (there might be a time delay for larger numbers)");
			
			//asks the user for a row number and takes input
			p("\nInput your row number here: ");
			
			int r = input.nextInt();
			
			//asks the user for a index number and takes input
			p("Input your index number here: ");
			
			int i = input.nextInt();
			
			//returns the number after running through pascals triangle with user row and index
			pln("\nPascals Triangle for row " + r + " index " + i + " is " + pT(r, i));
			
			//checks if the user wants to input another number
			pln("\nWant to try a new set of numbers?");
			again = check(input);
		}
		
	}
	
	//pascals triangle recursive method
	public static int pT(int n, int k) {
		if (n <= 1 || k == 0 || k == n) {
			return 1; 
		} else {
			return pT(n - 1, k) + pT(n - 1, k - 1);
		}
	}
	
	//checks if the user wants to continue
	public static boolean check(Scanner input) {
		String ans = input.next().toLowerCase();
		if (ans.equals("y") || ans.equals("yes") || ans.equals("sure") || ans.equals("ok")) {
			return true;
		} else {
			return false;
		}
	}
	
	//print methods
	public static void p (String args) {
		System.out.print(args);
	}

	public static void pln (String args) {
		System.out.println(args);
	}
}
