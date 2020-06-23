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

public class AccountCreation {
	public Headers hMap;
	@Test
	public void createAccount()
	{
		RestAssured.baseURI="https://uibank-api.azurewebsites.net/api/accounts";
		List<Header> hList = new ArrayList<Header>();
		hList.add(new Header("Authorization","mIEw1peH5fUlNJqTctNppaRWZeYeRSjNc5QiHj9ntAfYFB4PhL6iwVwZ7Dy0vyHo"));
		hMap = new Headers(hList);
		Response resp = RestAssured
				.given()
				.headers(hMap)
				.log()
				.all()
				.contentType(ContentType.JSON)
				.get();
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getTime());
		System.out.println(resp.getContentType());
		resp.prettyPrint();

}
	
	
}
