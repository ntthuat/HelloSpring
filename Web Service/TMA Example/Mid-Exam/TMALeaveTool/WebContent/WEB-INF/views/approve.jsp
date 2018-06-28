<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Approve/Reject a leave application</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="js/jquery_approve.js"></script>
<style type="text/css">
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1 class="text-center">Approve/Reject leave</h1>
		</div>
		<div class="row">
			<form action="approvereject">
				<div class="form-group">
					<div class="col-sm-12">
						<label class="text-primary">Select list Engineer (select
							one):</label>
					</div>
					<div class="form-group">
						<div class="col-sm-4 col-xs-6">
							<select name="employee" class="form-control">
								<c:forEach items="${engineeList}" var="employee">
									<option value="${employee.username}">${employee.username}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-4 col-xs-4">
							<button type="submit" class="btn btn-primary">
								<span class="glyphicon glyphicon-search"></span> Search
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
		<div class="row">
			<h2 class="text-primary col-sm-8">
				Leave Day of <span class="text-danger" id="username">${user}</span>
				:<span id="countleave"> ${leave} /12</span>
			</h2>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<table border="1" class="table table-hover table-bordered">
					<tr>
						<th>Id</th>
						<th>Username</th>
						<th>Reason</th>
						<th>Day Leave</th>
						<th>Start leave</th>
						<th>Status</th>
						<th colspan="2">Approve/Reject</th>
					</tr>
					<c:forEach items="${applicationList}" var="application">
						<tr class="dataApp">
							<td class="id">${application.id}</td>
							<td>${application.username}</td>
							<td>${application.reason}</td>
							<td>${application.leave_days}</td>
							<td>${application.start_date}</td>
							<td class="status"><c:if test="${application.status>0}">
									<c:out value="Accepted"></c:out>
								</c:if> <c:if test="${application.status==0}">
									<c:out value="Waiting"></c:out>
								</c:if> <c:if test="${application.status<0}">
									<c:out value="Rejected"></c:out>
								</c:if></td>
							<!--  <td><a href="approve?id=${application.id}&method=approve">Approve</a></td>-->
							<td><a class="approve">Approve</a></td>
							<td><a class="reject">Reject</a></td>
							<!-- <td><a href="approve?id=${application.id}&method=reject">Reject</a></td>-->
						</tr>
					</c:forEach>

				</table>
			</div>


		</div>


	</div>


</body>
</html>