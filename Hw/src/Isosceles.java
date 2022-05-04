/* 
 * 	Name:  		Lam, Simon 
 * 	Homework: 	# 5
 * 	Due:       	November 20, 2012 
 * 	Course: 	CS-141-01-f12 
 * 
 *	Description: 
 *  	This is the Isosceles Triangle class, a more specialized class for triangle.
 *  This class has its own unique methods that is computed in a different manner.
 */

public class Isosceles extends Triangle{
	private double side;
	
	public Isosceles(double base, double side) {
		super(ShapeTag.TRIANGLE, base, Math.sqrt(side * side - (1.0 / 4.0) * base * base));
		this.side = side;
	}
	
	public Isosceles(double base, double side, Point corner) {
		super(ShapeTag.TRIANGLE, base, Math.sqrt(side * side - (1.0 / 4.0) * base * base), corner);
		this.side = side;
	}
	
	public double getArea() {
		return 1.0 / 2.0 * getBase() * getHeight();
	}
	
	public double getPerimeter() {
		return getBase() + side + side;
	}
	
	public String toString() {
		return "Isosceles " + getTag() + "[" + getBase() + ", " + getHeight() +"]: " + getPoint() 
				+ ". Area = " + getArea() + ".\n\t\tPerimeter = " + getPerimeter() + ". Side = " + side;
	}
}
