<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
</head>
<body>
<h2>Welcome</h2>
 Click <a href="hello.html">here</a> to see list of Employees
 <h3>List of Employees </h3>
 <table width="50%">
  <tr> <td align="center">Employee ID</td> <td align="center">Employee Name</td> <td align="center">Employee Age</td>  <td align="center">Employee Salary</td></tr>
    <c:forEach var="employeeobj" items="${employeeList}">
    <tr>
      <td align="center">${employeeobj.employeeID}</td>
      <td align="center">${employeeobj.employeeName}</td>
      <td align="center">${employeeobj.employeeAge}</td>
      <td align="center">${employeeobj.employeeSalary}</td>
    </tr>
</c:forEach>
</table>
 </body>
</html>
