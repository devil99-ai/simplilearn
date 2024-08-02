package com.simplilearn.RestAssuredAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Test_PostMethod {
	@Test
	public void test01() {
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "souvik");
		jsonData.put("job", "SSE");
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		RestAssured.given().header("Content-Type","application/json").contentType(ContentType.JSON).body(jsonData.toJSONString()).when().post().then().statusCode(201).log().all();
		//System.out.println(jsonData.toJSONString());
		
		
	}

		

}
