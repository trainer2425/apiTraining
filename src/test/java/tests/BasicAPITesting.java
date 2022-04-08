package tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.Payload;

public class BasicAPITesting {

	public static void main(String[] args) {

		// given() -> parameters (Query/Path), request body, headers
		// when() -> HTTP Method, resource
		// then() -> Validation of response

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.addPlace()).when().post("maps/api/place/add/json").then().log().all().assertThat()
				.statusCode(200).extract().response().asString();

		JsonPath js = new JsonPath(response);

		String placeId = js.get("place_id");
		System.out.println("############ PLACE ID ADDED IS##########" + placeId);

		String response2 = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(Payload.updatePlace(placeId)).when()
				.put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200).extract().response()
				.asString();

		JsonPath js2 = new JsonPath(response2);

		System.out.println("####### ADDRESS UPDATED MSG#####" + js2.get("msg"));

		String response3 = given().queryParam("key", "qaclick123").queryParam("place_id", placeId).when()
				.get("/maps/api/place/get/json").then().log().all().assertThat().statusCode(200)
				.body("address", equalTo("Jayanagar")).extract().response().asString();

		JsonPath js3 = new JsonPath(response3);

		Assert.assertEquals(js3.get("address"), "Jayanagar");
		System.out.println("End to End validation is completed");

		System.out.println(js3.get("location.latitude"));

	}

}
