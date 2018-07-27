<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<%
	// 공지사항 목록 얻어오기
	List<String> msgs=(List<String>)request.getAttribute("msgs");
%>
<div class="container">
<h3>home 페이지 입니다!</h3>
<c:choose>
	<c:when test="${not empty id }"><!-- session 영역에 id가 비어 있지 않으면(로그인 된 상태라면) -->
		<p><strong><a href="users/info.do">${id }</a></strong>님 hi~♥</p>
		<a href="users/logout.do">로그아웃</a>
	</c:when>
	<c:otherwise>
		<li><a href="users/signup_form.do">회원가입</a></li>
		<li><a href="users/login_form.do?url=${pageContext.request.contextPath}/index.jsp">로그인</a></li>
	</c:otherwise>
</c:choose>
<li><a href="member/list.do">회원 목록 보기</a></li>
<li><a href="file/list.do">자료실 목록 보기</a></li>
<li><a href="cafe/list.do">카페 글 목록 보기</a></li>
</ul>
<h3>오늘의 공지 사항</h3>
<ul>
<%for(String tmp:msgs){ %>
	<li><%=tmp %></li>
<%} %>
</ul>
</div>
</body>
</html>