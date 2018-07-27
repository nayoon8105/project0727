<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/users/private/delete.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<p><strong>${id }</strong>님의 탈퇴처리가 완료되었습니다. 그 동안 이용해주셔서 감사합니다!</p>
	<a href="${pageContext.request.contextPath}/">확인</a>
</div>
</body>
</html>