<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/view/navbar.jsp"%>

<!DOCTYPE html>
<html>

<head>
	<title> Save Target</title>
	
</head>
<body>
		<h3>Save User</h3>
		
		<form:form action="saveUser" modelAttribute="user" method="POST" class="form-horizontal">
			
			<form:hidden path="id"/>
				<div class="form-group">
					<label class="control-label col-sm-2"> Surname:</label>
					  <div class="col-sm-6">		  
						<form:input class = "form-control" path="surname"/>
						<form:errors path="surname" cssClass="error" />
					  </div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2"> Name:</label>
					  <div class="col-sm-6">		  
						<form:input class = "form-control" path="name"/>
						<form:errors path="name" cssClass="error" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2"> Second name:</label>
						<div class="col-sm-6">		  
							<form:input class = "form-control" path="secondName"/>
							<form:errors path="secondName" cssClass="error" />
						</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2"> Phone number:</label>
						<div class="col-sm-6">
							<form:input class = "form-control" path="phoneNumber"/>
							<form:errors path="phoneNumber" cssClass="error" />
						</div>
				</div>
				<div class="form-group"> 
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" class="btn btn-default" value="Save"/>
					</div>
				</div>
		</form:form>
		
		<div style="clear; both;"></div>
		
</body>
</html>