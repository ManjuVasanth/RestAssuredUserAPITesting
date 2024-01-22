package restassuredvalidation;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class SwagLabsAPI{

   // @Test
    public void testAmazonLoginAPI() {
        // Set the base URI for Amazon API
        RestAssured.baseURI = "https://www.saucedemo.com/v1/";

        // Example code for login API
        given()
            .contentType(ContentType.JSON)
            .body("{ \"username\": \"standard_user\", \"password\": \"secret_sauce\" }")
        .when()
            .post("/login")
        .then()
            .statusCode(405) // Replace with the expected status code
            .extract().response();
    }
    

 

        @Test
        public void testLoginApi() {
            // Set base URI
            RestAssured.baseURI = "https://www.saucedemo.com/v1/";

            // Define the request and parameters
            RestAssured.given()
                       .contentType(ContentType.JSON)
                       .param("username", "standard_user")
                       .param("password", "secret_sauce")
                    .when()
                       .post("/login")
                    .then()
                       .statusCode(405)
                       .contentType(ContentType.JSON)
                       .body("status",equalTo("success"));
        }
    }
   