<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test3/main.jsp</title>
<%@include file="../include_files/css_loading.jsp" %>
</head>
<body>
<%-- 
	include 시킬때는 현재 물리적인 위치를 기준으로 상대경로로 
	include 시켜야 한다. 
 --%>
<%@include file="../include_files/header.jsp" %>
<div class="main">
	<h3>main 컨텐츠 입니다.</h3>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Beatae debitis quam hic voluptates necessitatibus ipsa sed autem quaerat consequuntur alias eveniet perferendis! Tenetur labore veritatis dignissimos exercitationem neque quidem sed.</p>
</div>
<%@include file="../include_files/footer.jsp" %>
</body>
</html>








