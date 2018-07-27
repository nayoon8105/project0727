<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/member/insertform.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<form action="insert.do">
		<label for="name">이름</label><br />
		<input type="text" name="name" id="name"/><br />
		<label for="addr">주소</label><br />
		<input type="text" name="addr" id="addr"/><br />
		<button type="submit" class="btn">추가</button>
	</form>
</div>
</body>
</html>