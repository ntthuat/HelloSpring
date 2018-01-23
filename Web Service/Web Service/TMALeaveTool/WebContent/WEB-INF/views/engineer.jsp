<%@page import="vn.com.tma.entity.Application"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Engineer</title>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1 class="text-center">Engineer</h1>
		</div>
		<jsp:include page="create_view_application.jsp"></jsp:include>
	</div>
</body>
</html>