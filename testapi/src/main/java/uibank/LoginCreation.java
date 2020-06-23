package uibank;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginCreation {
	
	
	
	@Test
	public void createLogin()
	{
		RestAssured.baseURI="https://uibank-api.azurewebsites.net/api/users/";
		File filesrc = new File("./data1.json");
		System.out.println(filesrc);
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(filesrc)
				.post();
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getContentType());
		response.prettyPrint();

}
}
