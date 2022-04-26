package serialization;

import io.restassured.RestAssured;
import pojo.AddPlace;
import pojo.Location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class SerializationDemo {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setName("Sachin");
		p.setPhone_number("9877765766");
		p.setAddress("JP Nagar");
		p.setWebsite("http://google.com");
		p.setLanguage("English-IN");
		
		List<String> myList = new ArrayList<String>();
		myList.add("POSTMAN");
		myList.add("REST API");
		myList.add("GitHub");
		
		p.setTypes(myList);
		
		Location loc = new Location();
		loc.setLat(90.18);
		loc.setLng(90.987);
		
		p.setLocation(loc);
		
		given().queryParam("key", "qaclick123").log().all()
		.body(p)
		.when()
		.post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200);
	}

}
