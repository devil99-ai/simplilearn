package com.simplilearn.JDBCDemos.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.simplilearn.seleniumDemos.Customer;

public class DB implements DAO{
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	
	
	
	public DB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. Driver Loeaded...");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void createConnection() {
		// TODO Auto-generated method stub
		try {
			String user="root";
			String password="Souvik99@";
			String database="mydb";
			String url="jdbc:mysql://localhost:3306/"+database;
			connection = DriverManager.getConnection(url,user,password);
			System.out.println("2. Connection Created...");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		try { if(connection !=null) {
			connection.close();
			System.out.println("3. Connection closed...");
		}else {
			System.out.println("3. Connection doesn't exists...");
		}
	}catch(Exception e) {
		e.printStackTrace();
	}

}

	@Override
	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
			SimpleDateFormat pattern1 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat pattern2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String date1 = pattern1.format(new Date());
			String date2 = pattern2.format(new Date());
			
			System.out.println("date1"+date1);
			System.out.println("date2"+date2);
			customer.setIndatetime(date2);
			customer.setOutdatetime(date2);
			
			
			String sql="insert into Customer values(null,'"+customer.getName()+"','"+customer.getPhone()+"','"+customer.getEmail()+"','"+customer.getBirthdate()+"','"+customer.getAge()+"','"+customer.getIndatetime()+"','"+customer.getOutdatetime()+"','"+customer.getTemparature()+"')";
			System.out.println("SQL" +sql);
			
			statement = connection.createStatement();
			int result=statement.executeUpdate(sql);
			String message = result >0? "Customer "+customer.getName()+" created successfully..": "customer "+customer.getName()+" Not Created..";
			System.out.println(message);
			/*String sql = "insert into customer values(null, ?, ?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getPhone());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setString(4, customer.getBirthdate());
			preparedStatement.setInt(5, customer.getAge());
			preparedStatement.setString(6, customer.getIndatetime());
			preparedStatement.setString(7, customer.getOutdatetime());
			preparedStatement.setFloat(8, customer.getTemparature());
			
			
			int result = preparedStatement.executeUpdate();
			String message = result >0? "Customer "+customer.getName()+" created successfully..": "customer "+customer.getName()+" Not Created..";
			System.out.println(message);*/
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
	try {
		
		String sql = "update Customer set name = ?, phone=?, email= ? where cid= ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, customer.getName());
		preparedStatement.setString(2, customer.getPhone());
		preparedStatement.setString(3, customer.getEmail());
		preparedStatement.setInt(4, customer.getCid());
		
		int result = preparedStatement.executeUpdate();
		String message = result >0? "Customer "+customer.getName()+" created successfully..": "customer "+customer.getName()+" Not Created..";
		System.out.println(message);
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	}

	@Override
	public void deleteCustomer(Customer customer) {
		
		try {
			String sql ="delete from Customer where cid=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer.getCid());
			
			
			int result = preparedStatement.executeUpdate();
			String message = result >0? "Customer "+customer.getCid()+" deleted successfully..": "customer "+customer.getCid()+" Not deleted..";
			System.out.println(message);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customers = new ArrayList<Customer>();
		try {
			String sql = "select * from customer";
			preparedStatement =connection.prepareStatement(sql);
			
			ResultSet set=preparedStatement.executeQuery();
			while(set.next()) {
				Customer customer = new Customer();
				customer.setCid(set.getInt(1));
				customer.setName(set.getString(2));
				customer.setPhone(set.getString(3));
				customer.setEmail(set.getString(4));
				customer.setBirthdate(set.getString(5));
				customer.setAge(set.getInt(6));
				customer.setIndatetime(set.getString(7));
				customer.setOutdatetime(set.getString(8));
				customer.setTemparature(set.getFloat(9));
				customers.add(customer);
			}
			
			
		}catch (Exception e) {
			
		}
		return customers;
	}
}
