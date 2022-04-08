package tests;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class CompleJsonparsing {

	public static void main(String[] args) {
	
		String response = Payload.coursesList();
		
		JsonPath js = new JsonPath(response);
		
		System.out.println("Number of course is: " + js.get("courses.size()"));
		
		System.out.println("Purchase amount is " + js.get("dashboard.purchaseAmount"));

		
		String firstCourseTitle = js.get("courses[0].title");
		System.out.println("First course title is: " + firstCourseTitle);
		
		
		int arrSize = js.getInt("courses.size()");
	/*	
		for(int i = 0; i< arrSize; i++) {
			String title = js.get("courses[" + i + "].title");
			int price = js.getInt("courses[" + i + "].price");
			System.out.println("Title is " + title + "  and price is :  " + price);
		}
		
		*/
		
		
		
		
		for(int i = 0; i< arrSize; i++) {
			String title = js.get("courses[" + i + "].title");
			if(title.equals("Selenium Python")) {
				int copies = js.getInt("courses[" + i + "].copies");
				System.out.println("Title is " + title + "  and Number of copies is :  " + copies);
			}
			
			
		}
	}

}
