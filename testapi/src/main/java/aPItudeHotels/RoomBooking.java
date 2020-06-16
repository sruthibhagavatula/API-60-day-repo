package aPItudeHotels;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RoomBooking extends KeyGeneration {
	
	public static String bookingRef;
	@Test(dependsOnMethods= {"aPItudeHotels.HotelAvailability.getHotelAvailability"})
	public void roomBooking()
	{
		
		Response resp = RestAssured
				.given().log().all()
				.headers(headerVal)
				.when()
				.body("{\r\n" + 
						"    \"holder\": {\r\n" + 
						"        \"name\": \"HolderFirstName\",\r\n" + 
						"        \"surname\": \"HolderLastName\"\r\n" + 
						"    },\r\n" + 
						"    \"rooms\": [\r\n" + 
						"        {\r\n" + 
						"            \"rateKey\": \""+ rateKey +"\",\r\n" + 
						"            \"paxes\": [\r\n" + 
						"                {\r\n" + 
						"                    \"roomId\": 1,\r\n" + 
						"                    \"type\": \"AD\",\r\n" + 
						"                    \"name\": \"First Adult Name\",\r\n" + 
						"                    \"surname\": \"Surname\"\r\n" + 
						"                }\r\n" + 
						"                \r\n" + 
						"            ]\r\n" + 
						"        }\r\n" + 
						"    ],\r\n" + 
						"    \"clientReference\": \"IntegrationAgency\",\r\n" + 
						"    \"remark\": \"Booking remarks are to be written here.\",\r\n" + 
						"    \"tolerance\": 2\r\n" + 
						"}")
					.post("bookings");
				
	resp.prettyPrint();
	JsonPath bookingsresp = resp.jsonPath();
	
	 bookingRef = bookingsresp.get("booking.reference");
	
	 
	System.out.println(" Booking Reference : " +bookingRef );
	}
	
	public void deleteBooking()
	{
		Response delresp = RestAssured
			.given()
			.headers(headerVal)
			.log().all()
			.delete("/bookings/"+ bookingRef);

	//delresp.prettyPrint();

	}
	
	}
