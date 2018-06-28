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
		$("#showUser").click(function() {
/* 		 alert('aaa'); */
		$.ajax({
			dataType:'json',
			type:'GET',
			url:'http://localhost:8080/com.vogella.jersey.first/rest/user/allUser',			
			success:function(data) {
				var table =
						"<tr><th>ID</th>"
						+ "</th><th>Name</th>"
						+ "</th><th>Password</th>"
						+ "</th><th>Type_Account</th>"
						+ "</th><th>status</th>"
						+ "</th></tr>";	
						
			    for (var i in data) {
			    	table += "<tr><td>"
			    			+ data[i].id
			    			+ "</td><td>"
			    			+ data[i].name
			    			+ "</td><td>"
			    			+ data[i].password
			    			+ "</td><td>"
			    			+ data[i].type_account
			    			+ "</td><td>"
			    			+ data[i].status
			    			if (data[i].status == "Waiting"){
			    				table += "</td><td>"
										+ "<button class=\"btn btn-warning\" value="
										+ i
										+ " onclick=\"change(this)\" name=\"Approve\">Approve</button>"
										+ "</td><td>"
										+ "<button class=\"btn btn-warning\" value="
										+ i
										+ " onclick=\"change(this)\" name=\"Reject\">Reject</button>"
			    			}
			    			+ "</td></tr>"			    
			    }
			    
			    $('#demo').html(table);
			}
		});		
	});
	});	
	 
	function change(but) {
		var status = but.name;
		var id = but.value;
		var $that=$(this);
	$.ajax({
			dataType : 'json',
			type : 'GET',
			url : 'http://localhost:8080/com.vogella.jersey.first/rest/user/changeStatus/'+id+"/"+status,
			success : function(data) {
				var table =
					"<tr><th>ID</th>"
					+ "</th><th>Name</th>"
					+ "</th><th>Password</th>"
					+ "</th><th>Type_Account</th>"
					+ "</th><th>status</th>"
					+ "</th></tr>";	
					
		    for (var i in data) {
		    	table += "<tr><td>"
		    			+ data[i].id
		    			+ "</td><td>"
		    			+ data[i].name
		    			+ "</td><td>"
		    			+ data[i].password
		    			+ "</td><td>"
		    			+ data[i].type_account
		    			+ "</td><td>"
		    			+ data[i].status
		    			if (data[i].status == "Waiting"){
		    				table += "</td><td>"
									+ "<button class=\"btn btn-warning\" value="
									+ i
									+ " onclick=\"change(this)\" name=\"Approve\">Approve</button>"
									+ "</td><td>"
									+ "<button class=\"btn btn-warning\" value="
									+ i
									+ " onclick=\"change(this)\" name=\"Reject\">Reject</button>"
		    			}
		    			+ "</td></tr>"			    
		    }
		    
		    $('#demo').html(table);
			},error : function(error) {
				alert("Error in somewhere!!!");
			}
		});

		
	}
	
</script>

	<div class="container">
		<div class="jumbotron">
			<h1>Human Resource Department</h1>

		</div>
			<button id="showUser" type="button" class="btn btn-success">Show User's Information</button>
			<p></p>
			<table id="demo" class="table table-bordered "></table>
	</div>
	
</body>
</html>