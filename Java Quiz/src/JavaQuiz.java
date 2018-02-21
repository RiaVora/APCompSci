import java.util.Scanner;

public class JavaQuiz {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		pln("Ready for a Java Quiz? Too bad there's one coming.");
		
		//Question 1
		pln("\nWhat is the code to print (not print with an extra line, just print) something onto the console? Do not ");
		pln("include the semicolon. ");
		String q1 = input.next();
		
		//Question 2
		pln("\nDo you capitalize classes? ");
		String q2 = input.next();
		
		//Question 3
		pln("\nTrue Or False?");
		pln("For the method public static int test(String args), the int stands for the argument the method takes in. ");
		String q3 = input.next();
		
		//Checks if user is ready for score
		boolean ready = false;
		while (ready == false) {
			pln("\nReady for your score? ");
			String ans = input.next();
			ready = correct(ans, "yes", "y");
		}
		
		//Scoring
		pln("\nFor Question 1, the code to print, your answer was " + score(correct(q1, "system.out.print()", "system.out.print()")));
		pln("The correct answer is system.out.print()");
		
		pln("\nFor Question 2, capitalizing classes, your answer was " + score(correct(q2, "yes", "y")));
		pln("The correct answer is yes or y");
		
		pln("\nFor Question 3, naming of a method, your answer was " + score(correct(q3, "false", "f")));
		pln("The correct answer is false or f");
		
	
	}
	public static String score(boolean ans) {
		if (ans == false) {
			return "incorrect, sorry.";
		} else if (ans == true) {
			return "correct, congratulations!";
		} else {
			return "error";
		}
	}

	
	public static boolean correct(String input, String ans1, String ans2) {
		if ((input.toLowerCase().equals(ans1)) || (input.toLowerCase().equals(ans2))) {
			return true;
		} else {
			return false;
		}
	}
		
	public static void p (String args) {
		System.out.print(args);
	}
	
	public static void pln (String args) {
		System.out.println(args);
	}

}
