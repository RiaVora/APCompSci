package excercise4;

public class Rational {
	public int n;
	public int d;
	
	public static void main (String[] args) {
		//r1 = constructor with no arguments
		Rational r1 = new Rational();
		pln("Rational Number 1 (Numerator = 0, Denominator = 1)");
		p("Your number is: ");
		r1.printRational();
		r1.negate();
		p("Your number negated is: ");
		r1.printRational();
		r1.negate();
		r1.invert();
		p("Your number inverted is: ");
		r1.printRational();
		p("Your number negated and inverted as a double is: ");
		p(r1.toDouble() + "");
		
		//r2 = constructor with arguments
		pln("\n\nRational Number 2 (Numerator = 14, Denominator = 6)");
		Rational r2 = new Rational(14, 6);
		p("Your number is: ");
		r2.printRational();
		r2.negate();
		p("Your number negated is: ");
		r2.printRational();
		r2.negate();
		r2.invert();
		p("Your number inverted is: ");
		r2.printRational();
		p("Your number negated and inverted as a double is: ");
		p(r2.toDouble() + "");
		r2.reduce();
		pln("\nRational Number 3 (Numerator = 2, Denominator = 8)");
		Rational r3 = new Rational(2, 8);
		pln("The result of adding r2 and r3 is " + r3.add(r2));
	}
	
	public Rational(int n, int d) {
		this.n = n;
		this.d = d;
	}
	
	public Rational() {
		n = 0;
		d = 1;
	}
		
	public void printRational() {
		pln(n + "/" + d);
	}
	
	public void negate() {
		n = n*-1;
	}
	
	public void invert() {
		int n1 = n;
		int d1 = d;
		d = n1;
		n = d1;
	}
	
	public double toDouble() {
		double r = (double)n/d;
		return r;
	}
	
	public void reduce() {
		int GCM = findGCM(n, d);
		pln("\nYour reduced number is " + n/GCM + "/" + d/GCM);
	}
	
	public String add(Rational r2) {
		int mult1;
		int mult2;
		int n1;
		int n2;
		int newD;
		if (d > r2.d) {
			mult1 = findLCM(d, r2.d);
			newD = d*mult1;
			n1 = n*mult1;
			mult2 = (mult1 * d)/r2.d;
			n2 = r2.n * mult2;
		} else {
			mult2 = findLCM(r2.d, d);
			newD = r2.d*mult2;
			n2 = r2.n * mult2;
			mult1 = (mult2 * r2.d)/d;
			n1 = n*mult1;
		}
		int GCM = findGCM(n1 + n2, newD);
		return (n1 + n2)/GCM + "/" + newD/GCM;
		
	}
	
	private int findLCM(int d1, int d2) {
		boolean found = false;
		int mult = 0;
		int i = 1;
		while (found == false) {
			if ((d1 * i) % d2 == 0) {
				mult = i;
				found = true;
			}
		}
		return mult;
	}
	
	public int findGCM(int a, int b) {
		 while(a!=0 && b!=0) {
			 int c = b;
			 b = a % b;
			 a = c;
		 }
		 return a+b;
	}
		
//	Exercise 11.3. A rational number is a number that can be represented as
//	the ratio of two integers. For example, 2/3 is a rational number, and you
//	can think of 7 as a rational number with an implicit 1 in the denominator.
//	For this assignment, you are going to write a class definition for rational
//	numbers.
//	11. Write a method called add that takes two Rational numbers as arguments
//	and returns a new Rational object. The return object should
//	contain the sum of the arguments.
//	There are several ways to add fractions. You can use any one you want,
//	but you should make sure that the result of the operation is reduced so
//	that the numerator and denominator have no common divisor (other
//	than 1).
//	The purpose of this exercise is to write a class definition that includes a
//	variety of methods, including constructors, modifiers and pure functions.
	
	public static void p (String args) {
		System.out.print(args);
	}

	public static void pln (String args) {
		System.out.println(args);
	}

}
