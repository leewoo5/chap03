<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>redirect.jsp</title>
</head>
<body>
<h1>Redirect 실습</h1>
<%
	//response.sendRedirect("http://www.google.com");
	response.sendRedirect("/deptList.jsp");
	
%>
</body>
</html>