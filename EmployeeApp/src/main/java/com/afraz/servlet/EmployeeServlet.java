package com.afraz.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.afraz.bo.EmployeeBo;
import com.afraz.model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EmployeeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String action = request.getParameter("action");
		
		EmployeeBo emp_bo =new EmployeeBo();
		
		String next=null;
		
		//insert
        if(action.equalsIgnoreCase("insert")) {
        	String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String address = request.getParameter("address");
            String contact = request.getParameter("contact");
            
            Employee emp_bean=new Employee(firstName, lastName, username, password, address, contact);
            boolean status=emp_bo.insert(emp_bean);
            
            if(status) {
            	next = "success.jsp";
            }
            else {
            	next="error.jsp";
            }
            
        }
        
        //display
        if(action.equals("display")){
            List<Employee> list=emp_bo.getAllEmps();
            
            request.setAttribute("list",list);
            next="displayPage.jsp";
        }
        
        
        //delete
        else if(action.equalsIgnoreCase("delete")) {
        	String id=request.getParameter("id");
        	int idValue=Integer.parseInt(id);
        boolean status=	emp_bo.deleteEmp(idValue);
        
        if(status) {
        	List<Employee> list=emp_bo.getAllEmps();
            
            request.setAttribute("list",list);
            next="displayPage.jsp";
        }
        else {
        	next="error.jsp";
        }
        }
        
        //edit
        else if(action.equalsIgnoreCase("editData")) {
        	String id=request.getParameter("id");
            int idval=Integer.parseInt(id); 
            
           Employee emp= emp_bo.getEmp(idval);     
           
           request.setAttribute("empdata", emp);  //?
           next="editData.jsp";
        }
        
        //update 
        
        else if(action.equalsIgnoreCase("update")) {
        	String id=request.getParameter("id");
        	int idval=Integer.parseInt(id);
        	String firstName=request.getParameter("firstname");
        	String lastName=request.getParameter("lastname");
        	String userName=request.getParameter("username");
        	String password=request.getParameter("password");
        	String address=request.getParameter("address");
        	String contact=request.getParameter("contact");
        	
        	Employee emp_bean=new Employee(firstName, lastName, userName, password, address, contact);
        	emp_bean.setEmp_id(idval);
        	
        	boolean status=emp_bo.updateEmp(emp_bean);
        	
        	 if(status) {
             	List<Employee> list=emp_bo.getAllEmps();
                 
                 request.setAttribute("list",list); 
                 next="displayPage.jsp";
             }
             else {
             	next="error.jsp";
             }
        	
        }
        
        RequestDispatcher rd=  request.getRequestDispatcher(next);  //?
	    rd.forward(request, response); //?
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
	   

}
