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
	var classPerson = localStorage['classPerson'];
	var project_Test;
		$(document).ready(function() {
			$("#showQuestion").click(function() {	
				project_Test = "All";
				$.ajax({
					dataType : 'json',
					type : 'GET',
					url : 'http://localhost:8080/com.vogella.jersey.first/rest/question/allQuestion',
					success : function(data) {
						var table = "<div>";
						number = 0;
						for ( var i in data) {
							number += 1;
							table+= "<p id="+number+" value="+data[i].trueAnswer+" name="+data[i].id+"><b>Question " + data[i].id + "</b>: "+data[i].content+ "</p>";
							/* table+= "<p><b>Type:</b> " + data[i].type +"</p>"; */
							table+= "<p><b>Answer:</b></p>";
							table+="</p><input type=\"radio\" name="+data[i].id+" value=\"answerA\">";
							table+= "Answer A: " + data[i].answerA + "</p>";
							table+="</p><input type=\"radio\" name="+data[i].id+" value=\"answerB\">";
							table+= "Answer B: " + data[i].answerB + "</p>";
							table+="</p><input type=\"radio\" name="+data[i].id+" value=\"answerC\">";
							table+= "Answer C: " + data[i].answerC + "</p>";
							table+="</p><input type=\"radio\" name="+data[i].id+" value=\"answerD\">";
							table+= "Answer D: " + data[i].answerD + "</p>";
											}
							table += "<button class=\"btn btn-warning\" value="
								 	+ number
									+ " onclick=\"finish(this)\" name=\"Submit\">Submit</button>";
							table += "</div>";
							$('#demo').html(table);						
								}
						});
				});
			});

		function change(but){
				var type = but.name;
				project_Test = type;
				$.ajax({
					dataType : 'json',
					type : 'GET',
					url : 'http://localhost:8080/com.vogella.jersey.first/rest/question/allQuestion',
					success : function(data) {
						var table = "<div>";
						number = 0;
						for ( var i in data) {
							if (data[i].type == type){
								number += 1;
								table+= "<p id="+number+" value="+data[i].trueAnswer+" name="+data[i].id+"><b>Question " + data[i].id + "</b>: "+data[i].content+ "</p>";
								/* table+= "<p><b>Type:</b> " + data[i].type +"</p>"; */
								table+= "<p><b>Answer:</b></p>";
								table+="</p><input type=\"radio\" name="+data[i].id+" value=\"answerA\">";
								table+= "Answer A: " + data[i].answerA + "</p>";
								table+="</p><input type=\"radio\" name="+data[i].id+" value=\"answerB\">";
								table+= "Answer B: " + data[i].answerB + "</p>";
								table+="</p><input type=\"radio\" name="+data[i].id+" value=\"answerC\">";
								table+= "Answer C: " + data[i].answerC + "</p>";
								table+="</p><input type=\"radio\" name="+data[i].id+" value=\"answerD\">";
								table+= "Answer D: " + data[i].answerD + "</p>";
											}}
								table += "<button class=\"btn btn-warning\" value="
						 				+ number
										+ " onclick=\"finish(this)\" name=\"Submit\">Submit</button>";
								table += "</div>";
								$('#demo').html(table);						
								}
						});
		}
		var number;
		var count;
		function finish(but){
			count = 0;
			for(var i = 1;i<=number;i++){
				var	name = $('p#'+i+'').attr('name');
				var anwser = $("input[name="+name+"]:checked").map(function () {return this.value;}).get();
				var correct = $('p#'+i+'').attr('value');
				if(anwser == correct){
					count += 1;
				}
				
			}
			alert("number true anwser:"+count+"/"+number);
			$.ajax({
				dataType : 'json',
				type : 'GET',
				url : 'http://localhost:8080/com.vogella.jersey.first/rest/question/updateScore/' + fullname+'/'+classPerson + '/'+project_Test+'/' + count + '/' + number,
				success : function(data) {
					alert("Them diem thanh cong vao du lieu");
				},
				error : function(error){
					alert("That bai");
				}
		});			
		}
		function perResult(but){
			window.location = 'http://localhost:8080/com.client/perResult.jsp';
		}	
		function pageResult(but){
			window.location = 'http://localhost:8080/com.client/viewPersonResult.jsp';
		}
	</script>

	<div class="container">
		<div class="jumbotron">
			<h1>Welcome to TMA Test</h1>
		</div>
		<button id="showQuestion" type="button" class="btn btn-success">All Question</button>
		<button id="showMathQuestion" type="button" class="btn btn-info" name="Math" onclick="change(this)">Math Question</button>
		<button id="showPhysicsQuestion" type="button" class="btn btn-info" name="Physics" onclick="change(this)">Physics Question</button>
		<button id="showChemistryQuestion" type="button" class="btn btn-info" name="Chemistry" onclick="change(this)">Chemistry Question</button>
		<button id="finishTest" type="button" class="btn btn-danger" name="perResult" onclick="perResult(this)">Personal Result</button>
		<button id="pageResult" type="button" class="btn btn-danger" name="pageResult" onclick="pageResult(this)">All Person's Result</button>
		<p></p>
		<table id="demo" class="table table-bordered "></table>
		
	</div>

</body>
</html>