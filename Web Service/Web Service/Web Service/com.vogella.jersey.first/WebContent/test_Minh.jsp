
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Manager</title>
<%@ page import="com.vogella.jersey.first.User"%>
<%@ page import="com.vogella.jersey.first.Method"%>
<%@ page import="java.util.List"%>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1 align = "center" style="color:purple;" >HR Manager</h1>
			
		</div>
		<%
			User user = (User) session.getAttribute("user");
			out.print("<p align=\"right\">Hi " + user.getName() + " .You are " + user.getType_account() + "[<a href=\"http://localhost:8080/Company/index.html\">logout</a>]</p>");
		%>
		<div align="center">
			<button type="button" class="btn btn-info" onclick="loadUser()">User
				manager</button>
			<button type="button" class="btn btn-info" onclick="loadSalary()">Salary
				manager</button>
		</div>
		<br> <br>
		<div class="col-sm-3"></div><div class="col-sm-6">
			<table id="demo" class="table table-bordered "></table>
		</div>
 
		<script>
			function loadUser() {
				var xhttp = new XMLHttpRequest();
				xhttp.onreadystatechange = function() {
					if (xhttp.readyState == 4 && xhttp.status == 200) {
						myFunction(xhttp);
					}
				}
				xhttp.open("GET",
						"http://localhost:8080/Company/rest/manager/showuser",
						true);
				xhttp.send();
			}
			function myFunction(xml) {
				var i;
				var xmlDoc = xml.responseXML;
				var table = "<tr><th>User_id</th><th>Full name</th><th>Email</th><th>Username</th><th>position</th></tr>";
				var x = xmlDoc.getElementsByTagName("user");
				for (i = 0; i < x.length; i++) {
					table += "<tr><td>"
							+ x[i].getElementsByTagName("user_id")[0].childNodes[0].nodeValue
							+ "</td><td>"
							+ x[i].getElementsByTagName("user_name")[0].childNodes[0].nodeValue
							+ "</td><td>"
							+ x[i].getElementsByTagName("user_email")[0].childNodes[0].nodeValue
							+ "</td><td>"
							+ x[i].getElementsByTagName("user_acc")[0].childNodes[0].nodeValue
							+ "</td><td>"
							+ x[i].getElementsByTagName("user_position")[0].childNodes[0].nodeValue
							+ "</td></tr>";
				}
				document.getElementById("demo").innerHTML = table;
			}
			function loadSalary() {
				var xhttp = new XMLHttpRequest();
				xhttp.onreadystatechange = function() {
					if (xhttp.readyState == 4 && xhttp.status == 200) {
						myFunction1(xhttp);
					}
				}
				xhttp
						.open(
								"GET",
								"http://localhost:8080/Company/rest/manager/showsalary",
								true);
				xhttp.send();
			}
			function myFunction1(xml) {
				var i;
				var xmlDoc = xml.responseXML;
				var table = "<tr><th>No.</th><th>Name</th><th>Salary</th></tr>";
				var x = xmlDoc.getElementsByTagName("salary");
				for (i = 0; i < x.length; i++) {
					table += "<tr><td>"
							+ x[i].getElementsByTagName("id")[0].childNodes[0].nodeValue
							+ "</td><td>"
							+ x[i].getElementsByTagName("username")[0].childNodes[0].nodeValue
							+ "</td><td>"
							+ x[i].getElementsByTagName("user_salary")[0].childNodes[0].nodeValue
 
							+ "</td></tr>";
				}
				document.getElementById("demo").innerHTML = table;
			}
		</script>
	</div>
</body>
</html>