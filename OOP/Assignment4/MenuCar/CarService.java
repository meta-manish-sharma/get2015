package MenuCar;
/**Car Service System
 *@auther Manish 
 */

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


	//Execution Starts from here
	public static void main(String args[]) {
		
		mech=new Mechanic().setMechanic();
		car=new Car().setCarDetails(mech);
		new Menu().display(car);
		int carServiced [] =totalEarning( );
		new Menu().showReport(carServiced);
		
	}

}



