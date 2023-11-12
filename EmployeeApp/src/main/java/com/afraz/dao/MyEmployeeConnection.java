package com.afraz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyEmployeeConnection {

      
    
    public static Connection connectTODb(){
  	  String url="jdbc:mysql://localhost:3306/college_db";
      String userName="root";
      String userPassword="welcome";
      String driverName="com.mysql.cj.jdbc.Driver";
      Connection con=null;
    	try {
          Class.forName(driverName);
            try {
               con=DriverManager.getConnection(url, userName, userPassword);
                System.out.println("Connected to DB");
            } catch (SQLException e) {
                System.out.println("Connection failed");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found register to driver failed");
        }
        return con;
        
    }
    public static void main(String[] args) {
		connectTODb();
	}

}
