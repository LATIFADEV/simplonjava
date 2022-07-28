<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Employee Management Application</title>
 <style>
 a{
	text-decoration:none;
}
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 40%;
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

#Save {
  padding:14px 30px;
  border: none;
  color: white;
  background-color: #04AA6D;
  cursor: pointer;
  font-weight: 900;
  font-size:20px;
  display: block;
  margin-right: auto;
  margin-left: auto;
}
#custome{
 display: block;
  margin-right: auto;
  margin-left: auto;
    height: 30px;
  
}


</style>
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
   <form action="insert" method="post" >
        </c:if>
          
        <table border="1" cellpadding="5" id="customers">
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
           <input type="hidden" name="id_employees" id="custome" value="<c:out value='${employee.getId_employee()}' />" />
          </c:if>            
            <tr>
                <th>Employee FirstName: </th>
                <td>
                 <input type="text" name="firstname" size="75" id="custome"
                   value="<c:out value='${employee.getFirstname()}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Employee LastName: </th>
                <td>
                 <input type="text" name="lastname" size="75" id="custome"
                   value="<c:out value='${employee.getLastname()}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Employee Email: </th>
                <td>
                 <input type="text" name="email" size="75" id="custome"
                   value="<c:out value='${employee.getEmail()}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Employee Adress: </th>
                <td>
                 <input type="text" name="adress" size="75" id="custome"
                   value="<c:out value='${employee.getAdress()}' />"
                 />
                </td>
            </tr>
            
                <th>Contact: </th>
                <td>
                 <input type="text" name="contact" size="75" id="custome"
                   value="<c:out value='${employee.getContact()}' />"
                 />
                </td>
            </tr>
            <tr>
             <td colspan="2" >
              <input type="submit" value="Save" id="Save"/>
             </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
</html>
