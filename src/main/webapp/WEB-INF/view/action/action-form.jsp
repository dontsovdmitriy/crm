<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/view/navbar.jsp"%>

<!DOCTYPE html>
<html>

<head>
	<title> Save Action</title>
	
</head>
<body>
		<h3>Save Action</h3>
		
		<form:form action="saveAction" modelAttribute="action" method="POST" class="form-horizontal">
			
			<form:hidden path="id"/>
				<div class="form-group">
						<label class="control-label col-sm-2"> Client:</label>
						  <div class="col-sm-6">		  
							<form:select class = "form-control" path="client.id">						
              				 	<form:options items="${actionClient}"  itemValue="id" itemLabel="name"/>
							</form:select>
						</div>
   				</div>
		  		<div class="form-group">
						<label class="control-label col-sm-2"> Action type:</label>
							<div class="col-sm-6">		  
								<form:select class = "form-control" path="type">						
              				 		<form:options items="${actionType}"  itemLabel="type" />
								</form:select>
							</div>
				</div>
				<div class="form-group">
						<label class="control-label col-sm-2" > Decription:</label>
						   <div class="col-sm-6">
								<form:input class="form-control" rows="5" path="description"/>
								<form:errors path="description" cssClass="error" />
							</div>
					</div>
				<div class="form-group">
						<label class="control-label col-sm-2" > Date:</label>
							<div class="col-sm-6">
								 <form:input class="form-control" placeholder= "yyyy-MM-dd" path="dateTime"/>
								 <form:errors path="dateTime" cssClass="error" />
							</div>
				</div>
				<div class="form-group">
						<label class="control-label col-sm-2"> Target:</label>
							<div class="col-sm-6">		  
							<form:select class = "form-control" path="target.id">						
              					 	<form:options items="${actionTarget}"  itemValue="id" itemLabel="name"   />
							</form:select>
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