package paypal;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParser;

import io.cucumber.core.gherkin.vintage.internal.gherkin.deps.com.google.gson.JsonElement;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.support.FileReader;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostProductCreation {


	@DataProvider(name="DP")
	public String[] getFiles()
	{
		String[] data=new String[1];
		data[0]="./data3.json";

		return data;
	}
	
	
	
	@Test(dataProvider="DP")
	public void CreateMultipleProducts(String filename)
	{

		RestAssured.baseURI="https://api.sandbox.paypal.com/v1/catalogs/products";
		
		


		File filesrc = new File(filename);

		Response response = RestAssured
				.given()
				.header("Authorization","Bearer A21AAH_aWgdldIF484sQHjjnGqZlTcu7e81OmZtzWBTfBhMyWK6GPBkjs2AR7zKzrJm3DSeAQJQKeqMZSA3jdfg7sCrkGlxhQ")
				.contentType(ContentType.JSON)
				.body(filesrc)
				.post();
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getContentType());

		JsonPath response1= response.jsonPath();
		response1.prettyPrint();
		String respid= response1.get("id");

		System.out.println(respid);


		RestAssured.baseURI="https://api.sandbox.paypal.com/v1/catalogs/products/"+respid;
		System.out.println(RestAssured.baseURI);
		Response getResponse = RestAssured
				.given()
				.header("Authorization","Bearer A21AAER58iRlM4W4gRNpiYIc3cZ0I2MTOuUavyPiyBKhtiOcLn90fenIZG4QPiLy5sB0qDViQSFjTz9HMPzWbiBhYltTFNB6A")
				.accept(ContentType.JSON)
				.get();
		System.out.println(getResponse.getStatusCode());
		System.out.println(getResponse.getTime());
		JsonPath getresponse1= getResponse.jsonPath();
		System.out.println("Type "+ getresponse1.get("type"));
		System.out.println("Category "+ getresponse1.get("category"));

	}

}


