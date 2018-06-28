<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

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
		$(document)
				.ready(
						function() {
							$("#login")
									.click(
											function() {
												var username = $("#username")
														.val();
												var userpassword = $(
														"#password").val();
												$
														.ajax({
															dataType : 'json',
															type : 'GET',
															url : 'http://localhost:8080/com.vogella.jersey.first/rest/login/userlogin/'
																	+ username
																	+ "/"
																	+ userpassword,
															success : function(
																	data) {
																localStorage['fullname'] = data.fullname;
																localStorage['classPerson'] = data.classPerson;
																window.location = 'http://localhost:8080/com.client/viewQuestion.jsp';
															},
															error : function(
																	error) {

															}
														});
											});
						});
	</script>

	<div class="container">
		<div class="jumbotron">
			<h1>Welcome to TMA Test</h1>

		</div>
		<div>

			<form class="col-sm-offset-4 col-sm-4" role="form" method="post">
				<div class="form-group">
					<label class="control-label col-sm-4">Username: </label> <input
						id="username" type="text" class="form-control"
						placeholder="Enter your name" name="username">
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4">Password: </label> <input
						id="password" type="password" class="form-control"
						placeholder="Enter your password" name="password">
				</div>
				<div class="form-group">
					<label><input type="checkbox"> Remember me</label>
				</div>
				<div class="form-group">
					<div>
						<button type="button" class="btn btn-default" id="login">Login</button>
						<a href="http://localhost:8080/com.client/register.jsp"><button type="button" class="btn btn-default">
						Register</button></a>
						
						<!-- <button type="button" class="btn btn-default" data-toggle="modal"
							data-target="#modalRegister">Register</button> -->
						<!-- Modal Register -->
						<!-- <div class="modal fade" id="modalRegister" role="dialog">
							Modal Register Content
							<div class="modal-dialog">
								<div class="modal-register-content">
									<div class="modal-header">
										<h4>Register New User</h4>
									</div>
									<div class="modal-body">
										<button>Submit</button>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div> -->
					</div>
				</div>
			</form>

		</div>
	</div>
</body>
</html>