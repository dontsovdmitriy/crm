<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/view/navbar.jsp"%>

<!DOCTYPE html>
<html>

<head>
	<title> Save Target</title>
</head>
<body>
		<h3>Save Target</h3>
		
		<form:form action="saveTarget" modelAttribute="target" method="POST" class="form-horizontal">
			
			<form:hidden path="id"/>
				<div class="form-group">
					<label class="control-label col-sm-2"> Target:</label>
					  <div class="col-sm-6">		  
						<form:input class = "form-control" path="name"/>
						<form:errors path="name" cssClass="error" />
						
					</div>
				</div>
				<div class="form-group"> 
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" class="btn btn-default" value="Save" class="save"/>
					</div>
				</div>
		</form:form>
		
		<div style="clear; both;"></div>
		
</body>
</html>