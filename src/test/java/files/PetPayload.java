package files;

public class PetPayload {
	
	public static String createUser(String userName) {
		return "{\r\n" + 
				"  \"id\": 0,\r\n" + 
				"  \"username\": \"" + userName + "\",\r\n" + 
				"  \"firstName\": \"Sachin\",\r\n" + 
				"  \"lastName\": \"K S\",\r\n" + 
				"  \"email\": \"test123@gmail.com\",\r\n" + 
				"  \"password\": \"test123\",\r\n" + 
				"  \"phone\": \"9876543210\",\r\n" + 
				"  \"userStatus\": 0\r\n" + 
				"}";
	}

}
