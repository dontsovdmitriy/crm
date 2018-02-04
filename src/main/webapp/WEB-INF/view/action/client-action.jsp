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
		
		<form:form action="showClientReport" modelAttribute="actionClientReport" method="POST" class="form-horizontal">
			
				<div class="form-group">
						<label class="control-label col-sm-2"> Client:</label>
						  <div class="col-sm-6">		  
							<form:select class = "form-control" path="clientId">						
              				 	<form:options items="${actionClient}"  itemValue="id" itemLabel="name"/>
							</form:select>
						</div>
   				</div>
				<div class="form-group">
						<label class="control-label col-sm-2" > Date from:</label>
							<div class="col-sm-6">
								 <form:input class="form-control" placeholder="yyyy-MM-dd" path="dateFrom"/>
								 <form:errors path="dateFrom" cssClass="error" />
							</div>
				</div>
				<div class="form-group">
						<label class="control-label col-sm-2" > Date to:</label>
							<div class="col-sm-6">
								 <form:input class="form-control" placeholder="yyyy-MM-dd" path="dateTo"/>
								 <form:errors path="dateTo" cssClass="error" />
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