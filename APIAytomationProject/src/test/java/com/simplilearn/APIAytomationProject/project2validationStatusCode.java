package com.simplilearn.APIAytomationProject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.simplilearn.RestAssuredDemo.App;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class project2validationStatusCode {
	private static final Logger logger = LogManager.getLogger(project2validationStatusCode.class);
	@Test
	public void test() {
		String url ="https://reqres.in";
		String endPoint = "/api/users?page=2";
		
		RestAssured.baseURI=url;
		RequestSpecification requestSpecification = RestAssured.given();
		Response res = requestSpecification.log().get(endPoint);
		Integer actualStatusCode = 200;
		assertEquals(actualStatusCode, res.statusCode(),"Response code validated successfully");
	}
	@Test
	public void getRequest() {
		String url ="https://reqres.in";
		String endPoint = "/api/users?page=2";
		
		RestAssured.baseURI=url;
		RequestSpecification requestSpecification = RestAssured.given();
		Response res = requestSpecification.log().all().get(endPoint);
		System.out.println(res.prettyPrint());
		logger.info(res.asString());
	}
	@Test
	public void postRequest() {
		String url ="https://reqres.in";
		String endPoint = "/api/users";
		
		RestAssured.baseURI=url;
		RequestSpecification requestSpecification = RestAssured.given();
		Response res = requestSpecification.header("Content-Type","application/json").log().all().body("{\r\n"
				+ "    \"name\":\"sourav\",\r\n"
				+ "    \"age\":28\r\n"
				+ "}").post(endPoint);
		System.out.println(res.prettyPrint());
		logger.info(res.asString());
	}
	
	

}
