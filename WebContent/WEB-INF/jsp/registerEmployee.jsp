<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Employee</title>
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<f:form action="insert.htm" method="post" modelAttribute="data">
<div class="container">
	<h1>${title}</h1>
	<div class="form-group">
    	<label for="FirstName">First Name</label>
    	<f:input path="firstName" id="FirstName" class="form-control" placeholder=" firstname"/>
  	</div>
  	<div class="form-group">
    	<label for="LastName">Last Name</label>
    	<f:input path="lastName" id="LastName" class="form-control" placeholder=" lastname"/>
  	</div>
  	<div class="form-group">
    	<label for="UserName">User Name</label>
    	<f:input path="user.username" id="UserName" class="form-control" placeholder=" username"/>
  	</div>
  	<div class="form-group">
    	<label for="Department">Department</label>
    	<f:select path="department.departmentId" id="Department" class="form-control" placeholder=" select">
    		<c:forEach items="${departmentList}" var="departmentList">
    			<f:option value="${departmentList.departmentId}">${departmentList.departmentName}</f:option>
    		</c:forEach>
    	</f:select>
  	</div>
  	<div class="form-group">
    	<label for="Password">Password</label>
    	<f:password path="user.password" id="Password" class="form-control" placeholder=" password"/>
  	</div>
  	<div class="form-group">
  		<f:button type="Submit" class="form-control">Submit</f:button>
  	</div>
</div>
</f:form>
</body>
</html>