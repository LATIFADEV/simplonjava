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
         <a href="list">List All Employees</a>
         
        </h2>
 </center>
    <div align="center">
  <c:if test="${employee != null}">
   <form action="update" method="post">
        </c:if>
        <c:if test="${employee == null}">
   <form action="insert" method="post">
        </c:if>
          
        <table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${employee != null}">
               Edit employee
              </c:if>
              <c:if test="${employee == null}">
               Add New Employee
              </c:if>
             </h2>
            </caption>
          <c:if test="${employee != null}">
           <input type="hidden" name="id_employees" value="<c:out value='${employee.getId_employee()}' />" />
          </c:if>            
            <tr>
                <th>Employee FirstName: </th>
                <td>
                 <input type="text" name="firstname" size="45"
                   value="<c:out value='${employee.getFirstname()}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Employee LastName: </th>
                <td>
                 <input type="text" name="lastname" size="45"
                   value="<c:out value='${employee.getLastname()}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Employee Email: </th>
                <td>
                 <input type="text" name="email" size="45"
                   value="<c:out value='${employee.getEmail()}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Employee Adress: </th>
                <td>
                 <input type="text" name="adress" size="45"
                   value="<c:out value='${employee.getAdress()}' />"
                 />
                </td>
            </tr>
            
                <th>Contact: </th>
                <td>
                 <input type="text" name="contact" size="15"
                   value="<c:out value='${employee.getContact()}' />"
                 />
                </td>
            </tr>
            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Save" />
             </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
</html>
