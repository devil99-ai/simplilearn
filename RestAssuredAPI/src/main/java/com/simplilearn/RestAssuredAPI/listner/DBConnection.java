package com.simplilearn.RestAssuredAPI.listner;

import java.sql.Connection;
import java.sql.Statement;

import org.codehaus.groovy.runtime.callsite.PogoGetPropertySite;

public final class DBConnection {
	private Connection conn;
	private Statement statement;
	public static DBConnection db;
	
	private DBConnection() {
		String url = getProperties("DBUrl");
		String dbName = getProperties("DBName");
		String driver = "com.mysql.jdbc.Driver";
		
		
		
	}

	

}
