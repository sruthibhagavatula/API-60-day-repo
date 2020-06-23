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

public class ApplyLoan {
	public Headers hMap;
	@Test
	public void applyLoan()
	{
		RestAssured.baseURI="https://uibank-api.azurewebsites.net/api/quotes/newquote";
		
		Response resp = RestAssured
				.given()
				.body("{\"email\":\"rajeshreddy.vemi320@gmail.com\",\"amount\":100000,\"term\":5,\"income\":1,\"age\":29}")
				.contentType(ContentType.JSON)
				.post();
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getTime());
		System.out.println(resp.getContentType());
		resp.prettyPrint();

}
	
	
}
