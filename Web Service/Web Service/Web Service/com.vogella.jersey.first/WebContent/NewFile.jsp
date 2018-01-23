
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
<%@ page import="com.vogella.jersey.first.application"%>
<%@ page import="com.vogella.jersey.first.Method"%>
<%@ page import="com.vogella.jersey.first.TodosResource"%>
<%@ page import="java.util.List"%>
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
		<div class="jumbotron">
			<h1>Human Resource Department</h1>

		</div>
		<%
			User user = (User) session.getAttribute("user");
		if (user == null) {
			%>
		<h1>You are not logged in!</h1>
		<%
		} else {
			out.print("<p align=\"right\">Hi " + user.getName() + " .You are " + user.getType_account()
					+ "[<a href=\"http://localhost:8080/com.vogella.jersey.first/login.jsp\">logout</a>]</p>");
		%>
		<div align="center">
			<button type="button" class="btn btn-success" onclick="loadUser()">Member
				Information</button>
		</div>
		<br> <br>
		<div class="col-sm-12"></div>
		<div class="col-sm-12">
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
				xhttp
						.open(
								"GET",
								"http://localhost:8080/com.vogella.jersey.first/rest/manager/showapplication",
								true);
				xhttp.send();
			}

			function myFunction(xml) {
				var xmlDoc = xml.responseXML;
				var i;
				var table = "<tr><th>ID Application</th><th>ID User</th><th>Start Day</th><th>End Day</th><th>Reason</th><th>Status</th></tr>";
				var x = xmlDoc.getElementsByTagName("application");
				for (i = 0; i < x.length; i++) {
					table += "<tr><td>"
							+ x[i].getElementsByTagName("id_application")[0].childNodes[0].nodeValue
							+ "</td><td><p id=\"changeIdUser(this)\">"
							+ x[i].getElementsByTagName("id_user")[0].childNodes[0].nodeValue
							+ "</p></td><td>"
							+ x[i].getElementsByTagName("start_day")[0].childNodes[0].nodeValue.slice(0,10)
							+ "</td><td>"
							+ x[i].getElementsByTagName("end_day")[0].childNodes[0].nodeValue.slice(0,10)
							+ "</td><td>"
							+ x[i].getElementsByTagName("reason")[0].childNodes[0].nodeValue
							+ "</td><td>"
							+ x[i].getElementsByTagName("status")[0].childNodes[0].nodeValue
							+ "</td><td>"
							+ "<button class=\"btn btn-danger\" value="
							+ x[i].getElementsByTagName("id_application")[0].childNodes[0].nodeValue
							+ " onclick=\"changeID(this)\" name=\"Change\">Change</button>"
					if (x[i].getElementsByTagName("status")[0].childNodes[0].nodeValue == "Waiting") {
						table += "</td><td>"
								+ "<button class=\"btn btn-warning\" value="
								+ x[i].getElementsByTagName("id_application")[0].childNodes[0].nodeValue
								+ " onclick=\"change(this)\" name=\"Approve\">Approve</button>"
								+ "</td><td>"
								+ "<button class=\"btn btn-warning\" value="
								+ x[i].getElementsByTagName("id_application")[0].childNodes[0].nodeValue
								+ " onclick=\"change(this)\" name=\"Reject\">Reject</button>"

					}
					table += "</td></tr>"
				}

				document.getElementById("demo").innerHTML = table;
			}
			
			function changeID(but) {
				if (but.innerHTML == 'Change') {
					document.getElementById("changeIdUser(this)").innerHTML = "<input id=\"changeIdUser(this)\" type = \"number\" placeholder=\"edit ID User\">";
					but.innerHTML = "OK";
				}
				if (but.innerHTML == "OK") {
					var id_user = document.getElementById("changeIdUser").value;
			 
					var xhttp = new XMLHttpRequest();
					xhttp.onreadystatechange = function() {
						if (xhttp.readyState == 4 && xhttp.status == 200) {
							showyourimf(xhttp);
							alert("Changing Success");
						}
					}
					xhttp.open("GET",
							"http://localhost:8080/Company/rest/manager/changeInfo?id_application="
									+ but.value+"",
							true);
					xhttp.send();
			 
				}
			}
			
			function change(but) {

				var xmlhttp;
				if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
					xmlhttp = new XMLHttpRequest();
				} else {// code for IE6, IE5
					xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
				}
				xmlhttp.onreadystatechange = function() {
					if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
						myFunction(xmlhttp);
					}
				}
				xmlhttp.open("GET",
						"http://localhost:8080/com.vogella.jersey.first/rest/manager/updateAbsent?id_application="
								+ but.value + "&status=" + but.name + "", true);
				xmlhttp.setRequestHeader("Content-type",
						"application/x-www-form-urlencoded");
				xmlhttp.send();
			}

			//String id = request.getParameter("but");
		</script>
		<%}%>
	</div>
</body>
</html>