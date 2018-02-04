<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/view/navbar.jsp"%>

<!DOCTYPE html>

<html>

<head>
	<title>List Clients</title>
</head>

<body>
	<div id="container">
				
			<input type="button" value="Add Contact Person"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"
				/>
			<div class="table-responsive">          
				
			<table class="table">
				<thead>
				<tr>
					<th>Surname</th>	
					<th>Name</th>	
					<th>Second name</th>	
					<th>Phone number</th>	
					<th>Client</th>																									
				</tr>
				</thead>
				
					<c:forEach var="tempContactPerson" items="${contactPersons}">
					<c:url var="updateLink" value="/contactPerson/showFormForUpdate">
						<c:param name="contactPersonId" value="${tempContactPerson.id }"/>
					</c:url>
					<c:url var="deleteLink" value="/contactPerson/delete">
						<c:param name="contactPersonId" value="${tempContactPerson.id }"/>
					</c:url>
					
					<tr>
						<td>${tempContactPerson.surname}</td>
						<td>${tempContactPerson.name}</td>
						<td>${tempContactPerson.secondName}</td>	
						<td>${tempContactPerson.phoneNumber}</td>	
						<td>${tempContactPerson.client.name}</td>											
																
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete this contact person?'))) return false">Delete</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>	
			</table>
		</div>
	</div>

</body>
</html>