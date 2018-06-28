<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create application</title>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
h1 {
	text-align: center;
	font-family: monospace;
	font-weight: bold;
}
</style>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#register").click(function() {
				var username = $("#username").val();				
				var userpassword = $("#password").val();
				var fullname = $("#fullname").val();
				var classPerson = $("#classPerson").val();	
				$.ajax({
					dataType : 'json',
					type : 'GET',
					url : 'http://localhost:8080/com.vogella.jersey.first/rest/user/registerUser/'
						+ username
						+ "/"
						+ userpassword
						+ "/"
						+ fullname
						+ "/"
						+ classPerson,
					success : function(data) {
						alert("Register success");
						window.location = 'http://localhost:8080/com.client/index.jsp';
								},
					error: function(error){
						alert("Account already exists");
						window.location = 'http://localhost:8080/com.client/register.jsp';
					}
});
});
});
		
	</script>

	<div class="container">
		<div class="jumbotron">
			<h1>Register New Account</h1>
		</div>
		<form class="col-sm-6" role="form" method="post">
			<div class="form-group">
				<label class="control-label col-sm-6">Username: </label> <input
					id="username" type="text" class="form-control"
					placeholder="Enter your name" name="username" required="required">
			</div>
			<div class="form-group">
				<label class="control-label col-sm-6">Password: </label> <input
					id="password" type="password" class="form-control"
					placeholder="Enter your password" name="password" required="required">
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-6">Fullname: </label> <input
					id="fullname" type="text" class="form-control"
					placeholder="Enter your fullname" name="fullname" required="required">
			</div>
			<div class="form-group">
				<label class="control-label col-sm-6">Class: </label> <input
					id="classPerson" type="text" class="form-control"
					placeholder="Enter your class" name="classPerson" required="required">
			</div>
			
			<div class="form-group">
					<button type="button" class="btn btn-info" id="register">Register</button>
			</div>
		</form>
	</div>

</body>
</html>