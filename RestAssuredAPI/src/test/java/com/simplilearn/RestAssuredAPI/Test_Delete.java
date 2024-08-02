package com.simplilearn.RestAssuredAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Test_Delete {
	@Test
	public void Test() {
		RestAssured.baseURI = "https://reqres.in/api/users/719";
		RestAssured.given().when().delete().then().statusCode(204).log().all();
	}
	@Test
	public void GetSingleUser() {
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		RequestSpecification reqspec = RestAssured.given();
		Response res = reqspec.get();
		int statusCode = res.getStatusCode();
		String statusLine = res.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK","Status Line Matched");

	}
	@Test
	public void GetSingleUserUsingValidatableResponse() {
		RestAssured.baseURI="https://reqres.in/api/users/2";
		
		RequestSpecification reqsp = RestAssured.given();
		Response res = reqsp.get();
		
		ValidatableResponse vap = res.then();
		
		vap.statusCode(200);
		vap.statusLine("HTTP/1.1 200 OK");
	}
	@Test
	public void GetSingleUser_BDD() {
		
	}
	@Test
	public void basicAuth() {
		RequestSpecification reqspec = RestAssured.given();
		reqspec.baseUri("http://postman-echo.com");
		reqspec.basePath("/basic-auth");
		
		Response res =reqspec.auth().basic("postman", "password").get();
		System.out.println("Response SStatus "+res.statusLine());
		
	}
	@Test
	public void DigestAuth() {
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://httpbin.org/");
		reqSpec.basePath("/digest-auth/undefined/souvik/souvik");
		Response res = reqSpec.auth().digest("souvik", "souvik").get();
		System.out.println(res.statusCode());
		System.out.println("Response Body "+res.body().asString());
	}
	@Test
	//https://api.openweathermap.org/data/3.0/onecall?lat={lat}&lon={lon}&exclude={part}&appid={API key}
	public void testWeather() {
		RequestSpecification req = RestAssured.given();
		req.baseUri("https://api.openweathermap.org");
		req.basePath("/data/2.5/weather");
		req.queryParam("lat", "44").queryParam("lon", "33").queryParam("appid", "f8bafdff5f20debe0bc8217ee86ae1fa").log().all();
		Response res = req.get();
		Assert.assertEquals(res.statusCode(),200);
		System.out.println(res.statusCode());
		System.out.println("Response Body "+res.body().asString());
		
		
	}

}
