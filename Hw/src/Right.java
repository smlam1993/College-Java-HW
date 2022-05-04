/* 
 * 	Name:  		Lam, Simon 
 * 	Homework: 	# 5
 * 	Due:       	November 20, 2012 
 * 	Course: 	CS-141-01-f12 
 * 
 *	Description: 
 *  	This is the Right Triangle class, a more specialized class for triangle.
 *  This class has its own unique methods that is computed in a different manner.
 */

public class Right extends Triangle{
	private double hypotenuse;
	
	public Right(double base, double height) {
		super(ShapeTag.TRIANGLE, base, height);
	}
	
	public Right(double base, double height, Point corner) {
		super(ShapeTag.TRIANGLE, base, height, corner);
	}
	
	public double getArea() {
		return 1.0 / 2.0 * getBase() * getHeight();
	}
	
	public void setHypotenuse() {
		hypotenuse = Math.sqrt(getBase() * getBase() + getHeight() * getHeight());
	}
	
	public double getPerimeter() {
		setHypotenuse();
		return getBase() + hypotenuse + getHeight();
	}
	
	public String toString() {
		return "Right " + getTag() + "[" + getBase() + ", " + getHeight() +"]: " + getPoint() 
				+ ". Area = " + getArea() + ".\n\t\tPerimeter = " + getPerimeter() + ".";
	}
}
