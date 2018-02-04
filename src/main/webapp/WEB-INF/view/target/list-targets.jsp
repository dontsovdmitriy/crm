<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@include file="/WEB-INF/view/navbar.jsp"%>
<html>

<head>
	<title>List Targets</title>
</head>

<body>
	
	<div id="container">
				
			<input type="button" value="Add Target"
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
					<c:forEach var="tempTarget" items="${targets}">
					<c:url var="updateLink" value="/target/showFormForUpdate">
						<c:param name="targetId" value="${tempTarget.id }"/>
					</c:url>
					<c:url var="deleteLink" value="/target/delete">
						<c:param name="targetId" value="${tempTarget.id }"/>
					</c:url>
					
					<tr>
						<td>${tempTarget.name}</td>
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete this target?'))) return false">Delete</a>
						</td>
					</tr>
					</c:forEach>
					</tbody>
			</table>
		</div>
	</div>

</body>
</html>