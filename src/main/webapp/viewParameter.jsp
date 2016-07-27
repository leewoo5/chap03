<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>v요청 파라미터 출력</title>
</head>
<body>

<b>request.getParameter() 메서드 사용</b><br>
name 파라미터 = <%=request.getParameter("name")%><br>
address 파라미터 = <%=request.getParameter("address") %>

<p>
<b>request.getParameterValues() 메서드 사용</b><br>
<%
   String[] values = request.getParameterValues("pet");
   if(values !=null) {
      for(int i=0; i<values.length; i++) {
%>
<%=values[i] %>
<%
      }
   }
%>         


<p>
<b>request.getParameterNames() 메서드 사용</b><br>
<%
   Enumeration paramEunm = request.getParameterNames();
   while(paramEunm.hasMoreElements()){
      String name = (String)paramEunm.nextElement();
%>
<%=name %>
<%
   }
%>


<p>
<b>requset.getParameterMap() 메서드 사용</b><br>   
<%
   Map parameterMap = request.getParameterMap();
   String[] nameParam = (String[])parameterMap.get("pet");
   if(nameParam != null) {
%>
name=<%=nameParam[0] %>      
<%
   }
%>


</body>
</html>