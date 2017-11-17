<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body>
<div class = "container-fluid">
  <jsp:include page = "header.jsp" />
  <div class = "col-xs-1"></div>
  			<div class = "well col-xs-10">
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
</div>
</body>
</html>