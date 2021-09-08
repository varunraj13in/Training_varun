<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="MyServlet">MyServlet</a>
<a href="TestServlet">TestServlet</a>
<p>Hi <%=session.getAttribute("uname")%></p>
</body>
</html>