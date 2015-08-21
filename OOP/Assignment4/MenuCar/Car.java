package MenuCar;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//class have Car Attribute
public class Car {
	
	public ArrayList<Car> car = new ArrayList<Car>();
	public String type;
	public String carId;
	public String mechanicName;

	public Car(String type, String carId, String mechanicName) {
		this.type = type;
		this.carId = carId;
		this.mechanicName = mechanicName;
	}
	public Car(){	
	}
	
	//Store the car details
	public ArrayList<Car> setCarDetails( ArrayList<Mechanic> mech){
		
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
		
		return	car;	
		
	}

}