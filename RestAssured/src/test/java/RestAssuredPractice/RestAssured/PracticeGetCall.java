package RestAssuredPractice.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PracticeGetCall {
	
	@Test
	public void getCall(){
		
		RestAssured.baseURI="https://maps.googleapis.com";
		
		given()
		  .param("location", "-33.8670522,151.1957362").param("radius", "1500")
		  .param("key", "AIzaSyDrKzPhMA3tCU9IK7vCNl95sQzXYtqWrlE")
	    .when()
	      .get("/maps/api/place/nearbysearch/json")
	    .then()
	      .assertThat()
	      .statusCode(200).and().contentType(ContentType.JSON).and().body("results[0].name",equalTo("Sydney"));
		
	}

}
