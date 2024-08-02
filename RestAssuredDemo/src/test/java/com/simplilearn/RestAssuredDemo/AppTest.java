package com.simplilearn.RestAssuredDemo;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest {
	@Test
	public void testHttpProtocol() {
		//https://reqres.in/api/users?page=2
		
		String url = "https://reqres.in/api/users?page=2";
		RestAssured.baseURI=url;
		RequestSpecification requestSpecification= RestAssured.given();
		Response response=requestSpecification.accept(ContentType.JSON).get();
//		requestSpecification.accept(ContentType.JSON).post();
		System.out.println(response.asPrettyString());
	}
	@Test
	public void automatePostRequest() {
		String api ="https://reqres.in/api/users";
		String payload = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}\r\n";
		RestAssured.baseURI=api;
		RestAssured.given().body(payload).post().then().log().all();
		
	}
	@Test
	public void validatePostRequest() {
		String api ="https://reqres.in/api/users";
		String payload = "{\r\n"
				+ "    \"name\": \"souvik\",\r\n"
				+ "    \"job\": \"SSE\"\r\n"
				+ "}\r\n";
		RestAssured.baseURI=api;
		RestAssured.given().body(payload).post().then().statusCode(201).log().body();
	}
	@Test
	public void automateGetRequest() {
		String api = "https://demoqa.com/bookstore/v1/books";
		Response res = RestAssured.get(api);
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.prettyPrint());
		
	}
	@Test
	public void validateGetRequest() {
		String api = "https://demoqa.com/bookstore/v1/books";
		Response res =RestAssured.get(api);
		System.out.println("Status code "+res.statusCode());
		System.out.println("headers: "+ res.getHeaders());
		System.out.println("Response: "+res.prettyPrint());
		
		Assert.assertEquals(res.getStatusCode(), 200);
		//validate server
		Assert.assertEquals(res.getHeader("Server"), "nginx/1.17.10 (Ubuntu)"); 
		
	}
}
