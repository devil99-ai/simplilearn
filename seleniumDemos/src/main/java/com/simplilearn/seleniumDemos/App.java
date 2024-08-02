package com.simplilearn.seleniumDemos;

import java.util.List;

import com.simplilearn.JDBCDemos.db.DB;

public class App 
{
    public static void main( String[] args )
    {
        DB db=new DB();
        db.createConnection();
        /*Customer customer = new Customer();
        //customer.setCid(2);
        customer.setName("John wick");
        customer.setEmail("jhnwck@example.com");
        customer.setAge(24);
        customer.setPhone("9876543210");
        customer.setBirthdate("1999-01-01");
        //customer.setIndatetime("");
        customer.setTemparature(98.5f);
        //Customer customer = new Customer();
        //customer.setCid(2);
        
        System.out.println(customer);
        db.createCustomer(customer);
        //db.updateCustomer(customer);
        //db.deleteCustomer(customer);*/
          List<Customer> customers = db.getAllCustomers();
          for (Customer customer : customers) {
        	System.out.println(customer);
        }
        
        db.closeConnection();
    }
}
