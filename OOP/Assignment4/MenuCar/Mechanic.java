package MenuCar;


import java.util.ArrayList;

//class have Mechanic Attribute
public class Mechanic {

	//Array list which hold Mechanic Objects
	public  ArrayList<Mechanic> mech = new ArrayList<Mechanic>();
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
	
	public Mechanic(){
		
	}
	//setting the mechanic objects in Mechanic ArrayList
	public  ArrayList<Mechanic> setMechanic(){
		mech.add(new Mechanic("Ravi", "Sedan", 3000, 0));
		mech.add(new Mechanic("Sonu", "SUV", 5000, 0));
		mech.add(new Mechanic("Sunil", "HatchBack", 2000, 0));
		mech.add(new Mechanic("Ram", "Sedan", 3000, 0));
		mech.add(new Mechanic("Shayam", "SUV", 5000, 0));
		mech.add(new Mechanic("Mohan", "HatchBack", 2000, 0));
		mech.add(new Mechanic("John", "SUV", 5000, 0));
		mech.add(new Mechanic("James", "Sedan", 3000, 0));
		mech.add(new Mechanic("Lee", "HatchBack", 2000, 0));
		return mech;
	}
}