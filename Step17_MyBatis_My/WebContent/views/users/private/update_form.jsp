<%@page import="test.users.dto.UsersDto"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/private/update_form.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<h3>회원 정보 수정 폼 입니다.</h3>
	<form action="update.do"  method="post" class="form" id="updateForm">
		<input type="hidden" name="id" value="${id }"/>
		<label for="id">아이디</label>
		<input type="text" id="id" value="${id }" disabled/><br />
		<label for="pwd">비밀번호</label>
		<input type="password" name="pwd" id="pwd" value="${dto.pwd }"/><br />
		<label for="pwd2">비밀번호 확인</label>
		<input type="password" name="pwd2" id="pwd2" value="${dto.pwd }"/><br />
		<label for="email">이메일</label>
		<input type="text" name="email" id="email" value="${dto.email }"/><br />
		<button type="submit" class="btn">수정</button>
	</form>
</div>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
<script>
	// form 에 submit 이벤트가 일어났을 때 실행할 함수 등록
	$("#updateForm").submit(function(){
		// 입력한 비밀번호를 일거와서
		var pwd1=$("#pwd").val();
		var pwd2=$("#pwd2").val();
		if(pwd1!=pwd2){ // 두개를 다르게 입력하면
			alert("비밀번호를 확인하세요.")
			return false; // 폼 전송 막기
		}
	});
</script>
</body>
</html>