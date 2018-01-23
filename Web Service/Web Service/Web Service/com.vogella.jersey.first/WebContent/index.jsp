<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ page import="java.util.List"%>
<%@ page import="com.vogella.jersey.first.*"%>
</head>
<body>
        <%
                String id = request.getParameter("id").toString();
                String status = request.getParameter("status");
                System.out.print(id + " " + status);

                Method2.instance.ChangeStatus(id, status);
        %>


</body>
</html>