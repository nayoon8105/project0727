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
	body{
		padding-top: 50px;
	}
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
	.container{
		text-align: center;
	}
	table , .upload{
	 	text-align: left;
	}
</style>
</head>
<body>
<div class="container">
	<h3>파일 목록 입니다.</h3>
	<a class="upload" href="private/upload_form.do"><p>파일 올리기</p></a>
	<table class="table table-bordered">
		<colgroup>
		    <col style="width:15%"/>
		    <col style="width:15%"/>
		    <col style="width:25%"/>                  <!-- html5 이전에 작성하던 방식입니다. 지양하도록 합니다. -->
		    <col style="width:30%"/>          <!-- Style Attribute 를 이용해 적어주거나 -->
		    <col style="width:15%"/>           <!-- Class 를 지정해서 스타일을 입혀줍니다. -->
		</colgroup>
		
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
		<nav aria-label="Page navigation">
		  <ul class="pagination">
		  
		  	<!-- 이전 -->
			
				<c:if test="${startPageNum != 1 }">
				<li class="page-item">
					<a class="page-link" href="list.do?pageNum=${startPageNum-1 }" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				        <span class="sr-only">Previous</span>
			     	</a>
			     	 </li>
				</c:if>
				
		   
		    
		    <c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		    	<c:choose>
		    		<c:when test="${pageNum eq i }">
		    			<li class="page-item"><a class="active page-link" href="list.do?pageNum=${i }">${i }</a></li>
		    		</c:when>
		    		<c:otherwise>
		    			<li class="page-item"><a class="page-link" href="list.do?pageNum=${i }">${i }</a></li>
		    		</c:otherwise>
		    	</c:choose>
		    </c:forEach>
		    
		    <!-- 다음 -->
			
				<c:if test="${endPageNum<totalPageCount }">
				<li class="page-item">
					<a class="page-link" href="list.do?pageNum=${endPageNum+1 }" aria-label="Next">
				      <span aria-hidden="true">&raquo;</span>
				      <span class="sr-only">Next</span>
				    </a>
				      </li>
				</c:if>
			    
		  
		    
		  </ul>
		</nav>
	</div>
	
</div>
</body>
</html>