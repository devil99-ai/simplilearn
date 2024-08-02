package com.simplilearn.RestAssuredAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class JSONArray {
	@Test
	public void createUsingJSONArray() {
		JSONObject user1 = new JSONObject();
		user1.put("firstName","souvik");
		user1.put("lastName","sharma");
		user1.put("age",25);
		user1.put("salary",24000);
		
		JSONObject user2 = new JSONObject();
		user2.put("firstName","Diya");
		user2.put("lastName","Bhattacherjee");
		user2.put("age",25);
		user2.put("salary",20000);
		
		JSONArray usersPayLoad = new JSONArray();
		//usersPayLoad.add(user1);
		//usersPayLoad.add(user2);
		
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://reqres.in/api/users");
		req.contentType(ContentType.JSON);
		req.body(usersPayLoad);
		
	}
	@Test
	public void createJSONArrayUsingList() {
//		HashMap<String,Integer> map = new HashMap<>();
//		map.put("", 1);
//		map.put("user1", 2);
//		map.put("user2", 3);
//		
//		System.out.println(map.size());
//		
//		System.out.println(map);
//		
//		if(map.containsKey("user2")) {
//			Integer val = map.get("user2");
//			
//			System.out.println("val for key: "+val);
//		}
		Map<String,Object> user1 = new HashMap<String, Object>();
		user1.put("firstName","souvik");
		user1.put("lastName","sharma");
		user1.put("age",25);
		user1.put("salary",24000);
		
		Map<String,Object> user2 = new HashMap<String, Object>();
		user2.put("firstName","Diya");
		user2.put("lastName","Bhattacherjee");
		user2.put("age",25);
		user2.put("salary",20000);
		
		Map<String,Object> user3 = new HashMap<String, Object>();
		user3.put("firstName","sourav");
		user3.put("lastName","sharma");
		user3.put("age",25);
		user3.put("salary",28000);
		
		List<Map<String,Object>> jsonArrayListPayLoad = new ArrayList<>();
		jsonArrayListPayLoad.add(user1);
		jsonArrayListPayLoad.add(user2);
		jsonArrayListPayLoad.add(user3);
		
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://reqres.in/api/users");
		req.contentType(ContentType.JSON);
		req.body(jsonArrayListPayLoad);
		
		Response res = req.post();
		res.prettyPrint();
		req.log().all();
		Assert.assertEquals(res.statusCode(), 201,"Check for status code");
		
		
	}
	@Test
	public void createUser() {
		ObjectMapper obj = new ObjectMapper();
		ObjectNode userDetails = obj.createObjectNode();
		userDetails.put("FirstName", "souvik");
		userDetails.put("LastName", "sharma");
		userDetails.put("age", 25);
		userDetails.put("gender", "Male");
		userDetails.put("isMarried", false);
		userDetails.set("Hobbies", obj.convertValue(Arrays.asList("cooking","Music"), JsonNode.class));
		ObjectNode techSkill = obj.createObjectNode();
		techSkill.put("Programming Language", "Java");
		techSkill.put("Programming Language", "Python");
		techSkill.put("WebAutomation", "Selenium");
		techSkill.put("API Testing", "RestAssured");
		
		userDetails.set("TechSkills", techSkill);
		try {
			String userDetailAsString = obj.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);
			System.out.println("Created JSON Node is: "+userDetailAsString);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String firstName = userDetails.get("FirstName").asText();
		System.out.println("value of first name is: "+firstName);
		
		Boolean isMarried = userDetails.get("isMarried").asBoolean();
		System.out.println("value of married field is: "+isMarried);
		
		String webAutomation = userDetails.get("TechSkills").get("WebAutomation").asText();
		System.out.println("value of web automation is "+webAutomation);
		
		Iterator<String> fieldName = userDetails.fieldNames();
		
		while(fieldName.hasNext()) {
			System.out.println(fieldName.next());
		}
		Iterator<JsonNode> fieldValidator = userDetails.elements();
		
		while(fieldValidator.hasNext()) {
			System.out.println(fieldValidator.next());
		}
		Iterator<Entry<String,JsonNode>> keyValue = userDetails.fields();
		while(keyValue.hasNext()) {
			Entry<String,JsonNode> node = keyValue.next();
			System.out.println("key: "+node.getKey()+","+" Value: "+node.getValue());
			
		}
		String removeValue = userDetails.remove("FirstName").asText();
		System.out.println("Removed value is "+removeValue);
		
		userDetails.put("Lastname", "Malhotra");
		techSkill.put("Programming Language", "C#");
		userDetails.set("TechSkill", techSkill);
		
		
		//Print user details JSON Object
		
		try {
			String userDetailsasString = obj.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);
			System.out.println("JSON Node after Remove method:"+userDetailsasString);
		}catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		
		//Create Request Specification
		
		RequestSpecification reqSpec = RestAssured.given();
		
		reqSpec.baseUri("https://reqres.in/api/users");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(userDetails);
		
		//Perform post request
		
		Response resp = reqSpec.post();
		resp.prettyPrint();
		
		Assert.assertEquals(resp.statusCode(), 201,"Check for status code");
		
		
		
		
		
	}
	   
		
		@Test
  public void createUser1() {
			
			//Create Object mapper class instance
			
			ObjectMapper objectmapper = new ObjectMapper();
			
			ObjectNode userDetails = objectmapper.createObjectNode();
			
			userDetails.put("FirstName", "Akash");
			userDetails.put("LastName", "Khanna");
			userDetails.put("age", 37);
			userDetails.put("salary", "12345");
			userDetails.put("IsMarried", true);
			userDetails.set("Hobbies", objectmapper.convertValue(Arrays.asList("Cooking","Music"), JsonNode.class));
			
			ObjectNode technicalSkills = objectmapper.createObjectNode();
			technicalSkills.put("Programming Language", "Java");
			technicalSkills.put("WebAutomation", "Selenium");
			technicalSkills.put("API Testing", "RestAssured");
			
			userDetails.set("TechSkills", technicalSkills);
			
			//print user Details
			
			try {
				String userDetailsAsString = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);
				System.out.println("Created JSON Node is:"+userDetailsAsString);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			// Retrieve Field Value
			String firstName = userDetails.get("FirstName").asText();
			System.out.println("Value of FirstName field is:"+firstName);
			
			Boolean isMarried = userDetails.get("IsMarried").asBoolean();
			System.out.println("Value of Married field is:"+isMarried);
			
			//retired field value of webautomation
			String webAutomationValue = userDetails.get("TechSkills").get("WebAutomation").asText();
			System.out.println("Value of Web Automation is"+webAutomationValue);
			
			
			// Print all the field Names
			
			Iterator<String> fieldNameIterator = userDetails.fieldNames();
			
			while(fieldNameIterator.hasNext()) {
				System.out.println(fieldNameIterator.next());
			}
			
			
		  //Print all field values	
			Iterator<JsonNode> fieldValuesIterator = userDetails.elements();
			
			while(fieldValuesIterator.hasNext()) {
				System.out.println(fieldValuesIterator.next());
			}
			
			//Print all the filed name and values(key, value pair)
			
			Iterator<Entry<String,JsonNode>> keyValueEnteries = userDetails.fields();
			
			while(keyValueEnteries.hasNext()) {
				Entry<String,JsonNode> node = keyValueEnteries.next();
				System.out.println("key:" +node.getKey() + "," + "Value:" +node.getValue());
			}
			
			// I want to remove field "First Name" from Json Object or ObjectNode
			String removeValued = userDetails.remove("FirstName").asText();
			System.out.println("Removed value is:" +removeValued);
			
			//update JSON object or Object Node
			userDetails.put("Lastname", "Malohtra");
			
			technicalSkills.put("Programming Language", "C#");
			userDetails.set("TechSkill", technicalSkills);
			
			
			//Print user details JSON Object
			
			try {
				String userDetailsasString = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDetails);
				System.out.println("JSON Node after Remove method:"+userDetailsasString);
			}catch(JsonProcessingException e) {
				e.printStackTrace();
			}
			
			//Create Request Specification
			
			RequestSpecification reqSpec = RestAssured.given();
			
			reqSpec.baseUri("https://reqres.in/api/users");
			reqSpec.contentType(ContentType.JSON);
			reqSpec.body(userDetails);
			
			//Perform post request
			
			Response resp = reqSpec.post();
			resp.prettyPrint();
			
			Assert.assertEquals(resp.statusCode(), 201,"Check for status code");
			
			
			
		}
		
		
	}



