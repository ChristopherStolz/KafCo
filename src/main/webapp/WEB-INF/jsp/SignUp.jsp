<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body>
<div class = "container-fluid">
  <jsp:include page = "header.jsp" />
  	<div class = "row">
		<div class = "col-sm-1"></div>
		<div class = "col-sm-10">
			<h1 class = "text-center">Activate Account</h1>
		</div>
	</div>	
  <div row>
	<div class = "col-sm-2">
	</div>
	<div class = "col-sm-8 well">
		<div class = "form" role = "form" method = "post" action = "activate" accept-charset="UTF-8" id = "activate">
			<div class = "row">
			<div class = "col-sm-1">
			</div>
				<div class = "col-sm-5">
					<div class = "form-group">
						<label class = "control-label" for = "first"> First Name </label>
						<input type = "text" class = "form-control" id = "first" placeholder = "First" required readonly>
					</div>
				</div>
				<div class = "col-sm-5">
					<div class = "form-group">
						<label class = "control-label" for = "last"> Last Name </label>
						<input type = "text" class = "form-control" id = "last" placeholder = "Last" required readonly>
					</div>
				</div>
			</div>
			<div class = "row">
				<div class = "col-sm-1"></div>
				<div class = "col-sm-10">
					<div class = "form-group">
					<label class = "control-label" for = "email"> Email Address </label>
					<input type = "email" class = "form-control" id = "last" placeholder = "Email" required readonly>
					</div>
				</div>
			</div>
			<div class = "row">
				<div class = "col-sm-1"></div>
				<div class = "col-sm-5">
					<div class = "form-group">
						<label class = "control-label" for = "password"> Password </label>
						<input type = "password" class = "form-control" id = "password" placeholder = "Password" required>
					</div>
				</div>
				<div class = "col-sm-5">
										<div class = "form-group">
						<label class = "control-label" for = "password2"> Confirm Password </label>
						<input type = "password" class = "form-control" id = "password2" placeholder = "Password" required>
					</div>
				</div>
			</div>
			<div class = "row">
				<div class = "col-sm-3"></div>
				<div class = "col-sm-5">
					<div class = "form-group">
						<button type = "submit" class = "btn btn-primary btn-block">Submit</button>
					</div>
				</div>
			</div>
		</div>
	</div>
  </div>
  </div>
</body>
</html>