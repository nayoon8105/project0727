<%@page import="test.member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/member/updateform.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<%
	MemberDto dto=(MemberDto)request.getAttribute("dto");
%>
<div class="container">
	<form action="update.do" method="post">
		<input type="hidden" name="num" value="<%=dto.getNum() %>"/>
		<label for="num">번호</label>
		<input type="text" id="num" value="<%=dto.getNum() %>" disabled/><br />
		<label for="name">이름</label>
		<input type="text" name="name" id="name" value="<%=dto.getName()%>"/><br />
		<label for="addr">주소</label>
		<input type="text" name="addr" id="addr" value="<%=dto.getAddr() %>"/><br />
		<button type="submit" class="btn btn-primary">수정</button>
	</form>
</div>
</body>
</html>