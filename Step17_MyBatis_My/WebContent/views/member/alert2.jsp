<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/member/alert.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<%
	String msg=(String)request.getAttribute("msg");
	String url=(String)request.getAttribute("url");
	// Context 경로
	String cPath=request.getContextPath();
%>
<div class="container">
<h3>알림 페이지</h3>
<p><%=msg %></p>
<a href="<%=cPath%><%=url%>">확인</a>
</div>
</body>
</html>