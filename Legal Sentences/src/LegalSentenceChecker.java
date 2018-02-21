/** Requirements
* 
* Introduction
* 	This program checks sentences to find out whether they are legal. 10 examples have been provided with their correct
* outputs to show the functionality of the program.
	
* How this fulfills / does not fulfill the specification
* 	This program checks for each of the three sentences. It checks for a simple sentence by checking if the sentence
* is a p or a q. If so, the sentence is legal, so the result boolean is turned to true. For a sentence with ~, it
* first checks if the sentence contains the ~, and then removes it and rechecks the remaining string to ensure it is
* logical. For a logical operator sentence, it runs through each of the logical operators and checks to see if one of
* them is present. Then, it sorts them using a helper method. Next, it finds the operator linked with that index, and
* separates the left hand side and the right hand side using substring and that index. Finally, it runs the lhs and the
* rhs through the legal sentence method. If they both come out true, then it is a true logical sentence. Through these
* three separate if and else if statements, the legal sentence method checks these three different types of sentences.
* 
* Explanation of current errors (or anything that falls short of project specifications) and how you might fix them
* 	This program takes a complicated route to sort out the indexes of the and, or, implies, and if, and determine whether
* they exist, and this could be greatly shortened into either helper methods or just have better structuring. I would
* fix this by clearing through the code and brainstorming different ideas to create more concise and 
* 
* Overview of the code explaining, in broad strokes, the structure of it
* 	The main method creates 10 separate strings and runs them through the legal sentence method. These sentences check the
* different aspects of the method, and ensure they all work correctly. The correct results of the sentences are put in
* comments next to the assigning of the sentences, and their results from the method are printed in the output. As
* explained in the fulfillment of the specification, the method checks for all three different types of sentences.
* 
* Discussion of major challenges encountered in the process of making the code
* 	One challenge was accounting for the part of the logical sentence after the ~. It was difficult to remove the ~ from
* the string and then run it through the method again, for me to understand conceptually. Another hard part was definetly
* figuring out how to sort the indexes of the logical operators and then find out with logical operator the smallest
* index belonged to. It took me a while to figure it out, but in the end I was able to make it work, and I'm glad I
* overcame that hurdle.
* 	
* Acknowledgments (who helped you, what resources you used etc.)
* 	I thank Mr. Kuzmal for providing the material and instructions. 
* 
*/

import java.util.ArrayList;
import java.util.Collections;

public class LegalSentenceChecker {
	public static void main (String [] args) {
		
		//test sentences
		//correct output listed next to string
		String t1 = "p"; //false
		String t2 = "p|p"; //true
		String t3 = "q|q"; //true
		String t4 = "p|q"; //true
		String t5 = "~hello"; //false
		String t6 = "~p"; //true
		String t7 = "hello|hello"; //false	
		String t8 = "hello&hello"; //false
		String t9 = "hello=>hello"; //false
		String t10 = "p<=>q"; //true;
		
		//prints the results of the test sentences
		pln("t1 is " + legalsentence(t1));
		pln("t2 is " + legalsentence(t2));
		pln("t3 is " + legalsentence(t3));
		pln("t4 is " + legalsentence(t4));
		pln("t5 is " + legalsentence(t5));
		pln("t6 is " + legalsentence(t6));
		pln("t7 is " + legalsentence(t7));
		pln("t8 is " + legalsentence(t8));
		pln("t9 is " + legalsentence(t9));
		pln("t10 is " + legalsentence(t10));

	}
	public static boolean legalsentence(String s) {
		
		//variable for the end result
		boolean result = false;
		
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
				boolean legal = legalsentence(s2);
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
				boolean legall = legalsentence(lhs);
				boolean legalr = legalsentence(rhs);
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
	
	//print methods
	public static void p (String args) {
		System.out.print(args);
	}

	public static void pln (String args) {
		System.out.println(args);
	}

}
