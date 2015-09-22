package com.metcampus.vehiclemanagement;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.metacampus.vehiclemanagement.StaXParser;
import com.metacampus.vehiclemanagement.VehicleDaoHealper;
import com.metacampus.vehiclemanagement.model.Vehicle;

public class VehicleDaoHelperTest {

	StaXParser st = new StaXParser();
	List<Vehicle> cars = st.readConfig("../CaseStudy1/xmlFiles/carinput.xml");
	List<Vehicle> bikes = st.readConfig("../CaseStudy1/xmlFiles/bikeinput.xml");
	
	//test case for method insert into vehicle
	@Test
	public void insertIntoVehicleTest() {
		boolean expected = true;
		boolean actual = false;
		for(Vehicle vehicle : cars){
			actual = VehicleDaoHealper.insertIntoVehicle(vehicle);
		}
		for(Vehicle vehicle : bikes){
			actual = (VehicleDaoHealper.insertIntoVehicle(vehicle));
		}
		assertEquals( expected, actual);
	}
}
