<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1">
<title>Login</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<style>
html, body, .container-table{
height:100%;
}	

.container-table {
	display: table;

}
.vertical-center-row{
	display: table-cell;
	vertical-align: middle;

}
input:hover {
	background-color: #FFFF00;
}

.abc:hover {
	background-color: #FFFF00
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$(window).resize(function(){
		var w= window.innerWidth
		|| document.documentElement.clientWidth
		|| document.body.clientWidth;
		if(w<450){
			$("label").css("font-size","25px");
		}else{
			
			$("label").css("font-size","14px");
		}
	});
	
});

</script>
<body>
	<div class="container container-table">
		<div class="row vertical-center-row">
			<form class="form-horizontal col-sm-offset-4 col-sm-4 " role="form"
				action="login" method="post">
				<div class="form-group">
					<label class="control-label col-sm-4 col-xs-4">Username:</label>
					<div class="col-sm-8 col-xs-8">
						<input type="text" class="form-control" placeholder="Username"
							name="username">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4 col-xs-4" for="pwd">Password:</label>
					<div class="col-sm-8 col-xs-8">
						<input type="password" class="form-control"
							placeholder="Enter password" name="password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-8 col-xs-offset-4 col-xs-8">
						<button type="submit" class="btn btn-default abc">Login</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>