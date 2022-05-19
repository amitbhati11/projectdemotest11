package Restassureddemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;

public class putpatchdeletedata {

	
	@DataProvider(name="putdata")
	
	public Object [][] putdatamehtod(){
		
		return new Object [][] {
			{"sachin","crickt"}
		};
	}
	
	//@Test(dataProvider="putdata")
	public void putdatademo(String name,String job) {
		baseURI="https://reqres.in";
		JSONObject pt=new JSONObject();
		pt.put("name", name);
		pt.put("job",job);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(pt.toJSONString()).when().put("/api/users/2")
		.then().statusCode(200).log().all();
	}
	
	//@Test
	
	public void patchdata() {
		baseURI="https://reqres.in";
		JSONObject pch=new JSONObject();
		pch.put("name", "amitb");
		pch.put("job", "student");
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(pch.toJSONString())
		.when().patch("/api/users/2")
		.then()
		.statusCode(200).log().all();
		
	}
	@Test
	
	public void deletem() {
		baseURI="https://reqres.in";
		given().when().delete("/api/users/2").then().statusCode(204).log().all();
	}
}
