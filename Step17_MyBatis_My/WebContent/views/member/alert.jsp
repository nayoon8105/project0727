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
<div class="container">
<h3>알림 페이지</h3>
<p>${msg }</p>
<a href="${pageContext.request.contextPath}${url}">확인</a>
</div>
</body>
</html>