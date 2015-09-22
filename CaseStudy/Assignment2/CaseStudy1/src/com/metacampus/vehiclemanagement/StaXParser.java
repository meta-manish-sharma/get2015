package com.metacampus.vehiclemanagement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.metacampus.vehiclemanagement.model.Bike;
import com.metacampus.vehiclemanagement.model.Car;
import com.metacampus.vehiclemanagement.model.Vehicle;

public class StaXParser {

	static final String ROW = "row";
	static final String TYPE = "type";
	static final String VEHICLEID = "vehicleId";
	static final String MAKE = "make";
	static final String MODEL = "model";
	static final String ENGINEINCC = "engineInCC";
	static final String FUELCAPACITY = "fuelCapacity";
	static final String MILEAGE = "mileage";
	static final String PRICE = "price";
	static final String ROADTAX = "roadTax";
	static final String AC = "ac";
	static final String POWERSTEERING = "powerSteering";
	static final String ACCESSORYKIT = "accessoryKit";
	static final String SELFSTART = "selfStart";
	static final String HELMETPRICE = "helmetPrice";

	
	public List<Vehicle> readConfig(String vehicle) {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		try {
			// First, create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream in = new FileInputStream(vehicle);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			// read the XML document
			Vehicle vechile  = null;

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				
				// System.out.println("event:"+event);
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					
					// If we have an item element, we create a new vehicle according their type
					if (startElement.getName().getLocalPart() == (ROW)) {
						
						// We read the attributes from this tag and check the type						
						@SuppressWarnings("unchecked")
						Iterator<Attribute> attributes = startElement.getAttributes();
						  while (attributes.hasNext()) {
							  Attribute attribute = attributes.next();
							  if (attribute.getName().toString().equals(TYPE)) {
								  if(attribute.getValue().equalsIgnoreCase("car")){
									  vechile = new Car();	
								  }
								  else {
									  vechile = new Bike();
								  }
							  }
						  }
						 
					}
						if (event.asStartElement().getName().getLocalPart()
								.equals(VEHICLEID)) {

							event = eventReader.nextEvent();
							vechile.setVehicleId(Double.parseDouble(event
									.asCharacters().getData()));
							//continue;
						}
					//}
					//if (event.isStartElement()) {
						else if (event.asStartElement().getName().getLocalPart()
								.equals(MAKE)) {
							event = eventReader.nextEvent();
							vechile.setMake(event.asCharacters().getData());
							//continue;
						}
					//}
					//if (event.isStartElement()) {
						else if (event.asStartElement().getName().getLocalPart()
								.equals(MODEL)) {
							event = eventReader.nextEvent();
							vechile.setModel(event.asCharacters().getData());
							//continue;
						}
					//}
					//if (event.isStartElement()) {
						else if (event.asStartElement().getName().getLocalPart()
								.equals(ENGINEINCC)) {
							event = eventReader.nextEvent();
							vechile.setEngineInCC(Integer.parseInt(event
									.asCharacters().getData()));
							//continue;
						}
					//}
					//if (event.isStartElement()) {
						else if (event.asStartElement().getName().getLocalPart()
								.equals(FUELCAPACITY)) {
							event = eventReader.nextEvent();
							vechile.setFuelCapacity(Integer.parseInt(event
									.asCharacters().getData()));
							//continue;
						}
					//}
						else if (event.asStartElement().getName().getLocalPart()
							.equals(MILEAGE)) {
						event = eventReader.nextEvent();
						vechile.setMileage(Integer.parseInt(event.asCharacters()
								.getData()));
						//continue;
					}
					//if (event.isStartElement()) {
						else if (event.asStartElement().getName().getLocalPart()
								.equals(PRICE)) {
							event = eventReader.nextEvent();
							vechile.setPrice(Float.parseFloat(event.asCharacters()
									.getData()));
							//continue;
						}
					//}
					//if (event.isStartElement()) {
						else if (event.asStartElement().getName().getLocalPart()
								.equals(ROADTAX)) {
							event = eventReader.nextEvent();
							vechile.setRoadTax(Float.parseFloat(event
									.asCharacters().getData()));
							//continue;
						}
					//}
					//if (event.isStartElement()) {
						else if (event.asStartElement().getName().getLocalPart()
								.equals(AC)) {
							event = eventReader.nextEvent();
							((Car) vechile).setAC(Boolean.parseBoolean(event.asCharacters()
									.getData()));
							//continue;
						}
					//}
					//if (event.isStartElement()) {
						else if (event.asStartElement().getName().getLocalPart()
								.equals(POWERSTEERING)) {
							event = eventReader.nextEvent();
							((Car) vechile).setPowerSteering(Boolean.parseBoolean(event
									.asCharacters().getData()));
							//continue;
						}
					//}
					//if (event.isStartElement()) {
						else if (event.asStartElement().getName().getLocalPart()
								.equals(ACCESSORYKIT)) {
							event = eventReader.nextEvent();
							((Car) vechile).setAccessoryKit(event.asCharacters().getData());
							// System.out.println(car);
							//continue;
						}
					//}
					//if (event.isStartElement()) {
						else if (event.asStartElement().getName().getLocalPart()
								.equals(SELFSTART)) {
							event = eventReader.nextEvent();
							((Bike) vechile).setSelfStart(Boolean.parseBoolean(event.asCharacters().getData()));
							// System.out.println(car);
							//continue;
						}
					//}
					//if (event.isStartElement()) {
						else if (event.asStartElement().getName().getLocalPart()
								.equals(HELMETPRICE)) {
							event = eventReader.nextEvent();
							((Bike) vechile).setHelmetPrice(Integer.parseInt(event.asCharacters().getData()));	
							//continue;
						}
					//}
					// If we reach the end of an item element, we add it to the
					
					
					

				}
				
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart() == (ROW)) {
						//if(vechile instanceof Car) {
							vehicles.add(vechile);	
						//}
						//else	{
							//vehicles.add(vechile);
						//}
					}
				}
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return vehicles;
	}
}
