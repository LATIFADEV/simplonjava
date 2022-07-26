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
            <c:forEach var="employee" items="${listEmployee}">
            
            <td><c:out value="${listEmployee}" /></td>
                <tr>
                    <td><c:out value="${employee.id_employees}" /></td>
                    <td><c:out value="${employee.firstname}" /></td>
                    <td><c:out value="${employee.lastname}" /></td>
                    <td><c:out value="${employee.email}" /></td>
                    <td><c:out value="${employee.Adress}" /></td>
                    <td><c:out value="${employee.Contact}" /></td> 
                    <td>
                     <a href="edit?id_employees=<c:out value='${employee.id_employees}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id_employees=<c:out value='${employee.id_employees}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>
