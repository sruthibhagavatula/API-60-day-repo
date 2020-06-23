package uibank;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class LoginToApplication {
	@Test
	public void loginToApplication()
	{
		RestAssured.baseURI="https://uibank-api.azurewebsites.net/api/users/login";
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{\"username\":\"sruthir91\",\"password\":\"sruthi29\"}")
				.post();
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getContentType());
		response.prettyPrint();

}
	
	
}
