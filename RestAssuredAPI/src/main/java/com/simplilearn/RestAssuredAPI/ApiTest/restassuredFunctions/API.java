package com.simplilearn.RestAssuredAPI.ApiTest.restassuredFunctions;

import java.io.File;
import java.util.List;



import com.simplilearn.RestAssuredAPI.ApiTest.actions.HTTOPOperation;
import com.simplilearn.RestAssuredAPI.ApiTest.actions.ValidatingOperation;
import com.simplilearn.RestAssuredAPI.apitestinterfaces.iAPI;
import com.simplilearn.RestAssuredAPI.utilities.helper;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API implements iAPI {
	
	RequestSpecification reqSpec;
	HTTOPOperation method;
	String url;
	Response res;

	@Override
	public void init(String url, HTTOPOperation method) {
		// TODO Auto-generated method stub
		this.url=url;
		reqSpec = given();
		
	}
	public void initBase(String baseConst) {
		helper getHelp =new helper();
		getHelp.set_path("/src/main/resources/constany=t.properties");
		try {
			RestAssured.baseURI=getHelp.loadProperties(baseConst);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		reqSpec = RestAssured.given();
	}

	@Override
	public void setHeader(String[] head) {
		// TODO Auto-generated method stub
		for(int row=0;row<head.length;row++) {
			for(int col=0;col<head[row].length();row++) {
				reqSpec.header(head[row][col],head[row][col+1]);
			}
		}
		
	}

	@Override
	public void setHeader(String head, String val) {
		// TODO Auto-generated method stub
		reqSpec.header(head,val);
		
	}

	@Override
	public void setBody(String body) {
		// TODO Auto-generated method stub
		reqSpec.body(body);
	}

	@Override
	public void setFormParam(String key, String val) {
		// TODO Auto-generated method stub
		reqSpec.formParam(key,val);
	}

	@Override
	public void setQueryParam(String key, String val) {
		// TODO Auto-generated method stub
		reqSpec.queryParam(key,val);
	}

	@Override
	public String callIt() {
		// TODO Auto-generated method stub
		if(method.toString().equalsIgnoreCase("get")) {
			res=reqSpec.get(url);
			return res.asString();
		}else if(method.toString().equalsIgnoreCase("post")) {
			res =reqSpec.post(url);
			return res.asString();
		}else if(method.toString().equalsIgnoreCase("patch")) {
			res =reqSpec.patch(url);
			return res.asString();
		}else if(method.toString().equalsIgnoreCase("put")) {
			res =reqSpec.put(url);
			return res.asString();
		}else if(method.toString().equalsIgnoreCase("delete")) {
			res =reqSpec.delete(url);
			return res.asString();
		}
		return "invalid method set for API";
	}

	@Override
	public API assertIt(String key, Object val, ValidatingOperation operation) {
		// TODO Auto-generated method stub
		switch(operation.toString()) {
		case "EQUALS":
			res.then().body(key, equalTo(val));
			break;
		case "KEY_PRESENTS":
			res.then().body(key, hasKey(key));
			break;
		case "NOT_EQUALS":
			res.then().body(key, not(equalTo(val)));
			break;
		case "EMPTY":
			res.then().body(key, empty());
			break;
		case "NOT_EMPTY":
			res.then().body(key, not(emptyArray()));
			break;
		case "NOT_NULL":
			res.then().body(key, not(notNullValue());
			break;
		case "HAS_STRING":
			res.then().body(key, containsString((String)val));
			break;		
		case "SIZE":
			res.then().body(key, hasSize((int)val));
			break;		
		}
		return this;
	}
	
	@Override
	public void assertIt(List<List<Object>> data) {
		// TODO Auto-generated method stub
		for(List<Object> li: data) {
			switch((ValidatingOperation)li.get(2).toString()) {
			case "EQUALS":
				res.then().body(((String)li.get(0)), equalTo((String) li.get(1)));
				break;
			case "KEY_PRESENTS":
				res.then().body(((String)li.get(0)), hasKey((String) li.get(1)));
				break;				
			case "HAS_ALL":
				break;			
			}
		}
	}

public API assertIt(int code) {
	res.then().statusCode(code);
	return this;
}
	@Override
	public void fileUpload(String key, String path, String m) {
		// TODO Auto-generated method stub
		reqSpec.multiPart(key,new File(path),m);
		
	}

	@Override
	public String extractString(String path) {
		// TODO Auto-generated method stub
		return res.jsonPath().getString(path);
	}

	@Override
	public int extractInt(String path) {
		// TODO Auto-generated method stub
		return res.jsonPath().getInt(path);
	}

	@Override
	public List extractList(String path) {
		// TODO Auto-generated method stub
		return res.jsonPath().getList(path);
	}

	@Override
	public Object extractIt(String path) {
		// TODO Auto-generated method stub
		return res.jsonPath().get(path);
	}

	@Override
	public String extractHeader(String header_name) {
		// TODO Auto-generated method stub
		return res.header(header_name);
	}

	@Override
	public String getResponseString() {
		// TODO Auto-generated method stub
		return res.asString();
	}

	@Override
	public void printResp() {
		// TODO Auto-generated method stub
		res.print();
	}
	

}
