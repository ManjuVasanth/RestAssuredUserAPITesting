package restassuredvalidation;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import restassuredtesting.restassuredtesting.Pojo_PostRequest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class DiffWaysToCreatePostRequests {

	/*
	 * Ways to create Post Request body requests 1. using HashMap 2.using org.json
	 * 3. using POJO 4. external json file data
	 */
	//create Post Request body requests using HashMap
	//@Test(priority = 1)
	public void postTestUsingHashMap() {
		HashMap<String, Object> data = new HashMap<>();
		data.put("name", "Sui");
		data.put("phone", "2345354209");

		String courseArr[] = { "Java", "C" };
		data.put("courses", courseArr);

		given().contentType("application/json").body(data).when().post("http://localhost:3000/students").then()
				.statusCode(201).body("name", equalTo("Sui")).body("phone", equalTo("2345354209"))
				.body("courses[0]", equalTo("Java")).body("courses[1]", equalTo("C"))
				.header("Content-Type", "application/json; charset=utf-8").log().all();
	}

	//@Test(priority = 2, dependsOnMethods = { "postTestUsingHashMap" })
	public void deleteStudentRecord() {
		given().when().delete("http://localhost:3000/students/6").then().statusCode(200);

	}
	//create Post Request body requests using org.json library

	// @Test(priority = 1)
	public void postTestUsingorgJson() throws JSONException {
		
		JSONObject data = new JSONObject();

		data.put("name","Sui");
		data.put("phone","2345354290");

		String courseArr[] = { "Java","C" };
		data.put("courses", courseArr);

		given().contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name", equalTo("Sui"))
			.body("phone", equalTo("2345354290"))
		.body("courses[0]", equalTo("Java")).body("courses[1]", equalTo("C"))
				.header("Content-Type", "application/json; charset=utf-8").log().all();

	}

	// @Test(priority = 2, dependsOnMethods = {"postTestUsingorgJson"})
	public void deleteStudentRecord1() {
		given().when().delete("http://localhost:3000/students/6").then().statusCode(200);

	}
	//create Post Request body requests using POJO class
	
	 @Test(priority = 1)
		public void postTestUsingPojo() {
		 Pojo_PostRequest data = new Pojo_PostRequest();
		 data.setName("Sui");
		 data.setPhone("2345354290");
		 String courseArr[] = { "Java","C" };
		 data.setCourses(courseArr);
		 given().contentType("application/json").body(data).when().post("http://localhost:3000/students").then()
			.statusCode(201).body("name", equalTo("Sui")).body("phone", equalTo("2345354290"))
			.body("courses[0]", equalTo("Java")).body("courses[1]", equalTo("C"))
			.header("Content-Type", "application/json; charset=utf-8").log().all();
		 
		 
}
	 //@Test(priority = 2, dependsOnMethods = {"postTestUsingorgJson"})
		public void deleteStudentRecord2() {
			given().when().delete("http://localhost:3000/students/6").then().statusCode(200);

		}
		//create Post Request body requests using external json file data
		@Test(priority = 1)
		public void postTestUsingJsonFile() throws FileNotFoundException {
			File file = new File(".\\body.json");//to open the file
			// read the data from the file we have to use FileReader
			FileReader fileReader = new FileReader(file);
			// inorder to get Json format of data using JSONTokener
			 JSONTokener tokener = new  JSONTokener(fileReader);
			 //  inorder to get JSONObject
			 JSONObject data = new JSONObject(tokener);
			
			 given().contentType("application/json").body(data.toString()).when().post("http://localhost:3000/students").then()
				.statusCode(201).body("name", equalTo("Sui")).body("phone", equalTo("2345354290"))
				.body("courses[0]", equalTo("Java")).body("courses[1]", equalTo("C"))
				.header("Content-Type", "application/json; charset=utf-8").log().all();
		}
		 @Test(priority = 2, dependsOnMethods = {"postTestUsingJsonFile"})
		public void deleteStudentRecord3() {
			given().when().delete("http://localhost:3000/students/6").then().statusCode(200);

		}
}
