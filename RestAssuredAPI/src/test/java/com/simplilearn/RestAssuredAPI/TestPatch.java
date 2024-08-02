package com.simplilearn.RestAssuredAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestPatch {
	@Test
	public void test() {
		JSONObject jsb = new JSONObject();
		jsb.put("name", "souvik");
		jsb.put("job", "SDET");
		
		RestAssured.baseURI = "https://reqres.in/api/users/719";
		RestAssured.given().header("content-type","application/hjson").contentType(ContentType.JSON)
		.body(jsb.toJSONString()).when().patch().then().statusCode(200).log().all();
	}

}
