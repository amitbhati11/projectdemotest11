package Restassureddemo;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class Restassurddemodata {
	
	@DataProvider(name="testdatap")
	public Object [][] postdataprovide() {
		
		return new Object [][] {
			{"parvinder","dev"},{"tulip","tester"},{"abcd","trt"}
		};
	}
	
	//@Test(dataProvider="testdatap")
	public void postdatam(String name,String job) {
		baseURI="https://reqres.in";
		JSONObject rw=new JSONObject();
		rw.put("name",name);
		rw.put("job", job);
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(rw.toJSONString())
		.when().post("/api/users").then().statusCode(201).log().all();
	}
	@Test
	
	public void getmethodd() {
		baseURI="https://reqres.in";
		given().when().get("/api/users?page=2").then().statusCode(200).log().all();
	}

}
