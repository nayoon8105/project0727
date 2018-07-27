<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/file/private/upload.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
<h3>업로드 결과 페이지</h3>
<c:choose>
	<c:when test="${isSuccess }">
		<p>파일을 업로드하였습니다.</p>
		<a href="../list.do">목록보기</a>
	</c:when>
	<c:otherwise>
		<p>파일 업로드에 실패하였습니다.</p>
		<a href="upload_form.do">파일 업로드하기</a>
	</c:otherwise>
</c:choose>
</div>
</body>
</html>