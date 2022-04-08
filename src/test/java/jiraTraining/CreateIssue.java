package jiraTraining;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

import static io.restassured.RestAssured.*;

import java.io.File;

import files.JiraPayload;

public class CreateIssue {
	
	
	public static void main(String[] args) {
		
		RestAssured.baseURI = "http://localhost:8080";
		
		SessionFilter session = new SessionFilter();
		
		
		// Login
		 given().log().all().headers("Content-Type","application/json")
		 .filter(session)
		.body("{\r\n" + 
				"    \"username\": \"sachinks094\",\r\n" + 
				"    \"password\": \"Jira@1234\"\r\n" + 
				"}")
		.when().post("rest/auth/1/session")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		
		
		// Create Issue
	/*	given().log().all().headers("Content-Type","application/json")
		.filter(session)
		.body(JiraPayload.createIssue("Defect created through automation"))
		.when().post("rest/api/2/issue")
		.then().log().all().assertThat().statusCode(201);
		
		*/
		
		
		// Issue id to be used - 10004
		 
		 given().log().all().headers("Content-Type","application/json")
		 .filter(session)
		 .pathParam("issueId", "10004")
		 .body(JiraPayload.addComment("My last comment"))
		 .when().post("/rest/api/2/issue/{issueId}/comment")
		 .then().log().all().assertThat().statusCode(201);
		 
		 // Get the issue details
		 
		 System.out.println("#######################################################");
		 given().log().all()
		 .filter(session)
		 .pathParam("issueId", "10004")
		 .queryParam("fields", "comment")
		 .when().get("/rest/api/2/issue/{issueId}")
		 .then().assertThat().log().all().statusCode(200);
		 
		 
		 // Add attachment
		 
		 given().log().all()
		 .filter(session)
		 .pathParam("issueId", "10004")
		 .header("X-Atlassian-Token","no-check")
		 .header("Content-Type","multipart/form-data")
		 .multiPart("file",new File("uploadFile.txt"))
		 .when().post("/rest/api/2/issue/{issueId}/attachments").then().assertThat().statusCode(200);
		 
	/*	 given().log().all().pathParam("issueId", "10004").header("X-Atlassian-Token","no-check").filter(session)
			.header("Content-Type","multipart/form-data")
			.multiPart("file",new File("uploadFile.txt"))
			.when().post("/rest/api/2/issue/{issueId}/attachments");
			
			*/
	}

}
