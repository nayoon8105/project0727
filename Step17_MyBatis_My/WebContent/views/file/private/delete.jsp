<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/file/private/delete.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<%		System.out.println("성공 여부 : "+request.getAttribute("isSuccess"));%>
<div class="container">
	<p>삭제하였습니다.</p>
	<a href="${pageContext.request.contextPath}/file/list.do">목록으로</a>
</div>
</body>
</html>