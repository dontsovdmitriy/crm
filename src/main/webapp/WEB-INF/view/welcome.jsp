<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/view/navbar.jsp"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome page</title>
</head>
<body>
<div class="container">
	
	<span>Dear,<strong>${userFullName}</strong>, Welcome to CRM system.</span> 
</div>
</body>
</html>