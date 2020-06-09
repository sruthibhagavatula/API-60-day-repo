package bestBuy;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PickUpAvailability {
		
		@Test
		public void getProductRegularAndSellingPrice()
		{
			//step 1: get the URL
			
			String apiKey="qUh3qMK14GdwAs9bO59QRSCJ";
			
			RestAssured.baseURI="https://api.bestbuy.com";
			
			Response response = RestAssured
					.given()
					.contentType(ContentType.XML)
					.get("v1/stores(region=RI)+products(search=iphone 8 plus)?show=name,region,products.inStoreAvailability,products.name,products.description&inStoreAvailability=true&apiKey="+apiKey);
			System.out.println(response.getStatusCode());
			System.out.println(response.getTime());
			System.out.println(response.getContentType());
			response.prettyPrint();
			
			
		}


	}


	
