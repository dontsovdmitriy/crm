<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/view/navbar.jsp"%>

<!DOCTYPE html>
<html>

<head>
	<title> Save Client</title>
	
</head>
<body>
		<h3>Save User</h3>
		
		<form:form action="saveClient" modelAttribute="client" method="POST" class="form-horizontal">
			
			<form:hidden path="id"/>
					<div class="form-group">
							<label class="control-label col-sm-2"> Name:</label>
						 <div class="col-sm-6">		  
							<form:input  class="form-control" path="name"/>
							<form:errors path="name" cssClass="error" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2"> Turnover:</label>
						<div class="col-sm-6">		  
							<form:input class="form-control" path="turnover"/>
							<form:errors path="turnover" cssClass="error" />
					  	</div>
					 </div>
					 <div class="form-group">
					 	<label class="control-label col-sm-2"> Manager:</label>
					 		<div class="col-sm-6">		  
					 			<form:select class = "form-control" path="user.id">						
              			 			<form:options items="${clientUser}"  itemValue="id" itemLabel="fullName"   />
								</form:select>
							</div>
				 	</div>
				 	 <div class="form-group">
				 		<label class="control-label col-sm-2"> Status:</label>
				 			<div class="col-sm-6">		  
				 				<form:select class = "form-control" path="status">						
              			 			<form:options items="${clientStatus}"  itemLabel="status" />
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