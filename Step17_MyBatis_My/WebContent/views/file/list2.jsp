<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/file/list.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<style>
	.page_display a{
		text-decoration: none;
		color:#000;
	}
	.page_display a.active{
		font-weight:bold;
		color:red;
		text-decoration: underline;
	}
	.page_display a.muted{
		color: #cecece;
	}
</style>
</head>
<body>
<div class="container">
	<h3>파일 목록 입니다.</h3>
	<a href="private/upload_form.do">파일 올리기</a>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>등록일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmp" items="${list }">
			<tr>
				<td>${tmp.num }</td>
				<td>${tmp.writer }</td>
				<td><a href="detail.do?num=${tmp.num }">${tmp.title }</a></td>
				<td>${tmp.regdate }</td>
				<c:choose>
					<c:when test="${id eq tmp.writer }"> <!-- 자신의 글만 수정, 삭제할 수 있음 -->
						<td><a href="delete.do?num=${tmp.num }">삭제</a></td>
					</c:when>
					<c:otherwise>
						<td></td>
					</c:otherwise>
				</c:choose>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- 페이징 처리 -->
	<div class="page_display">
		<c:choose>
			<c:when test="${startPageNum != 1 }">
				<li><a href="list.do?pageNum=${startPageNum-1 }"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
			</c:when>
			<c:otherwise>
				<!-- anchor가 아무 동작도 하지 않게 하기 위해 javascript: 키워드 추가 -->
				<a class="muted" href="javascript:"><span class="glyphicon glyphicon-chevron-left"></span></a>
			</c:otherwise>
		</c:choose>
		
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
			<c:choose>
				<c:when test="${i eq pageNum }">
					<a class="active" href="list.do?pageNum=${i }">${i }</a>
				</c:when>
				<c:otherwise>
					<a href="list.do?pageNum=${i }">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:choose>
			<c:when test="${endPageNum < totalPageCount }">
				<a href="list.do?pageNum=${endPageNum+1 }"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</c:when>
			<c:otherwise>
				<a class="muted" href="javascript:"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</c:otherwise>
		</c:choose>
	</div>
</div>
</body>
</html>