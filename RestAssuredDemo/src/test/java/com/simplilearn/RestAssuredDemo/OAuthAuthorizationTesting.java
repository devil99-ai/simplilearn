package com.simplilearn.RestAssuredDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OAuthAuthorizationTesting {
	@Test
	public void test() {
		//obtain token from coop platform
		String tokenUrl ="http://coop.apps.symfonycasts.com/token";
		Response res = RestAssured.given().formParam("client_id", "souvik").formParam("client_secret", "f032ceaf455ae60fdd8d6b496008a778").formParam("grant_type", "client_credentials").post(tokenUrl);
		res.prettyPrint();
		
		String token = res.jsonPath().get("access_token");
		System.out.println("access token: "+token);
		//use access token to make api call
		String eggCountUrl = "http://coop.apps.symfonycasts.com/api/4997/eggs-collect";
		Response response = RestAssured.given().auth().oauth2(token).get(eggCountUrl);
		System.out.println(res.prettyPrint());
		System.out.println(res.statusCode());
		Assert.assertEquals(res.statusCode(), 200);
	}

}
