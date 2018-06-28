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
	var fullname = localStorage['fullname'];
		$(document).ready(function() {
			$("#showQuestion").click(function() {
				$.ajax({
					dataType : 'json',
					type : 'GET',
					url : 'http://localhost:8080/com.vogella.jersey.first/rest/person/personResult',
					success : function(data) {
						var table = "<tr><th>ID</th>"
						+ "</th><th>Name</th>"
						+ "</th><th>Class</th>"
						+ "</th><th>Project Test</th>"
						+ "</th><th>Number of Question</th>"
						+ "</th><th>True Answer</th>"
						+ "</tr>";

						for ( var i in data) {
							if( data[i].name == fullname){
							table += "<tr><td>"
									+ data[i].id
									+ "</td><td>"
									+ data[i].name
									+ "</td><td>"
									+ data[i].classPerson
									+ "</td><td>"
									+ data[i].type_projectTest
									+ "</td><td>"
									+ data[i].num_question
									+ "</td><td>"
									+ data[i].score
									+ "</td></tr>";
											}}
									$('#demo').html(table);						
								}
						});
				});
			});
		function change(but){
		
			$.ajax({
				dataType : 'json',
				type : 'GET',
				url : 'http://localhost:8080/com.vogella.jersey.first/rest/person/personResult',
				success : function(data) {
					var table = "<tr><th>ID</th>"
					+ "</th><th>Name</th>"
					+ "</th><th>Class</th>"
					+ "</th><th>Project Test</th>"
					+ "</th><th>Number of Question</th>"
					+ "</th><th>Score</th>"
					+ "</th><th>Result</th>"
					+ "</tr>";

					for ( var i in data) {
						if( data[i].name == fullname){
						table += "<tr><td>"
								+ data[i].id
								+ "</td><td>"
								+ data[i].name
								+ "</td><td>"
								+ data[i].classPerson
								+ "</td><td>"
								+ data[i].type_projectTest
								+ "</td><td>"
								+ data[i].num_question
								+ "</td><td>"
								+ data[i].score
								+ "</td><td>";
								if( data[i].score/data[i].num_question < 0.5){
									table += "Failed"+"</td>";
								} else {
									table += "Passed"+"</td>";
								}
								table += "</tr>";
										}}

								$('#demo').html(table);						
							}
					});
		}
		
		
	</script>

	<div class="container">
		<div class="jumbotron">
			<h1>Person Result</h1>

		</div>
		<button id="showQuestion" type="button" class="btn btn-success">Show Person's Result</button>
		<button id="showPassFail" type="button" class="btn btn-info" name="showPassFail" onclick="change(this)">Show Pass/Fail</button>
		<p></p>
		<table id="demo" class="table table-bordered "></table>
	</div>

</body>
</html>