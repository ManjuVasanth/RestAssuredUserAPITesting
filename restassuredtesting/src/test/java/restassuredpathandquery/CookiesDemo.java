package restassuredpathandquery;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
public class CookiesDemo {
	//@Test
	public void testCookies() {
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.cookie("AEC","Ae3NU9OAXp_gj1pUycuRNrkUm1qoIsWo_laLxDaIomBrWOc48e8mmnTMdD8")
		.log().all();
		
	}
	@Test
	public void getCookiesInfo() {
		Response res = given().when().get("https://www.google.com/");
		String cookieValue = res.getCookie("AEC");
		
		System.out.println("Value of single cookie:" +cookieValue);
		Map<String,String> allCookieValues = res.getCookies();
		System.out.println(allCookieValues.keySet());
		for (String keys : allCookieValues.keySet()) {
			String cookiesValue = res.getCookie(keys);
			System.out.println("keys" +":"+cookiesValue);
		}
		}
	}

