<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<body>
		<div class = "container-fluid">
		<jsp:include page = "header.jsp" />
		<table class = "table">
			<TH scope = "col"> Date </th>
			<TH scope = "col"> Meter name </th>
			<c:forEach items = "${results}" var = "current">
				<tr>
					<td><a href = "graph?${current.id}" <c:out value = "{$current.date}"></td>
					<td><c:out value = "{$current.meterName}"></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>