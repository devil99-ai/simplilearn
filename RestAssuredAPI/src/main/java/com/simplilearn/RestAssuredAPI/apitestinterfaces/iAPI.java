package com.simplilearn.RestAssuredAPI.apitestinterfaces;

import java.util.List;

import com.simplilearn.RestAssuredAPI.ApiTest.actions.HTTOPOperation;
import com.simplilearn.RestAssuredAPI.ApiTest.actions.ValidatingOperation;

public interface iAPI {
	
	public void init(String url, HTTOPOperation method);
	
	public void setHeader(String[] head);
	
	public void setHeader(String head, String val);
	
	public void setBody(String body);
	
	public void setFormParam(String key, String val);
	
	
	public void setQueryParam(String key, String val);
	
	public String callIt();
	
	public Object assertIt(int code);
	
	public Object assertIt(String key, Object val, ValidatingOperation operation);
	
	public void assertIt(List<List<Object>> data);
	
	public static void failTest(String expected, String actual) {
		throw new AssertionError("Doesn't contain the expected "+ expected +"\n but had "+actual);
	}
	public static void failTest(String message) {
		throw new AssertionError(message);
	}
	public void fileUpload(String key, String path, String m);
	
	public String extractString(String path);
	
	public int extractInt(String path);
	
	public List extractList(String path);
	
	
	public Object extractIt(String path);
	
	public String extractHeader(String header_name);
	
	public String getResponseString();
	
	public void printResp();
	

}
