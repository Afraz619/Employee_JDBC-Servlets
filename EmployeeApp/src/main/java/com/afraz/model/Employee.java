package com.afraz.model;

import java.io.Serializable;

public class Employee implements Serializable {
	private int emp_id;


	private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String address;
    private String contact;
	
    
   
    public Employee() {
		super();
	}
    
    
	public Employee(String firstName, String lastName, String username, String password, String address,
			String contact) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.address = address;
		this.contact = contact;
	}
	
	public int getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}



	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	


	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + ", address=" + address + ", contact=" + contact + "]";
	}
    
    

}
