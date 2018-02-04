<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html >
<head>
  <title>Title</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
  <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
   <%-- <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> --%>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand">Web site name</a>
    </div>
    <div class="collapse navbar-collapse myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${pageContext.request.contextPath}/user/welcome">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Entity<span class="caret"></span></a>
          <ul class="dropdown-menu">
       		<li><a href="${pageContext.request.contextPath}/action/list">Action</a></li>
    		<li><a href="${pageContext.request.contextPath}/client/list">Client</a></li>
        	<li><a href="${pageContext.request.contextPath}/contactPerson/list">Contact Person</a></li>
        	<li><a href="${pageContext.request.contextPath}/target/list">Target</a></li>
        	<!--  	<sec:authorize access="hasRole('ROLE_ADMIN')"> -->
		        <!--	</sec:authorize> -->
        	<li><a href="${pageContext.request.contextPath}/user/list">User</a></li>
        	<li><a href="${pageContext.request.contextPath}/role/list">Role</a></li>   
        	     	
          </ul>
        </li> 
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Report<span class="caret"></span></a>
          <ul class="dropdown-menu">
             <li><a href="${pageContext.request.contextPath}/action/showFormForClientReport" >Client actions</a></li>
            <li><a href="${pageContext.request.contextPath}/contactPerson/showFormForClientContactReport">Client contacts</a></li>
            <li><a href="${pageContext.request.contextPath}/client/showFormForUserClientsReport">User clients</a></li>
            <li><a href="${pageContext.request.contextPath}/user/showUserRoles">User roles</a></li>
          </ul>
        </li>
        </ul>
         <ul class="nav navbar-nav navbar-right"> 	      
        
         	<c:if test="${pageContext.request.userPrincipal.name != null}">
       			<form id="logoutForm" method="POST" action="${contextPath}/logout">
           		 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        		</form>

         		<h4><a onclick="document.forms['logoutForm'].submit()"><span class="glyphicon glyphicon-log-out"></span>Logout</a></h4>
       
    		</c:if>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>