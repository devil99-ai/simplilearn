package com.simplilearn.RestAssuredDemo;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ParsingXMLResponse {
	@Test
	public void test() {
		String baseUri = "https://run.mocky.io";
		String endPoint = "4e2ac039-f9e0-461f-ab32-57f73e9c0064";
		RestAssured.baseURI=baseUri;
		
		RequestSpecification requestSpecification = RestAssured.given().accept(ContentType.XML);
		Response res = requestSpecification.get(endPoint);
		System.out.println("Response:");
		System.out.println(res.prettyPrint());
		
		XmlPath xmlPath = res.xmlPath();
		List<Object> subjectNamesList = xmlPath.getList("courses.subject.name");
		System.out.println("subject name : "+subjectNamesList);
		Assert.assertTrue(subjectNamesList.size()>0);
	}

}
