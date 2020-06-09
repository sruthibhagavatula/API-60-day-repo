package bestBuy;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Range {
		
		@Test
		public void getProductsWithInRange()
		{
			//step 1: get the URL
			
			String apiKey="qUh3qMK14GdwAs9bO59QRSCJ";
			//https://api.bestbuy.com/
			RestAssured.baseURI="https://api.bestbuy.com";
			Response response = RestAssured
					.given()
					.contentType(ContentType.XML)
					.get("v1/products(manufacturer=canon&(salePrice>=1000&salePrice<=1500))?format=json&apiKey="+apiKey);
			System.out.println(response.getStatusCode());
			System.out.println(response.getTime());
			System.out.println(response.getContentType());
			response.prettyPrint();
			
			
		}


	}


	
