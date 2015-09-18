package com.metcampus.vehiclemanagement;

import static org.junit.Assert.*;

import org.junit.Test;

import com.metacampus.vehiclemanagement.VehicleHelper;
import com.metacampus.vehiclemanagement.VehicleType;
import com.metacampus.vehiclemanagement.model.Bike;
import com.metacampus.vehiclemanagement.model.Car;
import com.metacampus.vehiclemanagement.model.Vehicle;

public class VehicleHelperTest {

	@Test
	public void testCreateCar() {
		
		Vehicle vehicle =  VehicleHelper.createVehicle (VehicleType.CAR,"Ford", "EcoSport", 
				2000, 50, 22, 850000.41f, 40000.21f);
		
		Car car = VehicleHelper.createCar(vehicle, true, true, "Radio , Cd Player");
		assertNotNull(car);
		assertEquals("EcoSport" , car.getModel());
 	}
	
	@Test
	public void testCalculateOnRoadPrice() {
		
		Vehicle vehicle =  VehicleHelper.createVehicle (VehicleType.BIKE,"Royal Enfield", "Bullet 300",
				350, 15, 30, 120000.14f, 15001.45f);
		Bike bike = VehicleHelper.createBike(vehicle, true, 1500);
		assertNotNull(bike);
		assertEquals(136501.59 , bike.calculateOnRoadPrice(),0.1);
 	}
}
