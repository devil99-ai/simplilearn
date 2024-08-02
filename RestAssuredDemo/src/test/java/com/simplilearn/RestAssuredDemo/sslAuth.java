package com.simplilearn.RestAssuredDemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class sslAuth {
	@Test
	public void teest() {
		try {
			RestAssured.config().getSSLConfig().with().keyStore("C:\\Program Files\\OpenSSL-Win64\\bin\\certificate.jks", "pass123");
			System.out.println("SSL configuration finish...");
			//request using get and post to domain with ssl certificate as configured
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
