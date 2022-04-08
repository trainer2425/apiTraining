package files;

public class Payload {
	
	public static String addPlace() {
		return "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -99.383494,\r\n" + 
				"    \"lng\": 99.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"API Training course\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"J P Nagar, Bangalore\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"REST API\",\r\n" + 
				"    \"POSTMAN\",\r\n" + 
				"    \"REST ASSURED\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://automationtesting.com\",\r\n" + 
				"  \"language\": \"English-IN\"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"";
	}
	
	public static String updatePlace(String placeId) {
		return "{\r\n" + "\"place_id\":\"" + placeId + "\",\r\n" + "\"address\":\"Jayanagar\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n" + "}\r\n" + "";
	}
	
	
	public static String coursesList() {
		return "{\r\n" + 
				"\"dashboard\": {\r\n" + 
				"\"purchaseAmount\": 910,\r\n" + 
				"\"website\": \"rahulshettyacademy.com\"\r\n" + 
				"},\r\n" + 
				"\"courses\": [\r\n" + 
				"{\r\n" + 
				"\"title\": \"Selenium Python\",\r\n" + 
				"\"price\": 50,\r\n" + 
				"\"copies\": 6\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"title\": \"Cypress\",\r\n" + 
				"\"price\": 40,\r\n" + 
				"\"copies\": 4\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"title\": \"RPA\",\r\n" + 
				"\"price\": 45,\r\n" + 
				"\"copies\": 10\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}\r\n" + 
				"";
	}
	
	
	public static String addBook(String name, String isbn) {
		return "{\r\n" + 
				"\"name\":\"" + name + "\",\r\n" + 
				"\"isbn\":\"" + isbn + "\",\r\n" + 
				"\"aisle\":\"227\",\r\n" + 
				"\"author\":\"Sachin\"\r\n" + 
				"}";
	}

}
