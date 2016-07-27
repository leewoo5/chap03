<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%!
	public int add(int a , int b , int c , int d){
 		int e= a + b + c+ d ;
 		return e ;
	 }	 		
 	public int subtract(int a, int b , int c , int d){
 		
 		int e = (a+ b) - (c +d);
 		return e;
 	}
 		
  %>  
  
  
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>useDecl2.jsp</title>
</head>
<body>
<%
	int value1 =3;
	int value2 =4;
	int value3 =5;
	int value4 =6;
	int value5 =7;
	int addResult = add(value1, value2, value3,value4 );
	int subResult = subtract(value1, value2, value3,value4 );
%>

<%= value1  %> + <%= value2 %>+ <%= value3 %>+ <%= value4 %> = <%= addResult %>
<br>
(<%= value1  %> + <%= value2 %>)-  (<%= value3 %>+ <%= value4 %>) = <%= addResult %>
</body>
</html>