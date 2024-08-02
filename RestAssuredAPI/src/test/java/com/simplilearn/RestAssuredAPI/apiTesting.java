package com.simplilearn.RestAssuredAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class apiTesting {
	
	@Test
	public void test_01() {
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("Response Code "+res.statusCode());
		System.out.println("Response Body "+res.body());
		System.out.println("Response Header "+res.getHeader("Content-Type"));
		System.out.println("Response Time "+res.getTime());
		
		int expectedStatusCode =200;
		int actualStatusCode = res.getStatusCode();
		Assert.assertEquals(actualStatusCode,expectedStatusCode);
	}
	@Test
	public void test_02() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		RestAssured.given().queryParam("page", "2").when().then().statusCode(400);
		
	}

}
