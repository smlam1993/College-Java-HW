/* 
 * 	Name:  		Lam, Simon 
 * 	Homework: 	# 5
 * 	Due:       	November 20, 2012 
 * 	Course: 	CS-141-01-f12 
 * 
 *	Description: 
 *  	This is the Equilateral Triangle class, a more specialized class for triangle.
 *  This class has its own unique methods that is computed in a different manner.
 */

public class Equilateral extends Triangle{

	public Equilateral(double base) {
		super(ShapeTag.TRIANGLE, base, Math.sqrt(3) / 2 * base);
	}
	
	public Equilateral(double base, Point corner) {
		super(ShapeTag.TRIANGLE, base, Math.sqrt(3) / 2 * base, corner);
	}
	
	public double getArea() {
		return Math.sqrt(3.0) / 4 * getBase() * getBase();
	}
	
	public double getPerimeter() {
		return 3 * getBase();
	}
	
	public String toString() {
		return "Equilateral " + getTag() + " [" + getBase() + "]:" + getPoint() 
				+ ". Area = " + getArea() + ".\n\t\tPerimeter = " + getPerimeter() + ". Height = " + getHeight(); 
	}
}
