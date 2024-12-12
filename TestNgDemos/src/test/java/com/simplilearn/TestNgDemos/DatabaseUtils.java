package com.simplilearn.TestNgDemos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class DatabaseUtils {
	Connection connection;
	Statement statement;
	
	public void openConnection() {
		try {
			String url ="jdbc:mysql://localhost/mydb";
			String user="root";
			String password = "Souvik99@";
			connection = DriverManager.getConnection(url,user,password);
			statement = connection.createStatement();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public HashMap<Integer, String> getUsers(){ 
		
		HashMap<Integer, String> users = new HashMap<Integer, String>();
		try {
			String sql = "Select * from user";
			ResultSet set = statement.executeQuery(sql);
			
			while(set.next()) {
				users.put(set.getInt("uid"), set.getString("name"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return users;
	
	

}
		public void closeConnection() {
			try {
				connection.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
}
