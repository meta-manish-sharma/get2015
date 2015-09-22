package com.metcampus.vehiclemanagement;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.metacampus.vehiclemanagement.StaXParser;
import com.metacampus.vehiclemanagement.model.Vehicle;

public class StaXParserTest {
	StaXParser st = new StaXParser();
	
	@Test
	public void readConfigTest() {
		List<Vehicle> cars = st.readConfig("../CaseStudy1/xmlFiles/carinput.xml");
		List<Vehicle> bikes = st.readConfig("../CaseStudy1/xmlFiles/bikeinput.xml");
		if(cars.size()==0 || bikes.size()==0) {
			fail("Objects are not created");
		}	
	}
}
