<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>game.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
<%
	request.setAttribute("thisPage", "game");
%>
<jsp:include page="navbar.jsp"/>
<div class="container">
	<h1>Game</h1>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perspiciatis officiis nobis sint placeat sequi iure voluptas quisquam ab vitae ipsa minus minima provident consequatur. Perspiciatis minima commodi laudantium numquam iure.</p>
</div>
</body>
</html>



