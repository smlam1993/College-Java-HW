
/*
 * CS141
 * (C) 2012 T.Nguyen
 * 
 * 	Name:  		Lam, Simon 
 * 	Homework: 	# 5
 * 	Due:       	November 20, 2012 
 * 	Course: 	CS-141-01-f12 
 * 
 *	Description: 
 *  	I have added the three types of triangles to the file ShapeDemo. This will output the
 *  	statements for the three different types of triangles.
 */

public class ShapeDemo {

	public static void main (String[] args) {
        
        Circle  circle = new Circle(10, new Point(5, 5));
        Rectangle  rectangle = new Rectangle(6, 2);
        Square square = new Square(4);
        Equilateral equil = new Equilateral(4);
        Right right = new Right(3,4);
        Isosceles iso = new Isosceles(4, 3);
        
        System.out.println("area of " + circle + " = " + circle.getArea());
        System.out.println("perimeter of " + circle + " = " + circle.getPerimeter());

        System.out.println(rectangle);
        System.out.println(square + " area = " + square.getArea());

        System.out.println(equil);
        System.out.println();
        System.out.println(right);
        System.out.println();
        System.out.println(iso);
	}
}