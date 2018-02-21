package digits;
import java.util.ArrayList;
import java.util.Collections;

/*
 * Implementation Issues (from paper to Eclipse):
 * First, for ArrayList, I did not consider how to add an object with a specified index, and had to look this up. Now, I
 * know that in an ArrayList, I can assign a value to a specific index using add(index, object)
 * Second, I did not realize that you cannot take the length of an integer. In order to solve this, I went the roundabout
 * way of turning the integer into a String and taking that length.
 * 
 * Digits Constructor:
 * (+1) Constructs digitList
 * (+1) Identifies a digit in num
 * (+1) Adds at least one identified digit to a list
 * (+1) Adds all identified digits to a list (must be in context of a loop)
 * (+1) On exit: digitList contains all and only digits of num in the correct order
 * 
 * isStrictlyIncreasing Method:
 * (+1) Compares at least one identified consecutive pair of digitList elements
 * (+1) Determines if a consecutive pair of digitList is out of order (must be in context of a digitList traversal)
 * (+1) Compares all necessary consecutive pairs of elements (no bounds errors)
 * (+1) Returns true iff all consecutive pairs of elements are in order; returns false otherwise
 * 
 * Question-Specific Penalties
 * (-0) Uses confused identifier instead of digitList
 * 
 * SCORE: 9/9 or 10.9
 * 
 * Acknowledgments:
 * ArrayList Add Method:
 * 	https://stackoverflow.com/questions/7384908/add-object-to-arraylist-at-specified-index
 * Rubric:
 * 	https://secure-media.collegeboard.org/ap/pdf/ap17-sg-comp-sci-a.pdf
 */

public class Digits {
	private ArrayList<Integer> digitList;
	
	public static void main(String[] args) {
		Digits d = new Digits(154);
		System.out.println("Created object with integer 154. Array should be [1, 5, 4], false on increasing");

		System.out.println(d.getDigitList());
		System.out.println(d.isStrictlyIncreasing());
		Digits d2 = new Digits(156);
		System.out.println("Created object with integer 156. Array should be [1, 5, 6], true on increasing");

		System.out.println(d2.getDigitList());
		System.out.println(d2.isStrictlyIncreasing());

	}
	
	public Digits(int num) {
		digitList = new ArrayList<Integer>();
		int length = String.valueOf(num).length();
		int n = num;
		for (int i = 0; i < length; i++) {
			digitList.add(i, n % 10);
			n = n / 10;
		}
		Collections.reverse(digitList);
	}
	
	public ArrayList<Integer> getDigitList() {
		return digitList;
	}
	
	public boolean isStrictlyIncreasing() {
		for (int i = 1; i < digitList.size(); i++) {
			if (digitList.get(i - 1) > digitList.get(i)) {
				return false;
			}
		}
		return true;
	}
}
