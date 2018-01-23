<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<!-- <script type="text/javascript">
	$(document).ready(function() {
		
		// Doc du lieu
		$.ajax({
			type:'GET',
			url:'http://localhost:8080/com.vogella.jersey.first/rest/user/allUser',
			data:{},
			success:function(result) {					
			}
		});		
	});
</script> -->
	
<style>
h1 {
	text-align: center;
	font-family: monospace;
	font-weight: bold;
}
</style>
</head>
<body>

	<div class="container">
		<div class="row vertical-center-row">
			<div class="jumbotron">
				<h1>Welcome to TMA HR Manager</h1>
			</div>
			<form class="form-horizontal col-sm-offset-4 col-sm-4 " role="form"
				action="../com.client/rest/login" method="post">
				<div class="form-group">
					<label for="name">Name:</label> <input type="text"
						class="form-control" id="name" placeholder="Enter your name"
						name="name">
				</div>
				<div class="form-group">
					<label for="password">Password:</label> <input type="password"
						class="form-control" id="password" placeholder="Enter your password"
						name="password">
				</div>
				<div class="checkbox">
					<label><input type="checkbox"> Remember me</label>
					<p></p>
				</div>
				<button type="submit" class="btn btn-primary" id="login">Login</button>
			</form>

		</div>
	</div>

</body>
</html>
