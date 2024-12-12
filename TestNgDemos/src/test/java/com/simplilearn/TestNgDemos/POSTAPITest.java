package com.simplilearn.TestNgDemos;

import org.testng.annotations.Test;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

public class POSTAPITest {
	
	@Test
	public void createBooking() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		JSONObject booking = new JSONObject();
		JSONObject bookingDates= new JSONObject();
		
		booking.put("firstname", "souvik");
		booking.put("lastname", "Sharma");
		booking.put("totalprice", 1000);
		booking.put("depositpaid", true);
		booking.put("bookingdates", bookingDates);
		
		bookingDates.put("checkin", "2024-04-22");
		bookingDates.put("checkout", "2024-05-02");
		
		Response response = RestAssured.given().contentType(ContentType.JSON).body(booking.toString()).baseUri("https://restful-booker.herokuapp.com/booking")
				.when().post().then().assertThat().statusCode(200)
				.body("booking.firstname", Matchers.equalTo("souvik")).body("booking.totalprice", Matchers.equalTo(1000))
				.body("booking.bookingdates.checkout", Matchers.equalTo("2024-05-02")).extract().response();
		int bookingId=response.path("bookingid");
		
		RestAssured.given().contentType("application/json").pathParam("bookingID", bookingId).baseUri("https://restful-booker.herokuapp.com/booking")
	.when().get("{bookingID}").then().assertThat().statusCode(200);
			}

}

//package com.testAutomation.apitesting.tests;

//import org.hamcrest.Matchers;
//import org.testng.annotations.Test;
//
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import net.minidev.json.JSONObject;
//
//public class POSTAPITest {
//  
//	@Test
//	public void createBooking() {
//		
//	RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
//	
//	JSONObject booking = new JSONObject();
//	JSONObject bookingDates = new JSONObject();
//	
//	booking.put("firstname", "SAmpleFirstName1");
//	booking.put("lastname", "SAmpleLastName1");
//	booking.put("totalprice", 1000);
//	booking.put("depositpaid", true);
//	booking.put("bookingdates", bookingDates);
//    
//	bookingDates.put("checkin", "2023-03-25"); 
//	bookingDates.put("checkout", "2023-03-30"); 
//	
//	Response response = RestAssured.given().contentType(ContentType.JSON).body(booking.toString())
//	           .baseUri("https://restful-booker.herokuapp.com/booking")
//	           .when()
//	            .post()
//	            .then()
//	            .assertThat()
//	            .statusCode(200)
//	            .body("booking.firstname", Matchers.equalTo("SAmpleFirstName1"))
//	            .body("booking.totalprice",Matchers.equalTo(1000))
//                /*   .body("booking.bookingDates.checkin",Matchers.equalTo("2023-03-25"))*/
//                .body("booking.bookingdates.checkout",Matchers.equalTo("2023-03-30"))
//
//	            .extract().response();
//	
//	int bookingId = response.path("bookingid");
//	
//	RestAssured.given()
//	           .contentType("application/json")
//	           .pathParam("bookingID", bookingId)
//	           .baseUri("https://restful-booker.herokuapp.com/booking")
//	           .when()
//	            .get("{bookingID}")
//	            .then().assertThat().statusCode(200);
//
//	}
//	
//      
//}
