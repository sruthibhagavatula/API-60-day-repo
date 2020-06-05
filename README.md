# API-60-day-repo
EndPoint : https://covid-19.dataflowkit.com/v1


Documentation: https://documenter.getpostman.com/view/11203393/SzfAz776?version=latest

Authorization -> No Auth

1. Find the top 5 Country with Highest New Cases 
2. Find the top 5 Country with lowest New Deaths Cases for recent day
3. Find the Statu of your Country - done
4. Verify the response HTTP status code = 200
5. Verify the Response Time < 600 ms
6. verify the Content Type = json

Implement the above Scenario On both PostMan and Rest Assured (no framework only plain Rest Assured)


#2) Paypal

Manual Steps:

1) Manually Create your own Credentials: https://developer.paypal.com/home/
2) Read the API documents from here:
	https://developer.paypal.com/docs/api/overview/
3) Create Token Manually

Automation Steps:

#1) Create a new product with hard coded value in the body [PostMan]
	a) Verify the status code
	b) Verify the response contains category and type as expected

#2) Create multiple products [using dataprovider + RestAssured + TestNG]

#3) Verify that the created products are listed
