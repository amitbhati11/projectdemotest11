package Restassureddemo;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

//putmethod

public class Onlineputpatch {
	
	String actoken="6784c78babff7493d95093827b438f08a98d4ded6e0383f182301a0be3de0e6f";
	@Test
	public void putmethdemo() {
		baseURI="https://gorest.co.in/";
		
		JSONObject rq=new JSONObject();
		rq.put("name","Swaraika Ganaka");
		rq.put("email","swara_ganaka@schmitt-goyette.com");
		rq.put("gender","female");
		rq.put("status","active");
		
		given().auth().oauth2(actoken).accept(ContentType.JSON).accept(ContentType.JSON).body(rq.toJSONString())
		.when().put("/public/v2/users/4822").then().statusCode(200)
		.log().all();
		
	}
	//patchmethod
	//@Test
	public void patchmethoddemo() {
		
		baseURI="https://gorest.co.in/";
		JSONObject pach=new JSONObject();
		
		pach.put("name","balwinder");
		pach.put("email","rakc@mail.com");
		pach.put("gender","male");
		pach.put("status","active");
		
		given().auth().oauth2(actoken).contentType(ContentType.JSON).accept(ContentType.JSON).body(pach.toJSONString())
		.when().patch("/public/v2/users/4822")
		.then().statusCode(200).log().all();
	}
	
	

}
