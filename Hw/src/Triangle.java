/* 
 * 	Name:  		Lam, Simon 
 * 	Homework: 	# 5
 * 	Due:       	November 20, 2012 
 * 	Course: 	CS-141-01-f12 
 * 
 *	Description: 
 *  	This is the Triangle class that has the behaviors and fields for a triangle. This is
 *  the parent class to the three subclasses: Equilateral, Right, and Isosceles.
 */

public class Triangle extends Shape{
	
	private double base, height;
	
	public Triangle(double base, double height){
		super(ShapeTag.TRIANGLE);
		setPointTag("Corner");
		this.base = base;
		this.height = height;
	}
	
	public Triangle(ShapeTag tag, double base, double height){
		super(tag);
		setPointTag("Corner");
		this.base = base;
		this.height = height;
	}
	
	public Triangle(ShapeTag tag, double base, double height, Point rightAngleCorner){
		super(tag, rightAngleCorner);
		setPointTag("Corner");
		this.base = base;
		this.height = height;
	}
	
	public double getBase(){
		return base;
	}
	
	public double getHeight(){
		return height;
	}
}
