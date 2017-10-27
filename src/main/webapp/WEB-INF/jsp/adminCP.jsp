<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body>
<div class = "container-fluid">
  <jsp:include page = "header.jsp" />
  <div class = "row">
	<h1 class = "text-center">Admin Control Panel</h1>
  </div>
  <div class = "row">
	<div class = "col-sm-1"></div>
	<div class = "col-sm-10 well">
		<button class = "btn btn-primary btn-block" data-toggle="modal" data-target="#addModal">
			Add user
		</button>
		<form class = "form" role = "form" method = "post" action = "search" accept-charset="UTF-8" id = "userSearch">
			<div class = "row">
				<div class = "col-sm-1"></div>
				<div class = "col-sm-8">
					<div class = "input-group">
						<span class = "input-group-btn">
							<button class = "btn btn-default" type = "button"><i class = "glyphicon glyphicon-search"></i></button>
						</span>
						<label class = "sr-only" for="userData"> Search Users </label>
						<input type = "text" class = "form-control" id = "userData" placeholder = "Search Users" required>
					</div>
				</div>
			</div>
		</form>
	</div>
	</div>
  </div>
</body>
</html>