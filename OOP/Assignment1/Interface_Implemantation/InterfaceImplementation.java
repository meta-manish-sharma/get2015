/**
 * This class implements all the functions of square and circle class
 * @author Manish
 */
package Interface_Implemantation;

import java.util.Scanner;

public class InterfaceImplementation {
	public static void main(String args[]){
		 int radius=0,edge=0,choice=0;
		
		Scanner sc=new Scanner(System.in);
		
		
		
		try{
			do{
				System.out.println("Please enter 1 to circle 2 for square 3 for exit ");
				choice=sc.nextInt();
				switch(choice){
					case 1:	
						System.out.println("Enter the radius of circle");
						radius=sc.nextInt();
						Shape circle=new Circle(radius);
						System.out.println(circle.draw());
						System.out.println("Area of circle = "+circle.getArea());
						break;
					case 2:		
					System.out.println("Enter the edge of square");
					edge=sc.nextInt();
					Shape square=new Square(edge);
					System.out.println(square.draw());
					System.out.println("Area of square = "+square.getArea());
					break;
					
					case 3: 
						return;
				 default:
				System.out.println("Please Enter 1 or 2 or 3 for exit");
				}
				}while(choice!=3);	
		}catch(Exception e){
			System.out.println("Please enter valid value");
		 }
		
		sc.close();
	}
}
