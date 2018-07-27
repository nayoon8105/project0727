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
	.searchList{
		padding:10px 0;
		border:1px solid darkgray;
		width:130px;
		list-style: none;
   		display: flex;
   	 	margin-top: 15px;
	   	display: flex;
	    align-items: center;
    	justify-content: center;
    	position: absolute;
    	background-color:white;
	}
	.searchList ul{
		padding: 0;
		margin:0;
		list-style: none;
	}
	.searchList>li>a{
		color: black;
	}
	.search_div{
		width:130px;
		text-align: center;
	}
	#align:hover{
		cursor: pointer;
	}
</style>
</head>
<body>
<div class="container">
	<h3>카페 글 목록 입니다.</h3>
	<a href="private/insert_form.do">새 글 작성</a>
	
	<div class="search_div">
			<strong id="align">정렬</strong>
		<div class="searchList" style="margin-top:0; display: none;">
			<ul>
				<li><a href="cafe/alignList.do?idx=0">최근 순</a></li>
				<li><a href="cafe/alignList.do?idx=1">오래된 순</a></li>
				<li><a href="cafe/alignList.do?idx=2">조회 수</a></li>
				<li><a href="cafe/alignList.do?idx=3">좋아요 수</a></li>
			</ul>
		</div>
	</div>
	
	<table class="table table-bordered" style="margin-top: 20px;">
		<colgroup>
		    <col style="width:10%"/>
		    <col style="width:10%"/>
		    <col style="width:15%"/> 
		    <col style="width:15%"/>               
		    <col style="width:25%"/>
		    <col style="width:5%"/>
		    <col style="width:5%"/>
		    <col style="width:15%"/>   
		</colgroup>
		
		<thead>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>조회수</th>
				<th>등록일</th>
				<th>좋아요</th>
				<th>싫어요</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmp" items="${list }">
			<tr>
				<td>${tmp.num }</td>
				<td>${tmp.writer }</td>
				<td><a href="detail.do?num=${tmp.num }&condition=${condition}&keyword=${keyword}">${tmp.title }</a></td>
				<td>${tmp.viewCount }</td>
				<td>${tmp.regdate }</td>
				<td>${tmp.totalLike }</td>
				<td>${tmp.totalDislike }</td>
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
					<a class="page-link" href="list.do?pageNum=${startPageNum-1 }&condition=${condition}&keyword=${keyword}" aria-label="Previous">
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
					<a class="page-link" href="list.do?pageNum=${endPageNum+1 }&condition=${condition}&keyword=${keyword}" aria-label="Next">
				      <span aria-hidden="true">&raquo;</span>
				      <span class="sr-only">Next</span>
				    </a>
				      </li>
				</c:if>
		  </ul>
		</nav>
	</div>
	<!-- keyword 검색어 form. 폼 제출 시 list.do 액션이 실행 돼 새로고침 효과를 낸다. -->
	<form action="list.do" method="post">
		<label for="condition">검색 조건</label>
			<select name="condition" id="condition">
				<option value="titleContent" <c:if test="${condition eq 'titleContent'}"> selected="selected"</c:if>>제목+내용</option>
				<option value="title" <c:if test="${condition eq 'title'}">selected="selected"</c:if>>제목</option>
				<option value="writer" <c:if test="${condition eq 'writer'}">selected="selected"</c:if>>작성자</option>
			</select><br />
			<c:if test="${condition eq 'titleContent' }"></c:if>
		<input type="text" name="keyword" placeholder="검색" value="${keyword }"/>
		<button type="submit" class="btn">검색</button>
	</form>
	<c:choose>
		<c:when test="${not empty keyword }">
			<p><strong>${keyword }</strong> 검색어로 검색 된
			<strong>${totalRow }</strong> 개의 글이 있습니다.</p>
		</c:when>
		<c:otherwise>
			<p><strong>${totalRow }</strong>개의 글이 있습니다.</p>
		</c:otherwise>
	</c:choose>
</div>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
<script>
	function showList(){
		$(this).parent().find(".searchList").show();
	}
	$("#align").click(function(){
		$(this).parent().find(".searchList").slideToggle();
	})
</script>
</body>
</html>