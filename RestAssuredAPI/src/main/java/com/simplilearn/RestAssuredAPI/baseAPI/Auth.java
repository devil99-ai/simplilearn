package com.simplilearn.RestAssuredAPI.baseAPI;

import com.simplilearn.RestAssuredAPI.ApiTest.actions.HTTOPOperation;
import com.simplilearn.RestAssuredAPI.ApiTest.restassuredFunctions.API;

public class Auth extends API {
	
	public Auth() {
		
	}
	/**
	@param username
	@param password
	**/
	private void createToken(String username, String password) {
		initBase("Host");
		init("/auth",HTTOPOperation.POST);
		setHeader("Content-Type","application/json");
		setBody("{\"username\":\""+username+"\",\"password\" :\""+password+"\"}");
	}
	public String getLoginToken(String userName, String Password) {
		createToken(userName, Password);
		String response = callIt();
		return response;
	}

}
