/**
 * Create a Soap Web Service Client and Server.

	Server: It will get an input as temperature as Fahrenheit and return back as celsius.
	Client: It will call above webservice and convert Fahrenheit to celsius by giving input.

 */
package com.metacube.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author Manish
 *
 */
@WebService
public class FahrenheitToCelsius {
	
	@WebMethod
	public float fahrenheitToCelsiusConverter(float input) {
		
		return (input-32)*5/9;
		
	}
}
