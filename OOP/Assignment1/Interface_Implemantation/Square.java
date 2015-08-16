/**
 * This is Square class it implements the Shape interface
 * @author Manish
 */

package Interface_Implemantation;

public class Square implements Shape{
	double edge;
	
	//This is constructor of square class
	public Square(int edge) {
		this.edge = edge;
	}
	
	//this is definition of draw method
	public String draw() {
		return "This is square ";
	}
	
	//this is definition of getArea method
	public double getArea() {
		double area = edge * edge;
		return area;
	}

}
