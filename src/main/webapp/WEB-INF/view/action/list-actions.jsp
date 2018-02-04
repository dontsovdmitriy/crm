<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/view/navbar.jsp"%>

<!DOCTYPE html>

<html>

<head>
	<title>List Actions</title>
</head>

<body>
	
	<div class="container">
				
			<input type="button" value="Add Action"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"
				/>
		 <div class="table-responsive">          
		
			<table class="table">
			    <thead>
				<tr>
					<th>Client</th>	
					<th>Type</th>	
					<th>Description</th>	
					<th>Date</th>	
					<th>Target</th>																									
				</tr>
				</thead>
				 <tbody>
					<c:forEach var="tempAction" items="${actions}">
					<c:url var="updateLink" value="/action/showFormForUpdate">
						<c:param name="actionId" value="${tempAction.id }"/>
					</c:url>
					<c:url var="deleteLink" value="/action/delete">
						<c:param name="actionId" value="${tempAction.id }"/>
					</c:url>
					<tr>
						<td>${tempAction.client.name}</td>
						<td>${tempAction.type}</td>
						<td>${tempAction.description}</td>
						<td>${tempAction.dateTime}</td>						
						<td>${tempAction.target.name}</td>						
												
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete this action?'))) return false">Delete</a>
						</td>
					</tr>
					</c:forEach>
				    </tbody>
				</table>
		</div>
	</div>

</body>
</html>