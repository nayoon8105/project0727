<%@page import="test.users.dto.UsersDto"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/private/info.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<h3>개인 정보 페이지 입니다.</h3>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>항목</th>
				<th>정보</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>아이디</td>
				<td>${id }</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>${dto.pwd }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${dto.email }</td>
			</tr>
			<tr>
				<td>가입일</td>
				<td>${dto.regdate }</td>
			</tr>
		</tbody>
	</table>
<a href="update_form.do">회원 정보 수정</a><br />
<a href="javascript:deleteConfirm()">회원 탈퇴</a>
<script>
	function deleteConfirm(){
		var isDelete=confirm("정말 탈퇴하시겠어요?")
		if(isDelete){
			location.href="delete.do";
		}
	}
</script>
</div>
</body>
</html>