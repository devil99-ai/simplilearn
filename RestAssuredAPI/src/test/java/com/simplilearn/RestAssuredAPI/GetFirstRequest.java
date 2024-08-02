package com.simplilearn.RestAssuredAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetFirstRequest {
	@Test
	void tc1() {
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(res.asString());
		System.out.println("Status Code: "+res.statusCode());
		
		
	}

}
