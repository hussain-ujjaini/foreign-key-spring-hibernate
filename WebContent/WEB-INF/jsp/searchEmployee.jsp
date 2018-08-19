<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search by Employee Name</title>
<script type="text/javascript">
function titlecheck() {
	if(title.innerHTML=="Search By Department!") {
		divDepartment.style.display="";
	}
	else if(title.innerHTML=="Search By Employee Name!") {
		divEmpName.style.display="";
	}
	else if(title.innerHTML=="Delete By Department!") {
		divDepartmentDelete.style.display="";
	}
}
</script>
</head>
<body onload="titlecheck()">
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<div id="title" style="display:none">${title}</div>
<div class="container">
<div class="row" style="display:none" id="divEmpName">
	<f:form action="searchByEmployeeInDB.htm" method="post" modelAttribute="data">
	<h1>${title}</h1>
  	<div class="form-group">
	   	<label for="FirstName">First Name</label>
    	<f:input path="firstName" id="FirstName" class="form-control" placeholder=" firstname"/>
   	</div>
  	<div class="form-group">
  		<f:button type="Submit" class="form-control">Submit</f:button>
  	</div>
  	</f:form>
</div>
<div class="row" style="display:none" id="divDepartment">
	<f:form action="searchByDepartmentInDB.htm" method="post" modelAttribute="data">
	<h1>${title}</h1>
  		<div class="form-group">
	    	<label for="Department">Department</label>
	    	<f:select path="department.departmentId" id="Department" class="form-control" placeholder=" select">
	    		<c:forEach items="${departmentList}" var="departmentList">
	    			<f:option value="${departmentList.departmentId}">${departmentList.departmentName}</f:option>
	    		</c:forEach>
	    	</f:select>
  		</div>
  	<div class="form-group">
  		<f:button type="Submit" class="form-control">Submit</f:button>
  	</div>
  	</f:form>
</div>
<div class="row" style="display:none" id="divDepartmentDelete">
	<f:form action="deleteByDepartmentInDB.htm" method="post" modelAttribute="data">
	<h1>${title}</h1>
  		<div class="form-group">
	    	<label for="Department">Department</label>
	    	<f:select path="department.departmentId" id="Department" class="form-control" placeholder=" select">
	    		<c:forEach items="${departmentList}" var="departmentList">
	    			<f:option value="${departmentList.departmentId}">${departmentList.departmentName}</f:option>
	    		</c:forEach>
	    	</f:select>
  		</div>
  	<div class="form-group">
  		<f:button type="Submit" class="form-control">Submit</f:button>
  	</div>
  	</f:form>
</div>

</div>
</body>
</html>