package restassuredvalidation;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Authentications {
	@Test(priority=1)
	public void testBasicAuthentication() {
		given()
		.auth().basic("postman","password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
		
	}
	@Test(priority=2)
	public void testDigestAuthentication() {
		given()
		.auth().digest("postman","password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
		
	}
	@Test(priority=3)
	public void testPreemptiveAuthentication() {
		given()
		.auth().preemptive().basic("postman","password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
		
	}
	@Test(priority=4)
	public void testBearerTokenAuthentication() {  
		String bearerToken = "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";
		given()
		.headers("Authorization","Bearer "+bearerToken)
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.statusCode(200)
		.log().all();
}
}
