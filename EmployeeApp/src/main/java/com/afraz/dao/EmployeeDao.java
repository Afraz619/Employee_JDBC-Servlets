package com.afraz.dao;
import java.sql.Connection;
import java.sql.Statement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.afraz.model.Employee;


public class EmployeeDao {
	Connection con;

	public EmployeeDao() {
		con=MyEmployeeConnection.connectTODb();
	}
	
	//insert data
	public boolean insert(Employee emp_bean) {
		String insert="INSERT INTO employee" +
								"(id, first_name, last_name, username, password, address, contact) VALUES " +
																							" (null, ?, ?, ?, ?,?,?);";
		try { 
		PreparedStatement ps = con.prepareStatement(insert); 
	           // ps.setInt(1, 5);
	            ps.setString(1, emp_bean.getFirstName());
	            ps.setString(2, emp_bean.getLastName());
	            ps.setString(3, emp_bean.getUsername());
	            ps.setString(4, emp_bean.getPassword());
	            ps.setString(5, emp_bean.getAddress());
	            ps.setString(6, emp_bean.getContact());
	            int flag =ps.executeUpdate();
	            if(flag==1) {
	            	return true;
	            }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	
	//display
	public List<Employee> getAllEmp() {
		
		 List<Employee> empList=new ArrayList<Employee>();
	       String select="select * from employee";
	    try {
	        Statement st=con.createStatement();
	       ResultSet rs= st.executeQuery(select);
	       
	       while(rs.next()){
	           int emp_id=rs.getInt(1);
	           String firstname=rs.getString(2);
	           String lastname =rs.getString(3);
	           String username =rs.getString(4);
	           String address =rs.getString(5);
	           String password =rs.getString(6);
	           String contact =rs.getString(7);
	           
	           
	           
	           //we need it emp type
	           Employee emp=new Employee(firstname, lastname, username, password, address, contact);
	           emp.setEmp_id(emp_id);
	           
	           empList.add(emp);   
	       }
	       
	        
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	      System.err.print(ex.getMessage());
	    }
	       
	    
	    return empList;

	}
	
	//delete
	public boolean deleteEmp(int idValue) {
		
		String deleteQuery="delete from employee where id="+idValue;
		try {
			 Statement stm=con.createStatement();
			 int result=stm.executeUpdate(deleteQuery);
			 if(result==1) {
				 return true;
			 }
			 else {
				 return false;
			 }
			 
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return false;
	}
	
	//edit
	public Employee getEmp(int idval) {
		Employee  emp=new Employee();
	    String select ="select * from employee where id="+idval;
	    Statement st;
	    try {
	        st = con.createStatement();
	        ResultSet rs=st.executeQuery(select);
	         if(rs.next()){
	            emp.setEmp_id(idval);
	            emp.setFirstName(rs.getString(2));
	            emp.setLastName(rs.getString(3));
	            emp.setUsername(rs.getString(4));
	            emp.setPassword(rs.getString(5));
	            emp.setAddress(rs.getString(6));
	            emp.setContact(rs.getString(7));
	             return emp;
	         }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	 
	     return  null;
	}
	

	//update
	public boolean updateEmp(Employee emp_bean) {
		String update="update employee set first_name=?,last_name=?,username=?,password=?,address=?,contact=? where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(update);
			ps.setString(1, emp_bean.getFirstName());
			ps.setString(2, emp_bean.getLastName());
			ps.setString(3, emp_bean.getUsername());
			ps.setString(4, emp_bean.getPassword());
			ps.setString(5, emp_bean.getAddress());
			ps.setString(6, emp_bean.getContact());
			ps.setInt(7, emp_bean.getEmp_id());
			
			int result=ps.executeUpdate();
			
			if(result==1) {
				return true;
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	

}
