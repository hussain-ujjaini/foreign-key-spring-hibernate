<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Employee</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="container">
	<div class="row">
		<div class="col-md-1">Id</div>
		<div class="col-md-2">First Name</div>
		<div class="col-md-2">Last Name</div>
		<div class="col-md-3">Username</div>
		<div class="col-md-2">Department</div>
		<div class="col-md-1">Delete</div>
		<div class="col-md-1">Edit</div>
	</div>
	<c:forEach items="${searchedEmployee}" var="searchedEmployee">
		<div class="row">
		<div class="col-md-1">${searchedEmployee[0]}</div>
		<div class="col-md-2">${searchedEmployee[1]}</div>
		<div class="col-md-2">${searchedEmployee[2]}</div>
		<div class="col-md-3">${searchedEmployee[3]}</div>
		<div class="col-md-2">${searchedEmployee[4]}</div>
		<div class="col-md-1"><a href="deleteEmployee.htm?empId=${searchedEmployee[0]}">Delete</a></div>
		<div class="col-md-1"><a href="editEmployee.htm?searchedEmployee=${searchedEmployee}">Edit</a></div>
	</div>
	</c:forEach>
</div>
</body>
</html>