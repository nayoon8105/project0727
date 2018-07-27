<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/private/upload_form.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<%
	/*
		[ 파일 업로드 폼 작성법]
		
		1. method="post"
		2. enctype="multipart/form-data"
		3. <input type="file" />
	*/
	
	// 로그인 한 사용자의 아이디
	String id=(String)session.getAttribute("id");
%>
<div class="container">
	<p><strong><%=id %></strong>님 로그인 중...</p>
	<h3>파일 업로드 폼 입니다.</h3>
												<!--  -->
	<form action="upload.do" method="post" enctype="multipart/form-data" class="form">
		<label for="title">제목</label>
		<input type="text" name="title" id="title"/>
		<label for="myFile">첨부파일</label>
		<input type="file" name="myFile" id="myFile"/>
		<button type="submit">업로드</button>
	</form>
</div>
</body>
</html>