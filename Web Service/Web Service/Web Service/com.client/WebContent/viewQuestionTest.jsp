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
			$("#showQuestion").click(function() {
				$.ajax({
					dataType : 'json',
					type : 'GET',
					url : 'http://localhost:8080/com.vogella.jersey.first/rest/questionTest/allQuestionTest',
					success : function(data) {
						alert("aaa");
						var table = "<tr><th>ID</th>"
						+ "</th><th>Content</th>"
						+ "</th><th>Question Type</th>"
						+ "</th></tr>";

						for ( var i in data) {
							table += "<tr><td>"
									+ data[i].id
									+ "</td><td>"
									+ data[i].content
									+ "</td><td>"
									+ data[i].type
									+ "</td><tr>"
											}

									$('#demo').html(table);						
								}
						});
				});
			});

		
		function change(but){
				var type = but.name;
				$.ajax({
					dataType : 'json',
					type : 'GET',
					url : 'http://localhost:8080/com.vogella.jersey.first/rest/question/allQuestion',
					success : function(data) {
						var table = "<tr><th>ID</th>"
						+ "</th><th>Content</th>"
						+ "</th><th>Question Type</th>"
						+ "</th></tr>";

						for ( var i in data) {
							if (data[i].type == type){
							table += "<tr><td>"
									+ data[i].id
									+ "</td><td>"
									+ data[i].content
									+ "</td><td>"
									+ data[i].type
									+ "</td><tr>";
							}
						}

									$('#demo').html(table);						
								}
						});
		}
	</script>

	<div class="container">
		<div class="jumbotron">
			<h1>Welcome to Question Bank</h1>

		</div>
		<button id="showQuestion" type="button" class="btn btn-success">Show All Question</button>
		<button id="showMathQuestion" type="button" class="btn btn-info" name="Math" onclick="change(this)">Math Question</button>
		<button id="showPhysicsQuestion" type="button" class="btn btn-info" name="Physics" onclick="change(this)">Physics Question</button>
		<button id="showChemistryQuestion" type="button" class="btn btn-info" name="Chemistry" onclick="change(this)">Chemistry Question</button>
		<p></p>
		<table id="demo" class="table table-bordered "></table>
	</div>

</body>
</html>