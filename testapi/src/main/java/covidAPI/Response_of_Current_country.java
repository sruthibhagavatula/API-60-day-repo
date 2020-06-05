package covidAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Response_of_Current_country {
	
	@Test
	public void getResponseBaseOnCountry()
	{
		//step 1: get the URL
		
		RestAssured.baseURI="https://covid-19.dataflowkit.com/v1/";
				
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.get("India");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getContentType());
		response.prettyPrint();
		
		
	}


}
