package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class VerifyPuchaseAmount {
	@Test
	public void validateJsonvalues() {

		String response = Payload.coursesList();

		JsonPath js = new JsonPath(response);

		int expectedAmount = js.getInt("dashboard.purchaseAmount");

		int arrSize = js.getInt("courses.size()");

		int totalPrice = 0;

		for (int i = 0; i < arrSize; i++) {

			int price = js.getInt("courses[" + i + "].price");

			int copies = js.getInt("courses[" + i + "].copies");

			int product = price * copies;

			totalPrice = totalPrice + product;

		}

		System.out.println("Total Price is " + totalPrice);

		Assert.assertEquals(totalPrice, expectedAmount);

	}
}
