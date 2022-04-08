package files;

public class JiraPayload {
	
	public static String createIssue(String summary) {
		return " {\r\n" + 
				"     \"fields\": {\r\n" + 
				"        \"project\": {\r\n" + 
				"            \"key\": \"RSA\"\r\n" + 
				"        },\r\n" + 
				"        \"summary\": \"" + summary + "\",\r\n" + 
				"        \"description\": \"description\",\r\n" + 
				"\r\n" + 
				"         \"issuetype\": {\r\n" + 
				"            \"name\": \"Bug\"\r\n" + 
				"        }\r\n" + 
				"\r\n" + 
				" }\r\n" + 
				" }";
	}
	
	public static String addComment(String comment) {
		return "{\r\n" + 
				"    \"body\": \"" + comment + "\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}";
	}

}
