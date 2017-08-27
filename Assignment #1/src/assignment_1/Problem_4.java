package assignment_1;

public class Problem_4 {
	public static void main (String[] args) {
		pln(coins(15) + "");
		pln(coins(14) + "");
		pln(coins(13) + "");
		pln(coins(12) + "");

	}
	
	public static int coins(int n) {
		int c = 0;
		if (n % 5 != 0 && n % 2 != 0) {
			c = -1;
//		} else if (n % 2 == 0){
//			return (n / 2);
//		} 
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
