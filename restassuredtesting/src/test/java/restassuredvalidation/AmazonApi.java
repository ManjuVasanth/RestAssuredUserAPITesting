package restassuredvalidation;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class AmazonApi {
	@Test
   public  void searchTest(){
	        // Set the base URI for Amazon's API
	        RestAssured.baseURI = "https://www.amazon.com/";

	        // Perform a search for iPhone 13
	        Response response = RestAssured.given()
	                .queryParam("twotabsearchtextbox", "iPhone 13")
	                .get("/search");

	        // Print the response body
	        String responseBody = response.getBody().asString();
	        System.out.println("Response Body: " + responseBody);

	        // You can add assertions here based on your test requirements
	        // For example, you might want to check if the response contains relevant information about iPhone 13

	        // Print the response status code
	        int statusCode = response.getStatusCode();
	        System.out.println("Status Code: " + statusCode);
	    }
	}



