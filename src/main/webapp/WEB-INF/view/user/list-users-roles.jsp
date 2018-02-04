<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/view/navbar.jsp"%>

<!DOCTYPE html>

<html>

<head>
	<title>List Users</title>
</head>

<body>
		
		<div id="container">
			
			<c:url var="addLink" value="/user/addRoleForUser">
							<c:param name ="userId" value="${userId}"/>							
			</c:url>
			
			<a href="${addLink}"
									onclick="if(!(confirm('Are you sure you want to Add new role?'))) return false">Add Role</a>
											
			 	<div class="table-responsive">          
				<table class="table">
			  	  <thead>
					<tr>
						<th>Role</th>						
					</tr>
					</thead>
					<tbody>
						<c:forEach var="tempRole" items="${userRoles}">
						<c:url var="deleteLink" value="/user/deleteRole">
							<c:param name ="roleId" value="${tempRole.id }"/>
							<c:param name ="userId" value="${userId}"/>
							
						</c:url>
						<tr>
							<td>${tempRole.name}</td>						
							<td>
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