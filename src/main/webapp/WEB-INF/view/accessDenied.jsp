<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/view/navbar.jsp"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>AccessDenied page</title>
</head>
<body>
<div class="container">
	
	<span>Dear <strong>${userFullName}</strong>, You are not authorized to access this page.</span> 
</div>
</body>
</html>