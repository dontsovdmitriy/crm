<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@include file="/WEB-INF/view/navbar.jsp"%>
<html>

<head>
	<title>List Roles</title>
</head>

<body>
	
	<div id="container">
				
			<input type="button" value="Add Role"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"
				/>
			 <div class="table-responsive">          
			<table class="table">
			    <thead>
				<tr>
					<th>Name</th>	
				</tr>
				</thead>
				<tbody>
					<c:forEach var="tempRole" items="${roles}">
					<c:url var="updateLink" value="/role/showFormForUpdate">
						<c:param name="roleId" value="${tempRole.id }"/>
					</c:url>
					<c:url var="deleteLink" value="/role/delete">
						<c:param name="roleId" value="${tempRole.id }"/>
					</c:url>
					
					<tr>
						<td>${tempRole.name}</td>
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete this role?'))) return false">Delete</a>
						</td>
					</tr>
					</c:forEach>
					</tbody>
			</table>
		</div>
	</div>

</body>
</html>