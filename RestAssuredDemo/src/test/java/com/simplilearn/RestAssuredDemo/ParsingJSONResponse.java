package com.simplilearn.RestAssuredDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ParsingJSONResponse {
	@Test
	public void test() {
		String baseUrl = "https://run.mocky.io/v3";
		String endPoint = "/28306bcc-6212-4378-8d97-4e37b745cd68";
		
		RestAssured.baseURI=baseUrl;
		RequestSpecification requestSpecification = RestAssured.given().accept(ContentType.JSON);
		
		
		Response res = requestSpecification.get(endPoint);
		System.out.println("Response: ");
		System.out.println(res.prettyPrint());
		
		//passing json response
		JsonPath jsonPath = res.jsonPath();
		String name = jsonPath.getString("name");
		String job = jsonPath.getString("job");
		String age = jsonPath.getString("age");
		
		System.out.println(name+"\n"+job+"\n"+age);
		
		Assert.assertTrue(Integer.parseInt(age)<222);
	}

}
