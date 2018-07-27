<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/private/update.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
<c:choose>
	<c:when test="${isSuccess }">
		<p><strong>${id } </strong>님의 회원 정보를 수정했습니다♥</p>
		<a href="info.do">확인</a>
	</c:when>
	<c:otherwise>
		<p>회원 정보 수정에 실패했습니다!</p>
		<a href="update_form.do">정보 수정하기</a>
	</c:otherwise>
</c:choose>
</div>
</body>
</html>