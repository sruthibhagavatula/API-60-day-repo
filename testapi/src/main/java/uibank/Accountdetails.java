package uibank;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Accountdetails {
	public Headers hMap;
	@Test
	public void accountDetails()
	{
		RestAssured.baseURI="https://uibank-api.azurewebsites.net/api/accounts";
		List<Header> hList = new ArrayList<Header>();
		hList.add(new Header("Authorization","mIEw1peH5fUlNJqTctNppaRWZeYeRSjNc5QiHj9ntAfYFB4PhL6iwVwZ7Dy0vyHo"));
		hMap = new Headers(hList);
		Map<String, String> params = new HashMap<String, String>();
		params.put("filter[where][userId]", "5ef08b67e29f950044ba311b");
		Response resp = RestAssured
				.given()
				.headers(hMap)
				.params(params)
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
