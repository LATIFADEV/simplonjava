<%@page import="net.javahibernate.usermanagment.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <link rel="stylesheet" href="styles.css">
 <title>Employee Management Applicationnnnnnn</title>
 
 <style>
 a{
	text-decoration:none;
}
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 80%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers td{
  height: 60px;

}


#edit {
  color: royalblue;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
  height: 50px;
}

h2 {
  font-size:30px;
}
</style>
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
        <table border="1" cellpadding="5" id="customers">
            <caption><h2>List of Employee</h2></caption>
            <tr>
                <th>ID</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Adresse</th>
                <th>Contact</th>
                <th>Actions</th>
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
                     <a id="edit" href="edit?id_employees=<%=employee.getId_employee()%>">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id_employees=<%=employee.getId_employee()%>">Delete</a>                     
                    </td>
                </tr>
            <%-- </c:forEach> --%>
            <%  } %>
            
        </table>
    </div> 
</body>
</html>
