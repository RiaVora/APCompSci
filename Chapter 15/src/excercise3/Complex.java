package excercise3;

public class Complex {
		//Transform the following class method into an object method.
		int real;
		int imag;
		
		public Complex() {
			real = 1;
			imag = 0;
		}
		
		//The Given (object method)
//		public boolean equals(Complex b) {
//			return(real == b.real && imag == b.imag);
//		}
		
		//Answer (class method)
		public boolean equals(Complex b1, Complex b2) {
			return(b1.real == b2.real && b1.imag == b2.imag);
		}
}
