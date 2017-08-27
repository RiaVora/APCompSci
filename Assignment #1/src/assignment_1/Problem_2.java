package assignment_1;

public class Problem_2 {
	public static void main (String[] args) {
		pln(logic(true, false, false) + "");
		pln(logic(true, true, true) + "");
	}
	
	public static boolean logic(boolean a, boolean b, boolean c) {
		if (a && b && c) {
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
