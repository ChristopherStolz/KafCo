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
		<div class = "row">
		<div class = "col-sm-1"></div>
		<div class = "col-sm-10 well">
			<form action ="updateUser" role = "form" method = "POST">
			<div class = "col-sm-1"></div>
			<div class = "col-sm-4">
				<div class = "form-group col-sm-6">
				<label class = "control-label" for = "first">First Name </label>
				<input type = "text" class = "form-control toggle" name = "first" id = "first" value ="${user.firstName}" readonly>
				</div>
				<div class ="form-group col-sm-6">
				<label class = "control-label" for = "last">Last Name </label>
				<input type = "text" class = "form-control toggle" name = "last" id = "last" value ="${user.lastName}" readonly>				
				</div>
				<div class = "form-group col-sm-12">
				<label class = "control-label" for = "email">Email </label>
				<input type ="email" class = "form-control toggle" name = "email" id = "email" value ="${user.email}" readonly>
				</div>
				<div class = "row text-center">
					<button id = "submit" class ="btn btn-primary btn-hidden" hidden="hidden"> submit </button>
					&nbsp&nbsp <a id = "cancel" class = "update" id = href = "#">cancel</a>
				</div>
				</form>
			</div>
			<div class = "col-sm-1"></div>
			<div class = "col-sm-4">
				<div class = "row">
					<a id = "updatePassword" class = "updatePassword" href="#">Change Password</a>
					<form name = "passwordForm" id = "passwordForm" action = "updatePassword" role = "form" method = "POST">
					<div class = "form-group">
					<div class = "col-sm-6">
					<label class = "control-label pwd" for = "current-password">Current Password</label>
					</div>
					<div class = "col-sm-6">
					<input class = "pwd" type = "password" class = "hidden" name = "current-password" id = "current-password" required>
					</div>
					<div class = "col-sm-6">
					<label class = "control-label pwd" for = "password">New Password</label>
					</div>
					<div class = "col-sm-6">
					<input class = "pwd" type = "password" class = "hidden" name = "password" id = "password" required>
					</div>
					<div class = "col-sm-6">
					<label class = "control-label pwd" for = "password-match">Confirm Password</label>
					</div>
					<div class = "col-sm-6">
					<input class = "pwd" type = "password" class = "hidden" name = "password-match" id = "password-match" required>
					</div>
					<div class = "row text-center">
					<button id = "submitPassword" class = "btn btn-primary btn-pwd pwd">submit </button>
					<a class = "pwd updatePassword" href = "#">cancel</a>
					</div>
					</div>
					</form>
				</div>
				<div class = "row">
					<a id = "update" class = "update" href="#">Update Info</a>
				</div>
			</div>

			</div>
		</div>
  </div>
  <script>
	$(document).ready(function(){
		$('.btn-hidden').hide();
		$('#cancel').hide();
		$('.hidden').hide();
		$('.pwd').hide();
	});
	$(".update").click(function() {
		var ro = $('.toggle').prop('readonly');
		$('#submit').toggle();
		$('.toggle').prop('readonly', !ro).focus();
		$('.update').toggle();
		$('#updatePassword').toggle();
	});
	$(".updatePassword").click(function() {
		$('.pwd').toggle();
		$('#updatePassword').toggle();
		$('#update').toggle();
	});
/* 	$("#passwordForm").validate({
		rules:{
			password: 'required',
			password-match: {
				equalTo: '#password'
			}
		}
	}); */
  </script>
</body>
</html>