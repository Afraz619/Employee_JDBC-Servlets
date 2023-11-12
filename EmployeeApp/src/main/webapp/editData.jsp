<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.afraz.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<center>
<body>
	
	<%
	Employee emp=(Employee)request.getAttribute("empdata");
	%>
	
	<form action="EmployeeServlet?action=update&id=<%=emp.getEmp_id()%>" method="post">
	
	<table >
        
           <tbody>
               <tr>
                   <td>Enter FirstName:</td>
                   <td><input type="text" name="firstname" value="<%=emp.getFirstName()%>" /></td>
               </tr>
               <tr>
               		<td>Enter LastName:</td>
               		<td><input type="text" name="lastname" value="<%=emp.getLastName() %>"/></td>
               <tr>
                   <td>Enter Username:</td>
                   <td><input type="text" name="username" value="<%=emp.getUsername()%>" /></td>
               </tr>
               <tr>
                   <td>Enter Password:</td>
                   <td><input type="text" name="password" value="<%=emp.getPassword()%>" /></td>
               </tr>
               <tr>
                   <td>Enter Address:</td>
                   <td><input type="text" name="address" value="<%=emp.getAddress()%>" /></td>
               </tr>
               <tr>
                   <td>Enter Contact:</td>
                   <td><input type="text" name="contact" value="<%=emp.getContact()%>" /></td>
               </tr>
                  <tr>
                   <td></td>
                   <td><input type="submit"  value="Update" /></td>                   
               </tr>
           </tbody>
       </table>

       </form> 
</body>
</center>
</html>