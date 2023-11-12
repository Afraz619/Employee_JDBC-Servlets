<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="com.afraz.model.Employee"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Display</title>
</head>
<body>
<center>
	<h1>Details</h1>
	<%List<Employee> emplist=(List<Employee>)request.getAttribute("list"); %>
	<table Border="1">
	<thead>
		<tr>
			<th>FirstName</th>
			<th>LastName</th>
			<th>UserName</th>
			<th>Password</th>
			<th>Address</th>
			<th>Contact</th>
			<th>Delete</th>
            <th>Update</th>
		</tr>
	</thead>
	<tbody>
                <%
                for(Employee emp:emplist){
                %>
                <tr>
                	
                    <td><%=emp.getFirstName() %></td>
                    <td><%=emp.getLastName() %></td>
                    <td><%=emp.getUsername() %></td>
                    <td><%=emp.getPassword() %></td>
                    <td><%=emp.getAddress() %></td>
                    <td><%=emp.getContact() %></td>
                    <td><a href="EmployeeServlet?action=delete&id=<%=emp.getEmp_id() %>"><img src="image/images.jpg"/></a></td>

                    <td><a href="EmployeeServlet?action=editData&id=<%=emp.getEmp_id() %>">Edit</a></td>
                </tr>
                <%} %>
    </tbody>
    </table>
</center>
</body>
</html>