package com.metacampus.vehiclemanagement;

import com.metacampus.vehiclemanagement.model.Bike;
import com.metacampus.vehiclemanagement.model.Car;
import com.metacampus.vehiclemanagement.model.Vehicle;

public class VehicleHelper {
	
	public static Vehicle createVehicle( VehicleType vehicleType, String make, String model, int engineInCC,
			int fuelCapacity, int mileage, float price, float roadTax)
	{
		if(vehicleType.equals(VehicleType.CAR)) {
			
			Car car=new Car();
			car.setMake(make);
			car.setModel(model);
			car.setEngineInCC(engineInCC);
			car.setFuelCapacity(fuelCapacity);
			car.setMileage(mileage);
			car.setPrice(price);
			car.setRoadTax(roadTax);
			return car;
			
			
		}
		else if(vehicleType.equals(VehicleType.BIKE)){
			
			Bike bike=new Bike();
			bike.setMake(make);
			bike.setModel(model);
			bike.setEngineInCC(engineInCC);
			bike.setFuelCapacity(fuelCapacity);
			bike.setMileage(mileage);
			bike.setPrice(price);
			bike.setRoadTax(roadTax);
			return bike;
		}
		
		else {
			return null;
		}
	}
	
	/*public static Car createCar(String make, String model, int engineInCC,int fuelCapacity,	int mileage,
			float price, float roadTax, boolean aC, boolean powerSteering, String accessoryKit ) {
		Car car = new Car();
		car.setMake(make);
		car.setModel(model);
		car.setEngineInCC(engineInCC);
		car.setFuelCapacity(fuelCapacity);
		car.setMileage(mileage);
		car.setPrice(price);
		car.setRoadTax(roadTax);
		car.setAC(aC);
		car.setPowerSteering(powerSteering);
		car.setAccessoryKit(accessoryKit);
		return car;
	}*/
	
	public static Car createCar(Vehicle vehicle, boolean aC, boolean powerSteering, String accessoryKit ) {
		
		Car car = (Car) vehicle;
		
		car.setAC(aC);
		car.setPowerSteering(powerSteering);
		car.setAccessoryKit(accessoryKit);
		return car;
	}
	
	/*public static Bike createBike(String make, String model, int engineInCC,int fuelCapacity,	int mileage,
			float price, float roadTax, boolean selfStart, int helmetPrice) {
		
		Bike bike = new Bike();
		bike.setMake(make);
		bike.setModel(model);
		bike.setEngineInCC(engineInCC);
		bike.setFuelCapacity(fuelCapacity);
		bike.setMileage(mileage);
		bike.setPrice(price);
		bike.setRoadTax(roadTax);
		bike.setSelfStart(selfStart);
		bike.setHelmetPrice(helmetPrice);
		return bike;
	}*/
	
	public static Bike createBike(Vehicle vehicle, boolean selfStart, int helmetPrice) {
		
		Bike bike = (Bike) vehicle;
		
		bike.setSelfStart(selfStart);
		bike.setHelmetPrice(helmetPrice);
		return bike;
	}

}
