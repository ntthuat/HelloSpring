<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



$(document).ready(function() {
					$(".approve").click(function() {

										$.ajax({
													dataType : 'json',
													type : 'GET',
													url : 'http://localhost:8080/Company/restful/quanly/showuser',
													success : function(data) {
														var table = "<tr><th>Full name</th><th>Email</th><th>Account</th><th>Position</th></tr>";
														for ( var i in data) {
															table += "<tr><td>"
																	+ data[i].user_name
																	+ "</td><td>"
																	+ data[i].user_email
																	+ "</td><td>"
																	+ data[i].user_acc
																	+ "</td><td>"
																	+ data[i].user_position
																	+ "</td></tr>";
														}

														$('#demo').html(table);
													}
												});
									});

					$(".absent").click(function() {
						$.ajax({
							dataType : 'json',
							type : 'GET',
							url : 'http://localhost:8080/Company/restful/quanly/absent',
							success : function(data) {
								var table = "<tr><th>No.</th><th>Name</th><th>start day</th><th>end day</th><th>reason</th><th>status</th></tr>";
								for ( var i in data) {
									table += "<tr><td>"
											+ data[i].id
											+ "</td><td>"
											+ data[i].fullname
											+ "</td><td>"
											+ data[i].start_day
											+ "</td><td>"
											+ data[i].end_day
											+ "</td><td>"
											+ data[i].reason
											+ "</td><td>"
											+ data[i].status
											+ "</td><td>"
											+ "<button class=\"a\">ok</button>"
											+ "</td><td>"
											+ "<button class=\"decline\" value="+ data[i].id +" name=\"Decline\" onclick=\"reponse(this)\">Cancel</button>"
											+ "</td></tr>";
								}

								$('#demo').html(table);
							}
						});
					});
					  
				});
				function reponse(obj){
					var id = $(obj).val();
					var status = $(obj).attr('name');
					alert(id+" "+status);
					$.ajax({
						dataType : 'json',
						type : 'GET',
						url : 'http://localhost:8080/Company/restful/quanly/showabsent1/'+id+'/'+status,
						success : function(data) {
							var table = "<tr><th>No.</th><th>Name</th><th>start day</th><th>end day</th><th>reason</th><th>status</th></tr>";
							for ( var i in data) {
								table += "<tr><td>"
										+ data[i].id
										+ "</td><td>"
										+ data[i].fullname
										+ "</td><td>"
										+ data[i].start_day
										+ "</td><td>"
										+ data[i].end_day
										+ "</td><td>"
										+ data[i].reason
										+ "</td><td>"
										+ data[i].status
										+ "</td><td>"
										+ "<button class=\"a\">ok</button>"
										+ "</td><td>"
										+ "<button class=\"decline\" value="+ data[i].id +" name=\"Decline\" onclick=\"reponse(this)\">Cancel</button>"
										+ "</td></tr>";
							}

							$('#demo').html(table);
						}
					});
				}



</body>
</html>