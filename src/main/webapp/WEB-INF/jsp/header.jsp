<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KafCo Dashboard</title>
</head>
<body>
  <nav class = "navbar navbar-inverse">
    <div class = "container-fluid">
    <a class = "navbar-brand" href= "/about">KafCo</a>
  	<ul class = "nav navbar-nav">
  		<li><a href="/welcome">Home</a></li>
      <li><a href="/contact">Contact us</a></li>
      <c:if test="${sessionScope.user != null}">
        <li><a href = "#">View Reports</a></li>
      </c:if>
    </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href = "/signup"> Sign Up </a></li>
		<li class = "dropdown">
			<a href = "#" class = "dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class = "caret"></span></a>
			<ul id = "login-dp" class = "dropdown-menu">
			<div class = "col-xs-12">
				<form role = "form" method = "POST" action = "doLogin" accept-charset="UTF-8" id = "login-nav">
					<div class = "form-group">
						<label class="sr-only" for="inputEmail"> Email Address </label>
						<input name = "email" type = "email" class = "form-control" id = "inputEmail" placeholder = "Email Address" required>
					</div>
					<div class = "form-group">
						<label class ="sr-only" for="inputPassword"> Password </label>
						<input name = "password" type = "password" class = "form-control" id = "inputPassword" placeholder = "Password" required>
					</div>
					<div class = "form-group">
						<button type="submit" class = "btn btn-primary btn-block">Sign In</button>
					</div>
					<div class ="checkbox">
						<label>
						<input type="checkbox"> keep me logged in
						</label>
					</div>
				</form>
			</div>
			</ul>
        </li>
      </ul>
    </div>
  </nav>
</body>
</html>
