package com.metcampus.vehiclemanagement;

import static org.junit.Assert.*;

import org.junit.Test;

import com.metacampus.vehiclemanagement.VehicleDetailPrinter;
import com.metacampus.vehiclemanagement.VehicleHelper;
import com.metacampus.vehiclemanagement.model.Bike;

public class VehicleDetailPrinterTest {

	@Test
	public void testPrintVehicleSpecification() {
		Bike bike = VehicleHelper.createBike("Royal Enfield", "Bullet 300", 350, 15,
				30, 120000.14f, 15001.45f, true, 1500);
		assertNotNull(bike);
		assertEquals("Make : Royal Enfield Model : Bullet 300 EngineInCC : 350 Mileage : 30 "
				+ "FuelCapacity : 15 Price : 120000.14 RoadTax : 15001.45 SelfStart : true"
				+ " HelmetPrice : 1500", VehicleDetailPrinter.printVehicleSpecification(bike));
	}

}
