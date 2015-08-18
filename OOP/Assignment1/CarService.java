/**Car Service System
 *@auther Manish 
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//class which manage the Whole Application
public class CarService {
	//Array list which hold Mechanic Objects
	public static ArrayList<Mechanic> mech = new ArrayList<Mechanic>();
	//Array list which hold Car Objects
	public static ArrayList<Car> car = new ArrayList<Car>();
	static int  sedan = 0;
	static int  suv = 0;
	static int  hatchback = 0;
	static int totalEarning = 0;
	
	public static void totalEarning(){
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

	}

	public void showAllocation() {
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
		mech.add(new Mechanic("Ravi", "Sedan", 3000, 0));
		mech.add(new Mechanic("Sonu", "SUV", 5000, 0));
		mech.add(new Mechanic("Sunil", "HatchBack", 2000, 0));
		mech.add(new Mechanic("Ram", "Sedan", 3000, 0));
		mech.add(new Mechanic("Shayam", "SUV", 5000, 0));
		mech.add(new Mechanic("Mohan", "HatchBack", 2000, 0));
		mech.add(new Mechanic("John", "SUV", 5000, 0));
		mech.add(new Mechanic("James", "Sedan", 3000, 0));
		mech.add(new Mechanic("Lee", "HatchBack", 2000, 0));

		String flag = "0";
		Scanner sc = new Scanner(System.in);
		int p = 0;

		System.out.println("****CAR SERVICE CENTER****\n");
		while (flag.equals("0")) {
			System.out.println("Enter car details..! \n");

			System.out.println("Enter your Car type..");
			String ctype = sc.next();
			System.out.println("Enter your Car no. OR Owner name..");
			String cId = sc.next();
			String Mname = "NOT ALLOCATED";
			cId = cId + "-" + (++p);

			Iterator<Mechanic> mechanicIterator = ((ArrayList<Mechanic>) mech)
					.iterator();
			do {
				Mechanic mechanicObject = mechanicIterator.next();

				if (mechanicObject.mechanicCar.equalsIgnoreCase(ctype)
						&& (mechanicObject.avail == 0)) {
					Mname = mechanicObject.mechanicName;
					mechanicObject.avail = 1;
					break;
				}
			} while (mechanicIterator.hasNext());

			car.add(new Car(ctype, cId, Mname));
			System.out
					.println("\nIf you want to continue Application then Press 0 \nfor exit from Application Press Any key");
			// flag = sc.next();
			if (!(sc.next().equals("0"))) {
				System.out
						.println("\nAre You Really Want to Exit From Application ? y/n");
				if (sc.next().equalsIgnoreCase("n")) {
					flag = "0";
				} else {
					flag = "1";
				}
			}

		}
		
		CarService carService=new CarService();
		carService.showAllocation();
		CarService.totalEarning();		
				System.out.println("\n\nTotal No. of Sedan Serviced - " + sedan
				+ "\n\n" + "Total No. of SUV Serviced - " + suv + "\n\n"
				+ "Total No. of HatchBack Serviced - " + hatchback);
		System.out.println("\nTotal Earning of the Day was -- " + totalEarning
				+ " Rs");
		sc.close();
	}

}

//class have Car Attribute
class Car {

	public String type;
	public String carId;
	public String mechanicName;

	public Car(String type, String carId, String mechanicName) {
		this.type = type;
		this.carId = carId;
		this.mechanicName = mechanicName;
	}

}

//class have Mechanic Attribute
class Mechanic {

	public String mechanicName;
	public String mechanicCar;
	public int rate;
	public int avail;

	public Mechanic(String mechanicName, String mechanicCar, int rate, int avail) {
		this.mechanicCar = mechanicCar;
		this.mechanicName = mechanicName;
		this.rate = rate;
		this.avail = avail;
	}

}