/*
 *  Name: Lam, Simon
 *  Due : November 2, 2012
 *  Quiz: #6
 */
public class Complex {
	private int real, imaginary;
	private static int defObjCount = 0;
	
	public Complex () {
		this(0,0);
	}
	
	public Complex (int real, int imaginary) {
		this.real = real;
		this.imaginary = imaginary;
		defObjCount++;
	}
	
	public Complex (Complex com) {
		this(com.real, com.imaginary);
	}
	
	public static void showCounter () {
		System.out.println("Counter: " + defObjCount);
	}
	public int getReal () {
		return real;
	}
	
	public int getImaginary () {
		return imaginary;
	}
	
	public boolean equals (Complex com) {
		return real == com.real && imaginary == com.imaginary;
	}
	
	public String toString () {
		return real + " + " + imaginary + "i";
	}
	
	public void copy (Complex com) {
		com.real = real;
		com.imaginary = imaginary;
	}
	
	/*
	 *this method will never change since it is
	 *just multiplying 2 complex numbers 
	 */
	public static Complex multiply (Complex com1, Complex com2) { //(ac-bd) + (bc + ad)i
		return new Complex((com1.real * com2.real) - (com1.imaginary * com2.imaginary)
				, (com1.imaginary * com2.real) + (com1.real * com2.imaginary));
	}
	
	/*
	 * this method will never change since we are just
	 * adding two complex numbers together
	 */
	public static Complex sum (Complex com1, Complex com2) { //(a+c) + (b + d)i
		return new Complex(com1.real + com2.real, com1.imaginary + com2.imaginary);
	}
	
	public static void main (String[] args) {
		Complex[] complex = new Complex[4];
		complex[0] = new Complex(1,1);
		complex[1] = new Complex(3,3);
		System.out.println("Equals?" + complex[0].equals(complex[1]));
		System.out.println(complex[0].toString());
		System.out.println(complex[1].toString());
		complex[0].copy(complex[1]);
		System.out.println(complex[1].toString() + " copy");
		complex[2] = Complex.multiply(complex[0], complex[1]);
		System.out.println(complex[2].toString() + " multiplied");
		complex[3] = Complex.sum(complex[0], complex[1]);
		System.out.println(complex[3].toString() + " added");
		Complex.showCounter();
	}
}
