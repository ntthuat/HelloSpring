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
</style>
</head>
<body>
	<div class="col-sm-12">
		<h2 class="text-primary">
			Total leave: ${leave}<span>/12</span>
		</h2>
		<table class="table table-hover table-bordered">
			<tr>
				<th>Id</th>
				<th>Reason</th>
				<th>Day Leave</th>
				<th>Start leave</th>
				<th>Status</th>
			</tr>
			<c:forEach items="${applicationList}" var="application">
				<tr>
					<td>${application.id}</td>
					<td>${application.reason}</td>
					<td>${application.leave_days}</td>
					<td>${application.start_date}</td>
					<td><c:if test="${application.status>0}">
							<c:out value="Accepted"></c:out>
						</c:if> <c:if test="${application.status==0}">
							<c:out value="Waiting"></c:out>
						</c:if> <c:if test="${application.status<0}">
							<c:out value="Rejected"></c:out>
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="col-sm-12">
		<h2 class="bg-primary">Create Leave Application</h2>
		<div class="col-sm-12">
			<form action="create" method="post" class="form-horizontal">
				<div class="form-group">
					<label for="comment">Comment:</label>
					<textarea class="form-control" rows="5" id="comment" name="reason"
						required="required"></textarea>
				</div>
				<div class="form-group">
					<div class="form-group">
						<label class="col-sm-2 col-xs-5">Number leave:</label>
						<div class="col-sm-4 col-xs-7">
							<input class="form-control input-sm " type="number"
								max=12 min=1 name="leave_days" required="required">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-xs-5">Start leave:</label>
						<div class="col-sm-4 col-xs-7" >
							<input type="date" class="form-control" id="dateleave"
								name="start_date" required="required">
						</div>
					</div>
						<button type="submit" class="btn btn-primary" id="creat" >Submit</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>