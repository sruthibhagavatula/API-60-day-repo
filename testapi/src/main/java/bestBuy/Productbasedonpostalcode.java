package bestBuy;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Productbasedonpostalcode {
		
		@Test
		public void getProductBasedOnPostalCode()
		{
			//step 1: get the URL
			
			String apiKey="qUh3qMK14GdwAs9bO59QRSCJ";
			
			RestAssured.baseURI="https://api.bestbuy.com";
			Response response = RestAssured
					.given()
					.contentType(ContentType.XML)
					.get("v1/stores(area(02864,50))+products(manufacturer=canon&salePrice<1000)?show=storeId,name,products.sku,products.name&apiKey="+apiKey);
			System.out.println(response.getStatusCode());
			System.out.println(response.getTime());
			System.out.println(response.getContentType());
			response.prettyPrint();
			
			
		}


	}


	
