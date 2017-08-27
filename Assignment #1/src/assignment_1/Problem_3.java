package assignment_1;

public class Problem_3 {
	public static void main (String[] args) {
		stars(5);
	}
	
	public static void stars(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i; j > -1; j--){
				p("*");
			}
			p("\n");
		}
		
	}
	
	public static void p (String args) {
		System.out.print(args);
	}

	public static void pln (String args) {
		System.out.println(args);
	}

}
