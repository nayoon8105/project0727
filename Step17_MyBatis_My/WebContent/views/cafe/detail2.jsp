<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/cafe/detail.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<style>
	body{
		padding-top: 50px;
	}
	img{
		width:300px;
	}
	h3, th{
		text-align: center;
	}
	.comment{
		position: relative;
	}
	.content{
		text-align: center;
		border: 1px solid #cecece;
		padding:15px;
		margin: 0 15px;
	}
	/* 댓글에 댓글을 다는 폼은 일단 숨겨 놓기 */
	.comment form{
		display:none;
	}
</style>
</head>
<body>
<div class="container">
	<c:if test="${id eq dto.writer }">
		<a href="private/update_form.do?num=${dto.num }">수정</a>
		<a href="javaScript:deleteConfirm()">삭제</a>
		<script>
			function deleteConfirm(){
				var isDelete=confirm("정말 삭제하시겠습니까?");
				if(isDelete){
					location.href="private/delete.do?num=${dto.num}";
				}
			}
		</script>
	</c:if>

	<h3>글 자세히 보기 페이지</h3>
	<table class="table table-bordered">
		<tr>
			<th>글 번호</th>
			<th>${dto.num }</th>
		</tr>
		<tr>
			<th>작성자</th>
			<th>${dto.writer }</th>
		</tr>
		<tr>
			<th>제목</th>
			<th>${dto.title }</th>
		</tr>
	</table>
	<div class="row">
		<div class="content">${dto.content }</div>
	</div>
	
	<!-- 댓글에 관련 된 UI -->
	<div class="comments">
		<c:forEach var="tmp" items="${commentList }">
			<div class="comment" <c:if test="${tmp.num ne tmp.comment_group }">style="margin-left: 30px;"</c:if>>	
				<c:if test="${tmp.num ne tmp.comment_group }">
					<img src="${pageContext.request.contextPath}/resources/images/re.gif" style="width:10px;"/>
				</c:if>
				
				<img src="${pageContext.request.contextPath}/resources/images/user_image.gif" style="width:20px;"/>
				<span><strong>${tmp.writer }</strong></span>
				<!-- 타겟 아이디 -->
				<c:if test="${tmp.num ne tmp.comment_group }">
					<strong style="color: #cecece;">${tmp.target_id }</strong>
				</c:if>
				<span>${tmp.content }</span>
				<span style="color:grey">${tmp.regdate }</span>
				<a href="javascript:" class="reply_link">답글</a> | 
				<a href="">신고</a>
				
			
				
				<form action="comment_insert.do" method="post">
					<!-- 덧글 작성자 -->
					<input type="hidden" name="writer" value="${id }"/>
					<!-- 덧글 그룹 -->
					<input type="hidden" name="ref_group" value="${dto.num }" />
					<!-- 덧글 대상 -->
					<input type="hidden" name="target_id" value="${tmp.writer }" />
					<input type="hidden" name="comment_group" value="${tmp.comment_group }" />
					<textarea name="content"></textarea>
					<button type="submit">등록</button>
				</form>			
			</div>
		</c:forEach>
		<hr />
		<!-- 원글에 댓글을 달 수 있는 form -->
		<div class="comment_form" style="margin-top: 30px; margin-bottom: 15px;">
			<form action="comment_insert.do" method="post">
				<input type="hidden" name="writer" value="${id }"/>
				<input type="hidden" name="ref_group" value="${dto.num }"/>
				<input type="hidden" name="target_id" value="${dto.writer }"/>
				<div class="row">
					<textarea name="content" id="content" class="col-xs-10" style="padding-right: 15px;"></textarea>
					<button class="btn btn-primary col-xs-1 col-xs-offset-1">댓글 등록</button>
				</div>
			</form>
		</div>
	</div>
	
	<c:if test="${not empty keyword }">
		<p><strong>${keyword }</strong>에 대한 자세히 보기</p>
	</c:if>
	<div class="row" id="prevNext">
		<div class="col-xs-2">
			<c:if test="${dto.prevNum ne 0 }">
				<a href="detail.do?num=${dto.prevNum }&condition=${condition}&keyword=${keyword}">이전 글</a>
				<p>${dto.prevName }</p>
			</c:if>
		</div>
		<div class="col-xs-2 pull-right" style="text-align: right;">
			<c:if test="${dto.nextNum ne 0 }">
				<a href="detail.do?num=${dto.nextNum }&condition=${condition}&keyword=${keyword}">다음 글</a>
				<p>${dto.nextName }</p>
			</c:if>
		</div>
	</div>
	<div class="row">
		<a href="list.do">뒤로</a>
	</div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
<script>
	// 로그인을 안 한 상태면 댓글을 쓸 수 X
	// 로그인 했는지 여부
	var isLogin=${isLogin};
	// 댓글 전송 이벤트가 일어났을 때 실행 할 함수를 등록
	$(".comment_form>form").on("submit",function(){
		if(!isLogin){ // 로그인 하지 않았으면
			var isGoLogin=confirm("로그인이 필요합니다.");
			if(isGoLogin){ // 로그인 페이지로 이동하기
				location.href="${pageContext.request.contextPath}/users/login_form.do?"
						+ "url=${pageContext.request.contextPath}/cafe/detail.do?num=${dto.num}";
			}
			return false; // 폼 전송 막기
		}
	})
	// 로그인을 안 한 상태면 대댓글을 쓸 수 X
	$(".reply_form>form").on("submit",function(){
		if(!isLogin){ // 로그인 하지 않았으면
			var isGoLogin=
				confirm("로그인이 필요합니다.");
			if(isGoLogin){ // 로그인 페이지로 이동하기
				location.href="${pageContext.request.contextPath}/users/login_form.do?"
						+ "url=${pageContext.request.contextPath}/cafe/detail.do?num=${dto.num}";
			}
			return false; // 폼 전송 막기
		}
	})
	// 댓글의 댓글달기 버튼을 누른 경우 폼 보여주기
	$(".replyBtn").click(function(){
		$(".reply_form").show();
	})
	
	$(".comment .reply_link").click(function(){
		$(this).parent().find("form").slideToggle(200);
		
	})
</script>
</body>
</html>