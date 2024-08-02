package com.simplilearn.RestAssuredDemo;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class E2E_Testing {

	@Test
	public static void test() {
		
		// TODO Auto-generated method stub
		String userId ="9b5f49ab-eea9ab-45f4-9d66-bcf56a531b85";
		String userName="Test_user";
		String password="Test@123";
		String baseUrl="https://bookstore.toolsqa.com";
		
		RestAssured.baseURI = baseUrl;
		RequestSpecification requestSpecification = RestAssured.given();
		//Step1: generating of authorization token
		requestSpecification.header("Content-Type","application/json");
		Response response = requestSpecification.body("{\r\n"
				+ "  \"userName\": \""+userName+"\",\r\n"
				+ "  \"password\": \""+password+"\"\r\n"
				+ "}").post("/account/v1/GenerateToken");
		Assert.assertEquals(response.getStatusCode(), 200);
		String jsonString = response.asString();
		
		Assert.assertTrue(jsonString.contains("token"));
		String token = JsonPath.from(jsonString).get("token");
		//step2: Get list of available books in library
		response = requestSpecification.get("/BookStore/v1/Books");
		Assert.assertEquals(response.getStatusCode(), 200);
		jsonString = response.asString();
		
		List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
		Assert.assertTrue(books.size() >0);
		String bookId = books.get(0).get("isbn");
		System.out.println("book id: "+bookId);
		//step3: addition of a book from the list of the user
		requestSpecification.header("Authorization","Bearer "+token).header("Content-Type","application/json");
		response = requestSpecification.body("{\r\n"
				+ "			  \"userId\": \""+userId+"\",\r\n"
				+ "			  \"collectionOfIsbns\": [\r\n"
				+ "			    {\r\n"
				+ "			      \"isbn\": \""+bookId+"\"\r\n"
				+ "			    }\r\n"
				+ "			  ]\r\n"
				+ "			}").post("/bookstore/v1/books");
		Assert.assertEquals(201, response.getStatusCode());
		//Step4: Deletion of the added book from the list
		requestSpecification.header("Authorization","Bearer "+token).header("Content-Type","application/json");
		response = requestSpecification.body("{\r\n"
				+ "			  \"isbn\": \""+bookId+"\",\r\n"
				+ "			  \"userId\": \""+userId+"\"\r\n"
				+ "			}").delete("/bookstore/v1/book");
		Assert.assertEquals(204, response.getStatusCode());
		//Step5: confirmation of weather the book has been removed successfully or not
		requestSpecification.header("Authorization","Bearer "+token).header("Content-Type","application/json");
		response = requestSpecification.get("/Account/v1/user"+userId);
		Assert.assertEquals(200, response.getStatusCode());
		jsonString = response.asString();
		List<Map<String,String>> bookOfUser = JsonPath.from(jsonString).get("books");
		Assert.assertEquals(0, bookOfUser.size());
		
		
				

	}

}

