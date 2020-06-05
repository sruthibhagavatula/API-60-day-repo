package covidAPI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.testng.annotations.Test;

import io.cucumber.core.gherkin.vintage.internal.gherkin.deps.com.google.gson.JsonArray;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Top5CountriesWithHighestNewCases {
	
	@Test
	public void Top5CountriesWithHighestNewCases() throws ParseException
	{
		//step 1: get the URL
		
		RestAssured.baseURI="https://covid-19.dataflowkit.com/v1";
				
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.get();
		
		JsonPath getresponse1= response.jsonPath();
		List<String> countrylist= getresponse1.getList("Country_text");
		List<String> lastupdatedlist= getresponse1.getList("'Last Update'");
		List<String> newcaseslist= getresponse1.getList("'New Cases_text'");
		
		System.out.println(lastupdatedlist);
		System.out.println(countrylist);
		int countrycount = countrylist.size();
		System.out.println("Total country count is " +countrycount);
		int countrieswithNewCasesInRecentDay = 0;
		long currenttime= new Date().getTime();
		long last24hrs = (24*60*60*1000);
		long differtime = currenttime - last24hrs;
		System.out.println(differtime);
		String[] countrieswithNewCasesArray ;
		System.out.println("before for loop");
		Map<Integer, String> countryMap = new TreeMap<Integer, String>(Collections.reverseOrder());
		for(int i = 0; i < lastupdatedlist.size(); i++)
		{
			String innerArray[];
			String country = countrylist.get(i);
			//System.out.println(country);
			String LastUpdated = lastupdatedlist.get(i);
			//System.out.println(LastUpdated);
			//long lastupdatedMS = LastUpdated.get(i);
			String myDate = LastUpdated;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddHHmm");
			if(myDate != null && myDate != "") {
				Date date = sdf.parse(myDate);
				long updatedtimeinMS = date.getTime();
				String newcases= newcaseslist.get(i); 
				if(updatedtimeinMS > differtime && newcases != "" && newcases != null  )
				{
					Integer newCasesNum =Integer.valueOf(newcases.replace("+", "").replace(",", ""));
					countryMap.put(newCasesNum, countrylist.get(i));

					
				}
		}
		}
		int top5 = 0;
        for (Map.Entry<Integer,String> entry : countryMap.entrySet()) {  
            if(entry.getValue() != "World" && top5 < 7) {
            	System.out.println(entry.getValue()+" with new cases :"+entry.getKey());
            	top5++;
            } 
		}
		System.out.println("Expected status code : 200 and actual :"+response.getStatusCode());
		
		//step 6 : verify response time < 600
		System.out.println("Expected response time < 600 and actual :"+response.getTime());
		
		//step 7 : verify content type : JSON

System.out.println("Expected content type < JSON and actual :"+response.contentType());
	}
}
					
	