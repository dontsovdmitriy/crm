<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/view/navbar.jsp"%>

<!DOCTYPE html>

<html>

<head>
	<title>List Users</title>
</head>

<body>
	
	<div id="container">
	
	<!--  	
			<input type="button" value="Add User"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"
				/>
	-->				
			 <div class="table-responsive">          
			<table class="table">
			    <thead>
				<tr>
					<th>Surname</th>	
					<th>Name</th>	
					<th>Second name</th>	
					<th>Phone number</th>	
					<th>Type</th>							
				</tr>
				</thead>
				<tbody>
					<c:forEach var="tempUser" items="${users}">
					<c:url var="updateLink" value="/user/showFormForUpdate">
						<c:param name="userId" value="${tempUser.id }"/>
					</c:url>
					<c:url var="deleteLink" value="/user/delete">
						<c:param name="userId" value="${tempUser.id }"/>
					</c:url>
					<tr>
						<td>${tempUser.surname}</td>
						<td>${tempUser.name}</td>
						<td>${tempUser.secondName}</td>
						<td>${tempUser.phoneNumber}</td>
						
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete this user?'))) return false">Delete</a>
						</td>
					</tr>
					</c:forEach>
				 </tbody>
			</table>
		</div>
	</div>

</body>
</html>