package Restassureddemo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
public class localpostngetmethoddemo {
	//@Test//post
	
	public void postdemo() {
		baseURI="http://localhost:3000";
		JSONObject pst=new JSONObject();
		
		pst.put("F_name", "baby");
		pst.put("L_Name", "bhati");
		pst.put("SubID", 2);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(pst.toJSONString())
		.when().post("/users").then().statusCode(201).log().all();
		
	}
	
	@Test//get
	
	public void getmethddemo() {
		baseURI="http://localhost:3000";
		given().when().get("/users/40").then().statusCode(200).log().all();
	}
	
	//@Test//put
	
	public void putmethoddemo() {
		baseURI="http://localhost:3000";
		JSONObject pt=new JSONObject();
		pt.put("F_name", "Sahrlin");
		pt.put("L_Name","Devi");
		pt.put("SubID",1);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(pt.toJSONString()).when()
		.put("/users/52")
		.then().statusCode(200)
		.log()
		.all();
	}
	
	//@Test//patch
	
	public void patchmethoddemo() {
		baseURI="http://localhost:3000";
		JSONObject pch=new JSONObject();
		
		pch.put("F_name","Sharlin");
		pch.put("L_Name","bahti");
		pch.put("SubID", 1);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(pch.toJSONString()).when()
		.patch("/users/52").then().statusCode(200).log().all();
	}
	
//	@Test
	
	public void deletemdemo() {
		baseURI="http://localhost:3000";
		
		given().when().delete("/users/40").then().statusCode(200).log().all();
		
		
	}

}
