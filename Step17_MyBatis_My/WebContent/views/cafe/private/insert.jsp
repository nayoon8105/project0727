<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/cafe/insert.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<c:choose>
		<c:when test="${isSuccess }">
			<p>${id }님의 글을 저장하였습니다.</p>
			<a href="${pageContext.request.contextPath}/cafe/list.do">목록으로</a>
		</c:when>
		<c:otherwise>
			<p>저장에 실패하였습니다.</p>
			<a href="insert_form.do">글 작성하기</a>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>