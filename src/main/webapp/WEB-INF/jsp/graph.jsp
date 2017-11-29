<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>
	<body>
		<div class = "container-fluid">
		<jsp:include page = "header.jsp" />
		<div class = "row">
		<c:out value = "${data}" default = "oops" />
		
		<c:forEach items = "${data}" var = "current">
			<c:out value = "${current}" />
		</c:forEach>
		</div>
		<div class = "col-sm-1"></div>
		<div class = "col-sm-10 well">
		<canvas id = "myChart"></canvas></div>
		
		<script>
			var ctx = document.getElementById("myChart").getContext('2d');
			new Chart(ctx, {
				type: 'line',
				data: {
					//Time (milliseconds, calculated from offset)
					labels: [1,2,3,4,5,4,3,2,1],
					datasets:[{
						//Actual data from the object
						data:[
						<c:forEach items = "${result.data}" var = "current">
							<c:out value = "${current}" default = "1" />,
						</c:forEach>
						
						],
						label: "Test",
						borderColor: "#3e95cd",
						fill: false
					}]
				},
				options: {
					title:{
						display:true,
						//
						text: 'display something please'
					}
				}
			});
		</script>
	</body>
</html>