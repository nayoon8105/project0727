<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/loginform.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<h3>로그인 폼입니다.</h3>
	<form action="login.do?url=${url }"  method="post" class="form">
		<label for="id">아이디</label>
		<input type="text" name="id" id="id"/><br />
		<label for="pwd">비밀번호</label>
		<input type="password" name="pwd" id="pwd"/><br />
		<button type="submit" class="btn">로그인</button>
	</form>
</div>
</body>
</html>