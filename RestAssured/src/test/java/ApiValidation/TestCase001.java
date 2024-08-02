package ApiValidation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestCase001 {
	

	public static void main(String[] args) {
		Get_APITest_Method();
		Post_APITest_Method();
	}
	public static void Get_APITest_Method() {
		// Accessing rest assured
		String BaseURI = "https://reqres.in/";
		RestAssured.baseURI = BaseURI;
		//Accessing endpoint
		String EndPoint ="/api/users/2";
		Response res = RestAssured.get(EndPoint);
		
		int StatusCode = res.getStatusCode();
		System.out.println("The status cod for get - api"+" "+ StatusCode);
		System.out.println(res.getTime());
		//Response response = RestAssured.given().contentType(ContentType.JSON).body(null)

	}
	
	public static void Post_APITest_Method() {
		String BaseURIPost = "https://reqres.in";
		String EndPointPost = "/api/users";
		String APIBody ="{\name\":\"morphus\",\"job\":\"leader\"}";
		int ExpStatusCode = 201;
		Response resp = RestAssured.given().contentType(ContentType.JSON).body(APIBody).post(EndPointPost);
		int StatusCode1 = resp.getStatusCode();
		System.out.println("The status cod for get - api"+" "+ StatusCode1);
		
		String headerval = resp.getHeader(APIBody);
		System.out.println(headerval);
		System.out.println(resp.getTime());
		
		int actStatusCode = resp.getStatusCode();
		
		if(ExpStatusCode==actStatusCode) {
			System.out.println("valid status code generated");
		}
		else {
			System.out.println("Invalid status Code");
		}
		
	}

}
