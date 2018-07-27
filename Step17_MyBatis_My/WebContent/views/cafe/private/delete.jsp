<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/cafe/private/delete.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<c:choose>
		<c:when test="${isSuccess }">
			<p>글이 삭제되었습니다.</p>
		</c:when>
		<c:otherwise>
			<p>글 삭제에 실패하였습니다.</p>
		</c:otherwise>
	</c:choose>
	<a href="${pageContext.request.contextPath}/cafe/list.do">목록으로</a>
</div>
</body>
</html>