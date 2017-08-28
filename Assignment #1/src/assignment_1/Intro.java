package assignment_1;

public class Intro {
	public static void main (String[] args) {
		pln("Problem 1 (Proof):");
		pln(ret() + "");
	
		pln("\nProblem 2 (Proof):");
		pln(logic(true, false, false) + "");
		pln(logic(true, true, true) + "");
		
		pln("\nProblem 3 (Proof):");
		pln(stars(5));
		pln(stars(6));
		
		pln("\nProblem 4 (Proof):");
		pln(coins(15) + "");
		pln(coins(14) + "");
		pln(coins(13) + "");
		pln(coins(12) + "");

	}

	public static int ret() {
		return 17;
	}

	public static boolean logic(boolean a, boolean b, boolean c) {
		if (a && b && c) {
			return true;
		} else {
			return false;
		}
	}	
	
	
	public static String stars(int n) {
		String pstars = "";
		for (int i = 0; i < n; i++) {
			for (int j = i; j > -1; j--){
				pstars += "*";
			}
			pstars += "\n";
		}
		return pstars;
		
	}
	
	public static int coins(int n) {
		int c = 0;
		if (n % 5 != 0 && n % 2 != 0) {
			c = -1;
		} else {
			c += (n / 5);
			int two = n - (5 * c);
			c += (two / 2);
		}
		return c;
	}
	public static void p (String args) {
		System.out.print(args);
	}

	public static void pln (String args) {
		System.out.println(args);
	}
}
