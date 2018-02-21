package excercise2;

public class Complex {
	//Transform the following class method into an object method.
	int real;
	int imag;
	
	public Complex() {
		real = 1;
		imag = 0;
	}
	
	//The Given (class method)
//	public static double abs(Complex c) {
//		return Math.sqrt(c.real * c.real + c.imag * c.imag);
//	}
	
	//Answer (object method)
	public double abs(Complex c) {
		return Math.sqrt(real * real + imag * imag);
	}
}
