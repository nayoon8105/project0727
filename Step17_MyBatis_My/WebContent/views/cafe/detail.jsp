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
		padding-top: 30px;
	}
	img{
		width:300px;
	}
	h3, th{
		text-align: center;
	}
	
	.content{
		text-align: center;
		border: 1px solid #cecece;
		padding:15px;
		margin: 0 15px;
	}
	.function_div a{
		font-size: larger;
		color: #696969;
		font-weight: bold;
	}
	.likeDislike strong{
		font-size: 15px;
	}
	.likeDislike a{
		color:black;
	}
	.likeDislike .clicked{
		color:red; 
		font-size:20px;
		font-weight: bold;
	}
</style>
</head>
<body>
<div class="container">
	

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
	<div class="row" style="margin-bottom: 20px;">
		<div class="content">${dto.content }</div>
	</div>
	
	<!-- 좋아요 싫어요 -->
	<div class="row likeDislike" style="text-align: center">
		<div class="col-xs-2 col-xs-offset-3">
			<a href="<c:if test="${not empty id and isCliked!=2}">likeDislike_insert.do?num=${dto.num}&id=${id}&isLike=1</c:if>"
			class="<c:if test="${isClicked eq 1}">clicked</c:if>">좋아요
			<span class="glyphicon glyphicon-thumbs-up"></span></a>
			<strong>${totalLike }</strong>
		</div>
		<div class="col-xs-2 col-xs-offset-1">
			<a href="<c:if test="${not empty id and isCliked!=1}">likeDislike_insert.do?num=${dto.num}&id=${id}&isLike=2</c:if>"
			class="<c:if test="${isClicked eq 2}">clicked</c:if>">싫어요
			<span class="glyphicon glyphicon-thumbs-down"></span></a>
			<strong>${totalDislike }</strong>
		</div>
	</div>
	
	<hr />
	
	<!-- 댓글에 관련 된 UI -->
	<div class="comments">
		<c:forEach var="tmp" items="${commentList }">
			<div class="comment" <c:if test="${tmp.num ne tmp.comment_group }">style="margin-left: 30px;"</c:if>>	
				<!-- 대댓글엔 화살표 -->
				<c:if test="${tmp.num ne tmp.comment_group }">
					<img src="${pageContext.request.contextPath}/resources/images/re.gif" style="width:10px;  margin-right: 5px;"/>
				</c:if>
				<img src="${pageContext.request.contextPath}/resources/images/user_image.gif" style="width:20px;"/>
				<span><strong>${tmp.writer }</strong></span>
				<!-- 대댓글엔 타겟 아이디 -->
				<c:if test="${tmp.num ne tmp.comment_group }">
					<span style="color: #cecece;">@${tmp.target_id }</span>
				</c:if>
				<span>${tmp.content }</span>
				<span style="color:grey">${tmp.regdate }</span>
				<a href="javascript:" class="reply_btn">댓글</a>
				<!-- 본인의 댓글만 수정, 삭제 가능 -->
				<c:if test="${tmp.writer eq id }">
				| <a href="javaScript:" class="update_btn">수정</a>
				| <a href="javaScript:deleteCommentConfirm(${tmp.num },${dto.num})">삭제</a>
				</c:if>
				<!-- 댓글 수정 폼 -->
				<div class="update_form" style="margin-top: 30px; display: none;">
					<form action="comment_update.do" method="post">
						<input type="hidden" name="num" value="${tmp.num }"/>
						<input type="hidden" name="ref_group" value="${tmp.ref_group }"/>
						<div style="display: flex; align-items: center;">
							<textarea name="content" id="content" cols="100">${tmp.content }</textarea>
							<button class="btn" style="margin-left: 20px;">댓글 수정</button>
						</div>
					</form>
				</div>
				<!-- 대댓글 폼 -->
				<div class="reply_form" style="margin-top: 30px; display: none;">
					<form action="comment_insert.do" method="post">
						<input type="hidden" name="writer" value="${id }"/>
						<input type="hidden" name="ref_group" value="${tmp.ref_group }"/>
						<input type="hidden" name="target_id" value="${tmp.writer }"/>
						<input type="hidden" name="comment_group" value="${tmp.comment_group }"/>
						<div style="display: flex; align-items: center;">
							<textarea name="content" id="content" cols="100"></textarea>
							<button class="btn" style="margin-left: 20px;">댓글 등록</button>
						</div>
					</form>
				</div>
			</div>
		</c:forEach>
		<!-- 원글에 댓글을 달 수 있는 form -->
		<div class="comment_form" style="margin-top: 30px; margin-bottom: 15px;">
			<form action="comment_insert.do" method="post">
				<input type="hidden" name="writer" value="${id }"/>
				<input type="hidden" name="ref_group" value="${dto.num }"/>
				<input type="hidden" name="target_id" value="${dto.writer }"/>
				<div class="row">
					<textarea name="content" id="content" class="col-xs-10" style="margin-left: 15px;"></textarea>
					<button class="btn btn-primary btn-lg" style="margin-left: 20px;">댓글 등록</button>
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
				<a href="detail.do?num=${dto.prevNum }&condition=${condition}&keyword=${keyword}">◀이전 글</a>
				<span>${dto.prevName }</span>
			</c:if>
		</div>
		<div class="col-xs-2 pull-right" style="text-align: right;">
			<c:if test="${dto.nextNum ne 0 }">
				<span>${dto.nextName }</span>
				<a href="detail.do?num=${dto.nextNum }&condition=${condition}&keyword=${keyword}">다음 글▶</a>	
			</c:if>
		</div>
	</div>
	<div class="row function_div" style="margin-top: 20px;">
		<a href="list.do">목록으로</a>
		<div class="pull-right">
			<c:if test="${id eq dto.writer }">
				<a href="private/update_form.do?num=${dto.num }">수정</a>
				<a href="javaScript:deleteConfirm()" style="padding-left: 10px;">삭제</a>
				<script>
					function deleteConfirm(){
						var isDelete=confirm("정말 삭제하시겠습니까?");
						if(isDelete){
							location.href="private/delete.do?num=${dto.num}";
						}
					}
				</script>
			</c:if>
		</div>
		
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
			var isGoLogin=confirm("로그인이 필요합니다.");
			if(isGoLogin){ // 로그인 페이지로 이동하기
				location.href="${pageContext.request.contextPath}/users/login_form.do?"
						+ "url=${pageContext.request.contextPath}/cafe/detail.do?num=${dto.num}";
			}
			return false; // 폼 전송 막기
		}
	})
	
	// 대댓글달기 버튼을 누른 경우 폼 보여주기
	$(".reply_btn").click(function(){
		if($(this).text()=="댓글"){
			$(this).text("취소");
		} else{
			$(this).text("댓글");
		}
		$(this).siblings(".reply_form").slideToggle();
	})
	// 댓글 수정 버튼을 누른 경우 폼 보여주기
	$(".update_btn").click(function(){
		$(this).siblings(".update_form").slideToggle();
	})
	// 댓글 삭제를 확인하는 함수
	function deleteCommentConfirm(replyNum,pageNum){
		var isDelete=confirm("댓글을 삭제하시겠습니까?");
		if(isDelete){
			location.href="comment_delete.do?replyNum="+replyNum+"&pageNum="+pageNum;
		}
	}
	
	
</script>
</body>
</html>