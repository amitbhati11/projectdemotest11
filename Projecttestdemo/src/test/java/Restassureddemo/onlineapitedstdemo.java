package Restassureddemo;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class onlineapitedstdemo {
	
	String tokn="f9531e874a767f41890cf5ad8548892812722fc1e0ed8c4efbe2e02891095e8c";
	@Test//get
	public void gettestdemo() {
		baseURI="https://gorest.co.in";
		
		given().when().get("/public/v2/users").then().statusCode(200).log().all();
	}
	
	//@Test//post
	
	public void posttestdemo() {
		baseURI="https://gorest.co.in";
		JSONObject pt=new JSONObject();
		
		pt.put("name", "blog");
		pt.put("email", "abdc@mail.com");
		pt.put("gender", "female");
		pt.put("status", "inactive");
		
		given().auth().oauth2(tokn)
		.contentType(ContentType.JSON).accept(ContentType.JSON).body(pt.toJSONString()).when().post("/public/v2/users")
		.then().statusCode(201).log().all();
	}

//@Test//delete

public void deletemdata() {
	
	baseURI="https://gorest.co.in";
	
	
	given().auth().oauth2(tokn).when().delete("/public/v2/users/2627").then().statusCode(204).log().all();
	
	
}
}
