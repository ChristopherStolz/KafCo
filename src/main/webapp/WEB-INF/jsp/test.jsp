<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body>
<div class = "container-fluid">
  <jsp:include page = "header.jsp" />
  <div class = "col-sm-1"></div>
  <div class = "col-sm-10 well">
	<h1 class = "text-center"><c:out value="${result.meterName}" default = "fuck"/></h1>
	<c:forEach items = "${result.data}" var = "current">
		<c:out value = "${current}" />
	</c:forEach>
  </div>
</body>
</html>