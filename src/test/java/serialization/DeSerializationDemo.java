package serialization;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import pojo.GetPlace;

import static io.restassured.RestAssured.*;

public class DeSerializationDemo {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		GetPlace place = given().queryParam("key", "qaclick123")
		.queryParam("place_id", "a9e2d94f901405d5b36f184c172ea5ed").expect().defaultParser(Parser.JSON)
		.when().get("/maps/api/place/get/json").then().extract().response().as(GetPlace.class);
		
		System.out.println(place.getName());
		
		System.out.println(place.getTypes());

	}

}
