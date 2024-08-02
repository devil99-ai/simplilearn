package com.simplilearn.RestAssuredAPI.utilities;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class helper {
	String path;
	
	public String loadProperties(String property) {
		Properties pro = new Properties();
		InputStream input;
		
		try {
			input = new FileInputStream(path);
			pro.load(input);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return pro.getProperty(property);
	}
	public helper set_path(String path2) {
		path = path2;
		return this;
		
	}
	
	public static String[][] ReadTSV(String file_name){
		String CSVfile = file_name;
		
		List<String[]> li_2d = new ArrayList<String[]>();
		
		BufferedReader br=null;
		String line = "";
		String SplitBy="\t";
		try {
			br = new BufferedReader(new FileReader(CSVfile));
			br.readLine();
			while((line=br.readLine())!=null) {
				li_2d.add(line.split(SplitBy));
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (Exception e ) {
			e.printStackTrace();
		}finally {
			if(br!=null) {
				try {
					br.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
		String[][] array_2d = new String[li_2d.size()][];
		for(int i=0;i<li_2d.size();i++) {
			array_2d[i] = li_2d.get(i);
		}
		return array_2d;
	}
	public static List<String[]> ReadCSV(String file) throws IOException, CsvException{
		FileReader filereader = new FileReader(file);
		CSVReader csvreader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
		List<String[]> allData = csvreader.readAll();
		return allData;
	}
	public static void assertAll(String inpu, String output, String strict) {
		try {
			JSONAssert.assertEquals(inpu, output, true);
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		public static void assertInt(String actual, String expected, String error_message) {
			assertEquals(actual,expected,error_message);
			
		}
		public static void assertValue(String input,String output,String value) {
				JSONObject inputjson = new JSONObject();
				String key = inputjson.get(key).toString();
				assertEquals(key, value);
		
	
				
	}
//		public static String getValue(String input, String key) throws JSONException {
//			JSONObject inputJS= new JSONObject(input);
//			JSONArray jsonArray = inputJS.get(key).toString();
//			return jsonArray;
//		}
//			
		
		public String getsiteToken() {
			String siteToken = null;
			helper getHelp = new helper();
			
			getHelp.set_path("");
			try {
				siteToken = getHelp.loadProperties("SiteToken");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return siteToken;
		}

}
