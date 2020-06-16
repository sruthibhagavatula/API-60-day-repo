package aPItudeHotels;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class KeyGeneration {

	    public static String apiKey;
		public static String secret;
		public static String xsignature;
		public static Map<String,Object>headerVal=new HashMap<String, Object>();
		public static Object rateKey;
		public static String bookingReferenceNo;
		
		@BeforeSuite
		public void baseSetup()	
		{
			

			RestAssured.baseURI="https://api.test.hotelbeds.com/hotel-api/1.0/";
			
			apiKey = "4zx3ce3e55vyxngeaqefpkga";
			secret = "z2bFHZGuEE";
			
			 xsignature = org.apache.commons.codec.digest.DigestUtils
									 .sha256Hex(apiKey + secret + System.currentTimeMillis() / 1000);
			
			System.out.println(xsignature);
			headerVal.put("Api-Key", apiKey);
			headerVal.put("X-Signature", xsignature);
			headerVal.put("Accept", "application/json");
			headerVal.put("Accept-Encoding", "gzip");
			headerVal.put("Content-Type", "application/json");
		

		}

	}


