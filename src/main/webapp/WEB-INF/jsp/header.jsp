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
  		<li><a href="/welcome"><span class = "glyphicon glyphicon-home"></span></a></li>
      <li><a href="/contact"><span class = "glyphicon glyphicon-envelope"></span> Contact us</a></li>
	</ul>
      <c:if test="${sessionScope.user.email != null}">
	  <ul class = "nav navbar-nav navbar-right">
        <li><a href = "/results"><span class="glyphicon glyphicon-folder-open"> </span>&nbsp View Reports</a></li>
		<li><a href = "/usercp"><span class="glyphicon glyphicon-user"> </span> User Control Panel</a></li>
		<c:if test = "${sessionScope.user.admin}"><li><a href = "/admincp">
			<span class="glyphicon glyphicon-star-empty"></span>
			Admin Control Panel</a></li></c:if>
		<li><a href = "/doLogout"><span class="glyphicon glyphicon-log-out"> </span></a></li>
		</ul>
      </c:if>
	<c:if test="${sessionScope.user.email == null}">
      <ul class="nav navbar-nav navbar-right">
        <li><a href = "/signup"> Sign Up </a></li>
		<li class = "dropdown">
			<a href = "#" class = "dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class = "caret"></span></a>
			<ul id = "login-dp" class = "dropdown-menu">
			<div class = "col-xs-12">
				<form action = "doLogin" method = "POST"  role = "form" accept-charset="UTF-8" id = "login-nav">
					<div class = "form-group">
						<label class="sr-only" for="inputEmail"> Email Address </label>
						<input type = "email" class = "form-control" name = "email" id = "email" placeholder = "Email Address" required>
					</div>
					<div class = "form-group">
						<label class ="sr-only" for="inputPassword"> Password </label>
						<input type = "password" class = "form-control" name = "password" id = "password" placeholder = "Password" required>
					</div>
					<div class = "form-group">
						<button type="submit" class = "btn btn-primary btn-block">Sign In</button>
					</div>
					<div class ="checkbox">
						<label>
						<input type="checkbox" name = "keepLogged" id = "keepLogged"> keep me logged in
						</label>
					</div>
				</form>
			</div>
			</ul>
        </li>
      </ul>
	</c:if>
    </div>
  </nav>
</body>
</html>
