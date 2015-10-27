package com.metacube.webservices;

public class WSClient {
	 
	public static void main(String[] args) {
		FahrenheitToCelsiusServiceLocator fahrenheitToCelsiusServiceLocator = new FahrenheitToCelsiusServiceLocator();
		fahrenheitToCelsiusServiceLocator.setFahrenheitToCelsiusEndpointAddress("http://localhost:8080/TemperatureConverterWS/services/FahrenheitToCelsius");
		try {
			FahrenheitToCelsius fahrenheitToCelsius = fahrenheitToCelsiusServiceLocator.getFahrenheitToCelsius();
			
			System.out.println(fahrenheitToCelsius.fahrenheitToCelsiusConverter(33.8f));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}