<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KafCo Dashboard</title>
</head>
<body>
  <nav class = "navbar navbar-inverse">
    <div class = "container-fluid">
    <a class = "navbar-brand" href= "#">KafCo</a>
  	<ul class = "nav navbar-nav">
  		<li><a href="#">Home</a></li>
      <li><a href="#">Contact us</a></li>
      <c:if test="${sessionScope.user != null}">
        <li><a href = "#">View Reports</a></li>
      </c:if>
    </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href = "#"> Sign Up </a></li>
        <li><a href =" #"> Login </a></li>
      </ul>
    </div>
  </nav>
</body>
</html>
