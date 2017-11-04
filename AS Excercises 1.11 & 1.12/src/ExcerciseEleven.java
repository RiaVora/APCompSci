import java.util.Scanner;

public class ExcerciseEleven {
	
	/*
	Exercise 1.11.  A function f is defined by the rule that

	 f(n) = n if n < 3,

	f(n) = f(n-1) + 2f(n-2) + 3f(n-3) if n >= 3

	Write a procedure that computes f by means of a recursive process. Write a procedure that computes
	f by means of an iterative process.
	**/
	 
	public static void main(String args[]) {
		
		//scanner for console input
		Scanner input = new Scanner(System.in);
		
		pln("There are two methods of calculating f(n) = f(n-1) + 2f(n-2) + 3f(n-3) if n >= 3, recursive and iterative");
		pln("Both have been created and demonstrated here for you, with the ability to also input your own numbers!");
		
		//tests recursive function for 1, 2, 3, 4, 5, 10, and 15
		pln("\nRecursive function for f(1) is " + fRecursive(1));
		pln("Recursive function for f(2) is " + fRecursive(2));
		pln("Recursive function for f(3) is " + fRecursive(3));
		pln("Recursive function for f(4) is " + fRecursive(4));
		pln("Recursive function for f(5) is " + fRecursive(5));
		pln("Recursive function for f(10) is " + fRecursive(10));
		pln("Recursive function for f(15) is " + fRecursive(15));

		//tests iterative function for 1, 2, 3, 4, 5, 10, and 15 (should match recursive)
		pln("\nIterative function for f(1) is " + fIterative(1));
		pln("Iterative function for f(2) is " + fIterative(2));
		pln("Iterative function for f(3) is " + fIterative(3));
		pln("Iterative function for f(4) is " + fIterative(4));
		pln("Iterative function for f(5) is " + fIterative(5));
		pln("Iterative function for f(10) is " + fIterative(10));
		pln("Iterative function for f(15) is " + fIterative(15));
		
		//boolean for checking if the user wants to try more numbers
		boolean again = true;
		
		//asks the user to try additional numbers
		while (again) {
			pln("\nTry out some numbers! Notice the difference in time of computation for recursive vs. iterative methods");
			p("Input your number here (Numbers over 35 tend to delay the recursive function, but add to the fun!): ");
			
			//takes the user input of their desired number
			int number = input.nextInt();

			//sets ready to false to check if user is ready for recursive function
			boolean ready = false;
			while (!ready) {
				pln("\nReady for recursive function?");
				ready = check(input);
			}
			
			//returns the number after running through recursive function
			pln("Recursive function for f(" + number + ") is " + fRecursive(number));
			
			//sets ready back to false for checking if user is ready for iterative function
			ready = false;
			while (!ready){
				pln("\nReady for iterative function?");
				ready = check(input);
			}
			
			//returns the number after running through iterative function
			pln("Iterative function for f(" + number + ") is " + fIterative(number));
			
			//checks if the user wants to input another number
			pln("\nWant to try a new set of numbers?");
			again = check(input);
		}

	}
	

	
	//recursive method
	public static int fRecursive(int n) {
		if (n < 3) {
			return n;
		} else {
			return fRecursive(n -1) + 2*fRecursive(n - 2) + 3*fRecursive(n - 3);
		}
	}
	
	//iterative method
	public static int fIterative(int n) {
		if (n < 3) {
			return n;
		} else {
			return fIter(2, 1, 0, n);
		}
	}
	
	public static int fIter(int a, int b, int c, int count) {
		if (count < 3) {
			return a;
		} else {
			while (count >= 3) {
				//function f for the current state
				int f = a + 2*b + 3*c;
				
				//function f from the previous state
				int fFromPState = a;
				
				//function f from the previous, previous state
				int fFromPPState = b;
				
				//resets a, b, and c as their respective past states
				a = f;
				b = fFromPState;
				c = fFromPPState;
				count--;
			}
			return a;
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
