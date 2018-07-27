<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<h3>회원 가입 요청 결과 페이지</h3>
	<c:choose>
		<c:when test="${isSuccess }">
			<p><strong>${id }</strong>님 회원가입이 완료되었습니다.</p>
			<a href="login_form.do">로그인하기</a>
		</c:when>
		<c:otherwise>
			<p>가입 실패!</p>
			<a href="signup_form.do">다시 가입하러 가기!!</a>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>