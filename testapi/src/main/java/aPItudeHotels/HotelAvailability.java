package aPItudeHotels;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class HotelAvailability extends KeyGeneration {
	public static String hotelName;
	public static String rateKeystr;
	List<Map<Object, Object>> rates;	
	
	@Test
	public void getHotelAvailability()
	{
		File hotel = new File("./data2.json");
		Response resp = RestAssured
				.given().log().all()
				.headers(headerVal)
				.when()
				.body(hotel)
				.post("hotels");
		JsonPath jsonPath = resp.jsonPath();
		List<Map<Object, Object>> hotellist = jsonPath.getList("hotels.hotels");
		System.out.println("hotellist" +hotellist.size());
		for (int hlist = 0; hlist < hotellist.size(); hlist++) {
			
			List<Map<Object, Object>> rooms = jsonPath.getList("hotels.hotels[" + hlist + "].rooms");
		
			for (int rmlist = 0; rmlist < rooms.size(); rmlist++) {
				rates = jsonPath.getList("hotels.hotels[" +hlist+ "].rooms[" +rmlist+ "].rates");
				System.out.println("rates are"+rates);
				for (int rlist = 0; rlist < rates.size(); rlist++) {
					if (rates.get(rlist).get("net") != null)
					{
						System.out.println("HotelName is" + hotellist.get(hlist).get("name").toString());
						System.out.println("Room Availability" + rooms.get(rmlist).get("name"));
						System.out.println("Room Net Rate is" + rates.get(rlist).get("net"));
						System.out.println("Room rate type" + rates.get(rlist).get("rateType"));
						
					}
				}
			}
			System.out.println("ratekey"+ rateKey);
			for(Map<Object, Object>  findRateKey:rates)
			{
				if(findRateKey.get("rateType").toString().equalsIgnoreCase("BOOKABLE"))
				{
					rateKey=findRateKey.get("rateKey");
					rateKeystr = rateKey.toString();
					System.out.println("Ratekeys is"+rateKey);
					break;
				
			}
			}
		}
	}

}

