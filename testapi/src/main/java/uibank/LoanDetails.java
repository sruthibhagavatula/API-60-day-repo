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

public class LoanDetails {
	public Headers hMap;
	@Test
	public void loanDetails()
	{
		String loanid="5ef08cece29f950044ba3125";
		RestAssured.baseURI="https://uibank-api.azurewebsites.net/api/quotes/" + loanid;
		
		Response resp = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.get();
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getTime());
		System.out.println(resp.getContentType());
		resp.prettyPrint();

}
	
	
}
