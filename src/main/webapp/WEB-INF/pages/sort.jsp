<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Employee List Sorted by <b style="color: red;">${SortBy}</b> and Order by <b style="color: red;">${Order}</b></h3>
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