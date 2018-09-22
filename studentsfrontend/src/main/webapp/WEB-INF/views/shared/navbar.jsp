<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

 
 <c:set var="contextRoot" value="${pageContext.request.contextPath}"/> 
 
<spring:url var="images" value="/resources/images"/>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<div class="jumbotron">
  <div class="container text-center">
    <h1>UnBox Wish</h1>      
  </div>
</div>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
		<li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Shop By Category
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${contextRoot}/getProduct/">Home & Furniture</a></li>
          <li><a href="${contextRoot}/getProduct/">Electronics</a></li>
          <li><a href="${contextRoot}/getProduct/Clutches">Women's Fashion</a></li>
		  <li><a href="${contextRoot}/getProduct/Hanbags">Men Fashion</a></li>
		  <li><a href="${contextRoot}/getProduct/">Laptop</a></li>
		  <li><a href="${contextRoot}/getProduct/">Moblie Acceseriess</a></li>
        </ul>
      </li>
        <li><a href="getStore">Stores</a></li>
		<li><a href="getCustomerService">Customer Service</a></li>
        <li><a href="getContact">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <sec:authorize access="isAnonymous()">
		<li><a href="${contextRoot}/admin/adminpage">Admin</a></li>

		 <li><a href="${contextRoot}/register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
		 
		 </sec:authorize>
		 
		 <sec:authorize access="isAuthenticated()">
	<li class="dropdown">
		<a href="javascript:void(0)"
			class="btn btn-default dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
				Welcome : <c:out value="${sessionScope.userName}"/>
			</a>
		<li class="divider" role="seperator"></li>
		<li>
			<a href="${contextRoot}/perform-logout"><span class="glyphicon glyphicon-log-out"></span> 	Logout</a>
		</li>
	</sec:authorize>
      </ul>
    </div>
  </div>
</nav>













	
