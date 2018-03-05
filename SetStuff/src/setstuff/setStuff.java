package setstuff;
import java.util.ArrayList;
import java.util.Arrays;

/* Documentation:
 * 
 * INTRODUCTION
 * As implemented based on the specifications provided in the coding bat PALY AP CS 2018
 * Page named "setstuff", these 11 problems demonstrate my skills to solve AP CS level
 * problems given a return requirement and the arguments.
 * 
 * FULFILLMENT OF SPECIFICATION
 * The specification of the coding bat page was the  instructions provided in each of the
 * 11 problems. This specification was tested through the "tests" provided by the page.
 * Since these tests needed to be passed in order for the problems to be counted as complete
 * and correct, and all 11 problems of mine are passed and correct, it is safe to say that 
 * my code passed all the tests, and therefore, it code passed through all the given
 * specifications accurately
 * 
 * CURRENT ERRORS
 * As aforementioned, since my code passed all of the tests, there should be no errors.
 * There could still exist errors in the code, if the tests did not catch something, but
 * my examples provided below in the main method also test all of the eleven problems,
 * providing a double checking system. The code could've passed the tests and the double
 * check and still have errors, but if so, these errors are either minimal or non-existent
 * 
 * OVERVIEW
 * These eleven problems prove my ability to create AP CS level code. The first problem
 * consisted of the creation of an ArrayList, adding to it, and returning. The second
 * problem tested my ability to search through an ArrayList and return the index. The third
 * problem had me create a method where I returned either true or false based on whether
 * an array contained a specified integer. The fourth problem tested all of the elements of
 * two arrays to see if there were any intersections, and returned true if it found at least
 * one. The fifth problem found the union of two given arrays, or in other words, combined
 * all of the elements in both arrays. The sixth problem found the intersection of two
 * given arrays, or in other words, found the elements that existed in both. The seventh
 * problem had me sort through data given of nodes, their visiting status, and their
 * distance, and return the nearest Unvisited Node. The eighth problem creates an ArrayList
 * with three given integers. The ninth problem adds a new ArrayList that contains three
 * given integers to the given ArrayList of ArrayLists. The tenth problem creates a size
 * four ArrayList that has the union of the first two elements of the two ArrayLists given
 * in one larger ArrayList. Finally, the eleventh problem was using a maximal number in
 * an ArrayList, where the starting index was 0 but every other value would be maximal.
 * Through these eleven problems, I demonstrated my knowledge and ability of implementation
 * of AP CS problems.
 * 
 * MAJOR CHALLENGES
 * I faced two major challenges when finishing the harder problems. One issue was a
 * when I had not properly saved a coding bat, and the log in had failed, and all of my code
 * was lost in one of the problems. I had to rewrite all of it, and it was one of the longer
 * ones, and I ended up making multiple mistakes that took much deliberation to fix. The
 * other problem I was stuck on was the nearesUnivisitednode, Problem 7. I was unable to
 * figure out how to link the three arrays to each other, and how to properly sift through
 * them. The requirements were confusing to me as I had never done this type of problem
 * before. In order to succeed from this challenge, I got help from a peer and from the
 * AP CS teacher, as mentioned below in acknowledgements. Once I was able to properly
 * understand what the problem and the tests were asking, I was able to successfully create
 * code to finish the tests and the requirements of the problem.
 * 
 * ACKNOWLEDGEMENTS
 * Zage Strassberg-Phillips and Mr. Kuszmaul helped me through the challenges I faced this
 * project. I also received help from Java Point about ArrayList and array methods.
 */

public class setStuff {
	public static void main(String[] args) {
		
		//PROBLEM 1: ret17
		pln("Problem 1: ret17");
		pln("Return Result: ArrayList containing 17");
		pln("	Returned ArrayList: " + ret17());
		
		//PROBLEM 2: zerothElement
		pln("\nProblem 2: zerothElement");
		pln("Return Result: Integer at index 0 of a given ArrayList");
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(3, 9, 3, 4, 5));
		ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(49023, 7859, 12834));
		pln("	ArrayList 1: " + a);
		pln("	Zeroth Element: " + zerothElement(a));
		pln("");
		pln("	ArrayList 2: " + a2);
		pln("	Zeroth Element: " + zerothElement(a2));

		//PROBLEM 3: contains
		pln("\nProblem 3: contains");
		pln("Return Result: true if given int is in the given int array, false otherwise");
		int[] b = {6, 7, 9, 23, 2};
		int[] b2 = {27923, 123679, 5};
		pln("	Array 1: " + print(b));
		pln("	contains 9? " + contains(9, b));
		pln("");
		pln("	Array 2: " + print(b2));
		pln("	contains 15? " + contains(15, b2));

		//PROBLEM 4: anyContains
		pln("\nProblem 4: anyContains");
		pln("Return Result: true if any element of a is in b, false otherwise");
		int[] c = {23, 4, 0, 3};
		pln("	Array 1: " + print(b));
		pln("	Array 2: " + print(b2));
		pln("	anyContains? " + anyContains(b, b2));
		pln("");
		pln("	Array 1: " + print(b));
		pln("	Array 2: " + print(c));
		pln("	anyContains? " + anyContains(b, c));
		
		//PROBLEM 5: union
		pln("\nProblem 5: union");
		pln("Return Result: int array that contains all elements in a OR b");
		pln("	Array 1: " + print(b));
		pln("	Array 2: " + print(b2));
		pln("	Union (1 U 2): " + print(union(b, b2)));
		pln("");
		pln("	Array 1: " + print(b));
		pln("	Array 2: " + print(c));
		pln("	Union (1 U 2): " + print(union(b, c)));
		
		//PROBLEM 6: intersect
		pln("\nProblem 6: intersect");
		pln("Return Result: sorted int array that contains all elements in a AND b (no repeats)");
		int[] d = {2, 3, 7, 9, 48, 76};
		int[] d2 = {2348, 43798, 398222};
		int[] d3 = {4, 8, 9, 33, 48, 90};
		pln("	Array 1: " + print(d));
		pln("	Array 2: " + print(d2));
		pln("	Intersection (1 U 2): " + print(intersect(d, d2)));
		pln("");
		pln("	Array 1: " + print(d));
		pln("	Array 2: " + print(d3));
		pln("	Intersection (1 U 2): " + print(intersect(d, d3)));
		
		//PROBLEM 7: nearesUnvisitedNode
		pln("\nProblem 7: nearesUnvisitedNode");
		pln("Return Result: String at index of smallest integer where the corresponding boolean is false");
		boolean[] e = {true, false, false};
		int[] e2 = {1, 2, 3};
		String[] e3 = {"A", "B", "C"};
		boolean[] f = {false, false, true};
		int[] f2 = {24, 437, 3982};
		String[] f3 = {"New York", "Boston", "Massachussets"};
		pln("	Visited Array: " + printBoolean(e));
		pln("	Distance Array: " + print(e2));
		pln("	Node Array: " + printString(e3));
		pln("	Result: " + nearesUnvisitedNode(e, e2, e3));
		pln("");
		pln("	Visited Array: " + printBoolean(f));
		pln("	Distance Array: " + print(f2));
		pln("	Node Array: " + printString(f3));
		pln("	Result: " + nearesUnvisitedNode(f, f2, f3));
		
		//PROBLEM 8: listify
		pln("\nProblem 8: listify");
		pln("Return Result: ArrayList containing three given ints");
		pln("	Three Integers: 4 9 7");
		pln("	ArrayList: " + listify(4, 9, 7));
		pln("");
		pln("	Three Integers: 453987 8947 2383");
		pln("	ArrayList: " + listify(453987, 8947, 2383));
		
		//PROBLEM 9: addEdge
		pln("\nProblem 9: addEdge");
		pln("Return Result: ArrayList of ArrayLists with a new ArrayList containing the three given ints");
		ArrayList<ArrayList<Object>> g = new ArrayList<ArrayList<Object>>();
		g.add(new ArrayList<Object>(Arrays.asList(3, 9, 3, 4, 5)));
		g.add(new ArrayList<Object>(Arrays.asList(49023, 7859, 12834)));
		ArrayList<ArrayList<Object>> g2 = new ArrayList<ArrayList<Object>>();
		g2.add(new ArrayList<Object>(Arrays.asList(482, 5, 67)));
		g2.add(new ArrayList<Object>(Arrays.asList(34, 0, 3289)));
		pln("	ArrayList Of ArrayLists: " + g);
		pln("	Three Integers: 4 9 7");
		pln("	Result: " + addEdge(g, 4, 9, 7));
		pln("");
		pln("	ArrayList Of ArrayLists: " + g2);
		pln("	Three Integers: 78 78 9");
		pln("	Result: " + addEdge(g2, 78, 78, 9));

		//PROBLEM 10: collectNodes
		pln("\nProblem 10: collectNodes");
		pln("Return Result: size four ArrayList that contains the union of the first two elements of the ArrayLists in a given ArrayList");
		ArrayList<ArrayList<Integer>> h = new ArrayList<ArrayList<Integer>>();
		h.add(new ArrayList<Integer>(Arrays.asList(3, 9, 3)));
		h.add(new ArrayList<Integer>(Arrays.asList(49023, 7859, 12834)));
		ArrayList<ArrayList<Integer>> h2 = new ArrayList<ArrayList<Integer>>();
		h2.add(new ArrayList<Integer>(Arrays.asList(482, 5, 67)));
		h2.add(new ArrayList<Integer>(Arrays.asList(34, 0, 3289)));
		pln("	ArrayList Of ArrayLists: " + h);
		pln("	Result: " + collectNodes(h));
		pln("");
		pln("	ArrayList Of ArrayLists: " + h2);
		pln("	Result: " + collectNodes(h2));
		
		//PROBLEM 11: setInfinity
		pln("\nProblem 11: setInfinity");
		pln("Return Result: ArrayList of the given size, with the start point of 0 at the given index, rest of the values are maximal");
		pln("	Maximal Number: 2147483647");
		pln("	Size 1, Index 0");
		pln("	Result: " + setInfinity(1, 0));
		pln("");
		pln("	Maximal Number: 2147483647");
		pln("	Size 3, Index 1");
		pln("	Result: " + setInfinity(3, 1));
	}
	
	//PROBLEM 1: ret17
	public static ArrayList<Integer> ret17() {
		  ArrayList<Integer> a = new ArrayList<Integer>();
		  a.add(17);
		  return a;
	}
	
	//PROBLEM 2: zerothElement
	public static Integer zerothElement(ArrayList<Integer> al){
		  return al.get(0);
	}
	
	//PROBLEM 3: contains
	public static boolean contains(int a, int[] ar){
		  for (int i: ar) {
		    if (i == a) return true;
		  }
		  return false;
		}
	//PROBLEM 4: anyContains
	public static boolean anyContains(int[] a, int[] b){
		  for (int i: a) {
		    for (int j: b) {
		      if (i == j) {
		        return true;
		      }
		    }
		  }
		  return false;
		}
	
	//PROBLEM 5: union
	public static int[] union(int[] a, int[] b){
		  int[] arr = new int[a.length + b.length];
		  for (int i = 0; i < a.length; i++) {
		    arr[i] = a[i];
		  }
		  for (int i = 0; i < b.length; i++) {
		    arr[i + a.length] = b[i];
		  }
		  return arr;
		}
	
	//PROBLEM 6: intersect
	public static int[] intersect(int[] a, int[] b){
		  int num = 0;
		  for(int i: a) {
		    for(int j: b) {
		      if (i == j) {
		        num++;
		      }
		    }
		  }
		  int[] arr = new int[num];
		  int num2 = 0; 
		  for(int i: a) {
		    for(int j: b) {
		      if (i == j) {
		        arr[num2] = j;
		        num2++;
		        
		      }
		    }
		  }
		  return arr;
	}
	
	//PROBLEM 7: nearesUnvisitedNode
	public static String nearesUnvisitedNode(boolean[] visited, int[] distance, String[] nodeName){
		  int d = 10000;
		  int index = -1;
		  for (int i = 0; i < visited.length; i++) {
		    if (!visited[i]) {
		      if (distance[i] < d) {
		        d = distance[i];
		        index = i;
		      }
		    }
		  }
		  if (index == -1) {
		    return "";
		  } else {
		    return nodeName[index];
		  }
	}

	//PROBLEM 8: listify
	public static ArrayList<Object> listify(int a, int b, int c){
		  ArrayList<Object> arr = new ArrayList<Object>();
		  arr.add(a);
		  arr.add(b);
		  arr.add(c);
		  return arr;
	}
	
	//PROBLEM 9: addEdge
	public static ArrayList<ArrayList<Object>> addEdge(ArrayList<ArrayList<Object>> graph, int a, int b, int c){
		   ArrayList<Object> arr = new ArrayList<Object>();
		   arr.add(a);
		   arr.add(b);
		   arr.add(c);
		  ArrayList<ArrayList<Object>> arrBig = new ArrayList<ArrayList<Object>>();
		  for (ArrayList<Object> i: graph) {
		    arrBig.add(i);
		  }
		  arrBig.add(arr);
		  return arrBig;
	}

	//PROBLEM 10: collectNodes
	public static ArrayList<Integer> collectNodes(ArrayList<ArrayList<Integer>> edgelist){
		  ArrayList<Integer> x = new ArrayList<Integer>();
		  for (ArrayList<Integer> i: edgelist) {
		    if (i.size() == 3) {
		      for (int j = 0; j < 2; j++) {
		        int value = i.get(j);
		        if (!x.contains(value)) {
		          x.add(value);
		        }
		      }
		    }
		  }
		  return x;
	}
	
	//PROBLEM 11: setInfinity
	public static ArrayList<Integer> setInfinity(int n, int start){
		  ArrayList<Integer> a = new ArrayList<Integer>();
		  for (int i = 0; i < n; i++) {
		    if (i == start) {
		      a.add(0);
		    } else {
		      a.add(2147483647);
		    }
		  }
		  return a;
	}

	
	//PRINT METHODS
	public static String print(int[] a) {
		String result = "[";
		if (a.length == 0) return "[]";
		for (int i = 0; i < (a.length - 1); i++) {
			result += a[i] + ", ";
		}
		result += a[a.length - 1] + "]";
		return result;
	}
	
	
	public static String printBoolean(boolean[] a) {
		String result = "[";
		if (a.length == 0) return "[]";
		for (int i = 0; i < (a.length - 1); i++) {
			result += a[i] + ", ";
		}
		result += a[a.length - 1] + "]";
		return result;
	}
	
	public static String printString(String[] a) {
		String result = "[";
		if (a.length == 0) return "[]";
		for (int i = 0; i < (a.length - 1); i++) {
			result += a[i] + ", ";
		}
		result += a[a.length - 1] + "]";
		return result;
	}
	
	
	public static void p(Object a) {
		System.out.print(a);
	}
	
	public static void pln(Object a) {
		System.out.println(a);
	}
}
