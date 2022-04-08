package tests;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import files.PetPayload;

public class PetAPITesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		String userName = "Rahul";
		
		given().log().all().header("Content-Type", "application/json").body(PetPayload.createUser(userName))
		.when().post("user").then().log().all().assertThat().statusCode(200);
		
		given().log().all().pathParam("username",userName).when().get("user/{username}").then()
		.log().all().assertThat().statusCode(200);

	}

}
