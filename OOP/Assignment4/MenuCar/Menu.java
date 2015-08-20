package MenuCar;

/**Car Service System
 *@auther Manish 
 */

import java.util.ArrayList;
import java.util.Iterator;


//This class maintain all the printing operations
public class Menu {
	
	//Shows the report of car serviced
	public void showReport(int [] carServiced){
		System.out.println("\n\nTotal No. of Sedan Serviced - " + carServiced[0]
				+ "\n\n" + "Total No. of SUV Serviced - " + carServiced[1] + "\n\n"
				+ "Total No. of HatchBack Serviced - " + carServiced[2]);
		
		System.out.println("\nTotal Earning of the Day was -- " + carServiced[3]
				+ " Rs");
	}
	
	//Shows the car allocation
	public void display(ArrayList<Car> car ) {
		Iterator<Car> carIterator = ((ArrayList<Car>) car).iterator();
		do {
			Car carObject = carIterator.next();
			String cId = carObject.carId;
			String mName = carObject.mechanicName;
			String cType = carObject.type;

			System.out.println("Car Id--> " + cId + " ( " + cType + " ) "
					+ " is allocated to Mechanic - " + mName);

		} while (carIterator.hasNext());
			
	}
}
