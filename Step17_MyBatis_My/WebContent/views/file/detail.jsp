<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/file/detail.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<style>
	body{
		padding-top: 50px;
	}
</style>
</head>
<body>
<div class="container">
	<h3>${dto.title }</h3>
	<table class="table table-bordered">
		<tbody>
			<tr>
				<td>번호 : ${dto.num }</td>
				<td>작성자 : ${dto.writer}</td>
				<td>작성일 : ${dto.regdate}</td>
			</tr>
			<tr>
				<td colspan="2"><a href="download.do?num=${dto.num }">${dto.orgFileName }</a></td>
				<td>다운로드 횟수 : ${dto.downCount }</td>
			</tr>
		</tbody>
	</table>
	<a href="list.do">뒤로</a>
</div>
</body>
</html>