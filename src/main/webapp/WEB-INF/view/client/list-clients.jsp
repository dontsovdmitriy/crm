<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/view/navbar.jsp"%>

<!DOCTYPE html>

<html>

<head>
	<title>List Clients</title>
</head>

<body>
	
	<div id="container">
		
			<input type="button" value="Add Client"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"
				/>
			 <div class="table-responsive">          
				
			<table class="table">
			    <thead>	
				<tr>
					<th>Name</th>	
					<th>Turnover</th>	
					<th>Manager</th>	
					<th>Status</th>																									
				</tr>
				</thead>
				<tbody>
					<c:forEach var="tempClient" items="${clients}">
					<c:url var="updateLink" value="/client/showFormForUpdate">
						<c:param name="clientId" value="${tempClient.id }"/>
					</c:url>
					<c:url var="deleteLink" value="/client/delete">
						<c:param name="clientId" value="${tempClient.id }"/>
					</c:url>
					<tr>
						<td>${tempClient.name}</td>
						<td>${tempClient.turnover}</td>
						<td>${tempClient.user.surname} ${tempClient.user.name} ${tempClient.user.secondName}</td>						
						<td>${tempClient.status}</td>						
												
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete this client?'))) return false">Delete</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>