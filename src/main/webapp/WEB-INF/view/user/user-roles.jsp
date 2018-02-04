<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/view/navbar.jsp"%>

<!DOCTYPE html>
<html>

<head>
	<title> Client contacts</title>
	
</head>
<body>
		<h3>Client contacts</h3>
		
		<form:form action="showUserRoles" modelAttribute="userRoles" method="POST" class="form-horizontal">
			
				<div class="form-group">
						<label class="control-label col-sm-2"> User:</label>
						  <div class="col-sm-6">		  
							<form:select class = "form-control" path="userId">						
              				 	<form:options items="${users}"  itemValue="id" itemLabel="fullName"/>
							</form:select>
						</div>
   				</div>
				<div class="form-group"> 
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" class="btn btn-default" value="Build"/>
					</div>
				</div>			
		</form:form>
		<div style="clear; both;"></div>
	
</body>
</html>