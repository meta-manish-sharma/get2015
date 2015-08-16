/**
 * This is circle class it implements the Shape interface
 * @author Manish
 */
package Interface_Implemantation;

public class Circle implements Shape {
	double radius;
	
	//This is constructor of circle class
	public Circle(int radius){
		this.radius=radius;
	}
	
	//this is definition of draw method 
	public String draw(){
		return "This is circle ";
	}
	
	//this is definition of getArea method
	public double getArea(){
		double area=3.14*(radius*radius);
		return area;
	}
}
