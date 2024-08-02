package com.simplilearn.RestAssuredAPI;

import org.testng.annotations.Test;

//import com.simplilearn.JunitMaven.JSONObject;

import io.restassured.RestAssured;
import org.json.simple.*;
public class Test_PutMethod {
	@Test
	public void PutMethod() {
		JSONObject jsobj = new JSONObject();
		jsobj.put("name", "souvik");
		jsobj.put("job", "SSE");
		
		RestAssured.baseURI="https://reqres.in/api/users/719";
		RestAssured.given().header("content-type","application/json").body(jsobj.toJSONString()).when().put().then().statusCode(200).log().all();
		
		

}
}
