package MenuCar;

import java.util.ArrayList;
import java.util.Iterator;

//class which manage the Whole Application
public class CarService {
	
	//Array list which hold Mechanic Objects
	public static ArrayList<Mechanic> mech ;
	
	//Array list which hold Car Objects
	public static ArrayList<Car> car ;
	
	static int  sedan = 0;
	static	int  suv = 0;
	static	 int  hatchback = 0;
	static	 int totalEarning = 0;
	
	//function for calculating the total earning and for each type of car
	public static int [] totalEarning( ){
		int carServiced[]=new int [4];
		Iterator<Mechanic> mechanicIterator = ((ArrayList<Mechanic>) mech).iterator();
		do {
			Mechanic mechanicObject = mechanicIterator.next();
			if (mechanicObject.avail == 1) {
				totalEarning += mechanicObject.rate;
				if (mechanicObject.mechanicCar.equals("Sedan")) {
					sedan++;
				}
				if (mechanicObject.mechanicCar.equals("SUV")) {
					suv++;
				}
				if (mechanicObject.mechanicCar.equals("HatchBack")) {
					hatchback++;
				}

			}
		} while (mechanicIterator.hasNext());
		
		carServiced[0]=sedan;
		carServiced[1]=suv;
		carServiced[2]=hatchback;
		carServiced[3]=totalEarning;
		
		return carServiced;
		
	}
	
	//Shows the report of car serviced
	public void showReportForDay(int [] carServiced){
		System.out.println("\n\nTotal No. of Sedan Serviced - " + carServiced[0]
				+ "\n\n" + "Total No. of SUV Serviced - " + carServiced[1] + "\n\n"
				+ "Total No. of HatchBack Serviced - " + carServiced[2]);
		
		System.out.println("\nTotal Earning of the Day was -- " + carServiced[3]
				+ " Rs");
	}

	//Shows the car allocation
	public void displayCarAllocation() {
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


	//Execution Starts from here
	public static void main(String args[]) {
		
		//Creating the Mechanic ArrayList
		mech=new Mechanic().setMechanic();
		
		car=new Car().setCarDetails(mech);
		
		//creating the object of SetMenuItem Class to call its Constructor
		SetMenuItem setMenuItem=new SetMenuItem();
	}

}



