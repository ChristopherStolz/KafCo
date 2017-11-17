<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body>
<div class = "container-fluid">
  <jsp:include page = "header.jsp" />
	<div class = "row">
    <div class = "col-sm-1"></div>
		<div class = "col-sm-10 well">
			<h1 class = "text-center">Welcome</h1>
			<h2 class = "text-center">${user.email}</h2>
		</div>
	</div>
</div>
</body>
</html>
