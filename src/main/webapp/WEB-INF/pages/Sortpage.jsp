<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h3>Select option</h3>

<form action="sort" method="get">

<h3 style="color: red">SortBy</h3>

<select name="sortoption">
<option value="0">ID</option>
<option value="1">Name</option>
<option value="2">Age</option>
<option value="3">Salary</option>
</select> 

<h3 style="color: red">OrderBy</h3>
<select name="orderoption">
<option value="0">Ascending</option>
<option value="1">Descending</option>
</select> 
<br/><br/><br/>
<input type="submit" value="Submit"> 

</form>



</div>
</body>
</html>