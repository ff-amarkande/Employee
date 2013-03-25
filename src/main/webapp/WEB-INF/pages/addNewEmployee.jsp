<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function submitEmployeeForm(){
		alert('Main yahan hoon');
		document.forms[0].submit();
	}
	
	
</script>

</head>
<body>

<h2>Employee Information</h2>
<form:form method="POST"  action="addEmployee" commandName="EmployeeBean">
   <table>
    <tr>
        <td> ID</td>
        <td><form:input path="employeeID" /></td>
        <td style="color: red;"><form:errors path="employeeID"></form:errors> </td>
    </tr>
    <tr>
        <td>Name</td>
        <td><form:input path="employeeName" /></td>
        <td style="color: red;"><form:errors path="employeeName"/></td>
    </tr>
    <tr>
        <td>Age</td>
        <td><form:input path="employeeAge" /></td>
        <td style="color: red;"><form:errors path="employeeAge"/></td>
    </tr>
    <tr>
        <td>Salary</td>
        <td><form:input path="employeeSalary" /></td>
        <td style="color: red;"><form:errors path="employeeSalary"/></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit" onclick="submitEmployeeForm();"/>
        </td>
    </tr>
</table>  
</form:form>






</body>
</html>