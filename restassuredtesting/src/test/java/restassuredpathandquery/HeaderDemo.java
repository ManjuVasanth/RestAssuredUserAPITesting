package restassuredpathandquery;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class HeaderDemo {
	//@Test
	public void testHeaders() {
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1")
		.header("Content-Encoding","gzip")
		.header("Server","gws");
		
	}
	@Test
	public void testGetHeaders() {
		Response res = given().when().get("https://www.google.com/");
		//single header info
		String headerValue = res.getHeader("Content-Type");
		System.out.println("Value ofcontent type is "+headerValue);
		
		Headers allHeaders = res.getHeaders();
		for(Header hd:allHeaders) {
		System.out.println(hd.getName()+ " "+ hd.getValue());
		}
	}
}
