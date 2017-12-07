<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
</head>
	<body>
		<div class = "container-fluid">
		<jsp:include page = "header.jsp" />
		<div class = "col-sm-1"></div>
		<div class = "col-sm-10">
		<c:if test="${success != \"\"}">
		<div class="alert alert-success" role="alert">
			This is a success alert—check it out!
		</div>
		</c:if>
		<c:if test="${error != \"\"}">
		<div class="alert alert-danger" role="alert">
			This is a danger alert—check it out!
		</div>
		</c:if>
		</div>
	</body>
</html>	
