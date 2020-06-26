package tomtom;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RegisterKey {
	
	public static String apikey = "0y5PMY89VWePGkAD4nNhciABGCDRBYGF";
	public static String adminkey;
	public static String projid;
	public static String fenceid;
	 
	//registerkey
	@Test
	public void registerKey()
	{
		String uri="https://api.tomtom.com/geofencing/1/register?key="+apikey ;
		System.out.println(uri);
		RestAssured.baseURI="https://api.tomtom.com/geofencing/1/register?key="+
		apikey ;
		Response response = RestAssured 
				.given() 
				.log() 
				.all()
				.queryParam("key", apikey) 
				.contentType(ContentType.JSON) 
				.body("{\r\n" +
						"  \"secret\": \"My new secret key\"\r\n" + "}") 
				.post();
		JsonPath jpath =
		response.jsonPath(); jpath.prettyPrint();
		this.adminkey=jpath.getString("adminKey"); 
		System.out.println(adminkey);
		
		
		//add new project
		RestAssured.baseURI="https://api.tomtom.com/geofencing/1/projects/project?key="+apikey+"&adminKey=" +adminkey;
		Response projresp = RestAssured
				.given()
				.log()
				.all()
				.queryParam("key", apikey)
				.queryParam("adminKey", adminkey)
				.contentType(ContentType.JSON)
				.body("{\r\n" + 
						"  \"name\": \"projects near my area\"\r\n" + 
						"}")
				.post();
		 		JsonPath proj =projresp.jsonPath();
		 		proj.prettyPrint();
				this.projid=proj.getString("id"); 
				System.out.println(projid);
		
		//listprojects
		RestAssured.baseURI="https://api.tomtom.com/geofencing/1/projects?key="+apikey;
		Response projlist = RestAssured
				.given()
				.get();
		 		projlist.prettyPrint();

		 		
		 		//regeneratekey
		RestAssured.baseURI="https://api.tomtom.com/geofencing/1/regenerateKey?key="+apikey ;
		Response genkey = RestAssured 
				.given() 
				.log() 
				.all()
				.queryParam("key", apikey) 
				.contentType(ContentType.JSON) 
				.body("{\r\n" +
						"  \"secret\": \"My new secret key\"\r\n" + "}") 
				.post();
		JsonPath genpath =
		genkey.jsonPath(); genpath.prettyPrint();
		this.adminkey=genpath.getString("adminKey"); 
		System.out.println(adminkey);
		
		//addfence
		RestAssured.baseURI="https://api.tomtom.com/geofencing/1/projects/"+projid+"/fence?key="+apikey+"&adminKey="+adminkey ;
		Response addfence = RestAssured 
				.given() 
				.log() 
				.all()
				.queryParam("key", apikey)
				.queryParam("adminKey", adminkey) 
				.queryParam("projid", projid) 
				.contentType(ContentType.JSON) 
				.body("{\r\n" + 
						"  \"name\": \"No-fly zone 23\",\r\n" + 
						"  \"type\": \"Feature\",\r\n" + 
						"  \"geometry\": {\r\n" + 
						"    \"radius\": 75,\r\n" + 
						"    \"type\": \"Point\",\r\n" + 
						"    \"shapeType\": \"Circle\",\r\n" + 
						"    \"coordinates\": [-67.137343, 45.137451]\r\n" + 
						"  },\r\n" + 
						"  \"properties\": {\r\n" + 
						"    \"maxSpeedKmh\": 70\r\n" + 
						"  }\r\n" + 
						"}") 
				.post();
		JsonPath fencepath =
		addfence.jsonPath(); 
		fencepath.prettyPrint();
		this.fenceid=fencepath.getString("id"); 
		System.out.println(fenceid);
		
		
		//getfencedetails
		
		RestAssured.baseURI="https://api.tomtom.com/geofencing/1/fences/"+fenceid+"?key="+apikey;
		Response fencedetails = RestAssured 
				.given() 
				.log() 
				.all()
				.queryParam("key", apikey) 
				.queryParam("fenceid", fenceid) 
				.get();
		JsonPath fencedetailspath =fencedetails.jsonPath();
		fencedetailspath.prettyPrint();
		}

}
