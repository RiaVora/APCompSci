package puzzle;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
	public static void main(String[] args) {
		PropositionConstant a = new PropositionConstant("a");
		PropositionConstant b = new PropositionConstant("b");
		LogicalSentence l1 = new LogicalSentence(a);
		LogicalSentence l2 = new LogicalSentence(b);
		LogicalSentence l3 = new Negation(l1); //~a
		LogicalSentence l4 = new Negation(l3); //~~a = a
		
		//Conjunction = AND
		//Negation(l4) is technically l3
		LogicalSentence l5 =  new Conjunction(l3, new Negation(l4)); //(~a && ~a)
		TruthAssignment ta1 = new TruthAssignment();
		ta1.put(b, true);
		ta1.put(a, false); 
		System.out.println(l5.evaluate(ta1));
		System.out.println(legal("a&"));
		System.out.println(findMatch("a(b)", 0));
		String[] pc = {"p"};
		truthTable(pc);
	}
	
	//Past method created to check whether a sentence is legal or not
	public static boolean legal(String s) {

		//variable for the end result
		boolean result = false;
		
		//Creates a boolean to decide whether the sentence is a negation
		boolean sw = s.startsWith("~");
		
		//stores the index of the logical operators
		int and = s.indexOf("&");
		int or = s.indexOf("|");
		int implies = s.indexOf("=>");
		int iff = s.indexOf("<=>");
		
		//finds out whether the string has any of the logical operators
		boolean hasand = s.contains("&");
		boolean hasor = s.contains("|");
		boolean hasimplies = s.contains("=>");
		boolean hasiff = s.contains("<=>");
		

		if (s.length() >= 1) {
			
			//checks for simple sentences
			if (simplesentence(s) == true) {
				result = true;
			
			//checks for ~ sentences
			} else if (sw == true) {
				
				//reruns the method on the rest of the string, without the ~
				String s2 = s.substring(1, s.length());
				boolean legal = legal(s2);
				if (legal == true) {
					result = true;
				}
				
			//checks for logical operator sentences (first checks to see if the string contains it)
			} else if ((hasand) || (hasor) || (hasimplies) || (hasiff)){
				
				//uses the find smallest method to sort the indexes for the smallest one
				int index = findsmallest(and, or, implies, iff);
				
				//uses substring to isolate the left hand side of the logical operator
				String lhs = s.substring(0, index);
				
				//creates a blank base right hand side
				String rhs = "";
				
				//matches the smallest index with it's logical operator, and uses the appropriate substring argument
				if (index == and) {
					rhs = s.substring((index + 1), s.length());
				} else if (index == or){
					rhs = s.substring((index + 1), s.length());
				} else if (index == implies){
					rhs = s.substring((index + 2), s.length());
				} else if (index == iff){
					rhs = s.substring((index + 3), s.length());
				}
				
				//Checks whether the left hand side and the right hand side are legal sentences by running them
				//through this method
				boolean legall = legal(lhs);
				boolean legalr = legal(rhs);
				if ((legall) && (legalr)) {
					result = true;
				}
				
			}
		}
		return result;
	}
	
	//checks if the string is a p or q, and returns a boolean
	public static boolean simplesentence(String s) {
		boolean result = false;
		if ((s.equals("p")) || (s.equals("q"))) {
			result = true;
		}
		return result;
	}
	
	//sorts the indexes and returns the smallest one
	public static int findsmallest(int x, int y, int z, int a) {
		
		//creates a variable for the end result
		int result = 0;
		
		//creates a list to store the indexes to be sorted
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//adds an index to the list if it is above 0, or not -1
		if (x > 0) {
			list.add(x);
		} if (y > 0) {
			list.add(y);
		} if (z > 0) {
			list.add(z);
		} if (a > 0) {
			list.add(a);
		}
		
		//sorts the list of indexes
		Collections.sort(list);
		
		//returns the first resulting one
		result = list.get(0);
		return result;
	}
	
	//Instructions: findMatch returns the index of the rightmost character in the first substring of the argument
	//that is enclosed by matching parentheses and which contains no parentheses.
	
	//findMatch finds the very last constant enveloped by parentheses, and returns it's index
	public static int findMatch(String s, int value) {
		
		//This is the result of the index, defaulted to -1 because that is the value returned when the index is not found
		//Or, if the string is not valid, then the method will also return a -1 (-1 = error)
		int result = -1;
		
		//First checks that the String is larger or equal to 3 (has to be larger or equal to 3 if it has two parentheses
		//and a constant) and checks if it has at least one front facing parenthesis "(" and one back facing parenthesis ")"
		if ((s.length() >= 3) && (s.contains("(")) && (s.contains(")"))) {
			//First separates the string into a char Array
			char[] string = s.toCharArray();
			
			//Checks each character in the string
			for (int i = 0; i < s.length(); i++) {
			
				//Then, if the string is a front parenthesis it adds one
				if (string[i] == ('(')) {
					value++;
					
				//If the character is a back parenthesis it subtracts one
				} else if (string[i] == (')')) {
					value--;
				}
			}
			
			//Then lastly, if the value is 0, which means there is an equal number of forward and backward parentheses,
			//then it checks the index of the variable right before the last parenthesis to find the match, and gets that
			//index
			if (value == 0) {
				result = (s.indexOf(")") - 1);
			}
		}
		//Returns the index of the last constant if the parentheses are equal, otherwise returns -1
		return result;
	}
	
	//Prints a truth table for any number of propositional constant strings inputed into an array
	public static void truthTable(String[] pca) {
		
		//Each propositional constant is separated by 10 spaces (code to run the very top row)
		for (String pc: pca) {
			p(pc + "          ");
		}
		
		//Add's an extra line to start off the printing of the truth table
		pln("");
		
		//References the print truth table method		
		//The number of rows based on the rule that 2 to the power of the number of propositional constants is
		//the number of rows in the truth table (not counting the top row setting the variables placement)
		int rows = (int) Math.pow(2, pca.length);
		
		//Runs the same number of times as the number of rows to get the 
		for (int i = 0; i < rows; i++) {
			
			//Runs the printing of the values for a singular row
			for (int j = pca.length - 1; j >= 0; j--) {
				
				//Assigns a 0 to Truth values and a 1 to False values. It does this by using i to divide by 2^j
				//Therefore, when i is 0 then the denominator doesn't matter, when finding the modulo with 2, so
				//all values are 0, and therefore all values are true. Next, it goes to i = 1, for the second row,
				//and makes it true except for the last value, which would be larger than 2 and allow for a rounding of 1
				//after the module of 2, giving you false. This continues to work for the rest of the truth table
				int var = (i / (int)Math.pow(2, j)) % 2;
				
				//Aligns the truth value with the correct propositional constant by adding the correct number of spaces
				String space = "      ";
				
				//Returns true with the correct spacing if the var is 0
				if (var == 0) {
					p("True " + space);
				
				//Returns false with the correct spacing if the var is 1
				} else {
					p("False" + space);
				}
			}
			
			//Moves a line down to start the next row
			pln("");
		}
		
}
	
	
	//Print Methods
	public static void p (String args) {
		System.out.print(args);
	}

	public static void pln (String args) {
		System.out.println(args);
	}

	
}
