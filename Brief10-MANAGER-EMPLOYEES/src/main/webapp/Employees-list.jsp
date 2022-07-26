<%@page import="net.javahibernate.usermanagment.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Employee Management Application</title>
</head>
<body>
 <center>
  <h1>Employee Management</h1>
        <h2>
         <a href="new">Add New Employee</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">List All Employee</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Employee</h2></caption>
            <tr>
                <th>ID</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Adresse</th>
                <th>Contact</th>
            </tr>
            <%@page import="net.javahibernate.usermanagment.model.Employee"%>
	
	<%
	EmployeeDao employeeDao = new EmployeeDao();
	
	%>
          <%--   <c:forEach var="employee" items="${listEmployee}"> --%>
            <%	for (Employee employee : employeeDao.getAllEmployee()) {
										%>
            
                <tr>
                  <td><%= employee.getId_employee() %>  </td>
                  <td><%= employee.getFirstname() %>  </td>
                  <td><%= employee.getLastname() %>  </td>
                  <td><%= employee.getEmail() %>  </td>
                  <td><%= employee.getAdress() %>  </td>
                  <td><%= employee.getContact()%>  </td>
                    <td>
                     <a href="edit?id_employees=<%= employee.getId_employee() %>">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id_employees=<%= employee.getId_employee() %>">Delete</a>                     
                    </td>
                </tr>
            <%-- </c:forEach> --%>
            <%  } %>
            
        </table>
    </div> 
</body>
</html>
