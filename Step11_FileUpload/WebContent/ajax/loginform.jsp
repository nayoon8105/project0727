<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/ajax/loginform.jsp</title>
<style>
	.result{
		background-color: #000;
		color: #fff;
		border-radius: 10px;
		margin-top: 10px;
		font-weight: bold;
		font-size: 16px;
	}
</style>
</head>
<body>
<%
	//세션에 저장된 id 읽어오기
	String id=(String)session.getAttribute("id");
%>
<%if(id!=null){ %>
	<p>
		<strong><%=id %></strong>님 로그인중...
		<a href="">로그아웃</a> 
	</p>
<%} %>
<h3>jquery 를 활용한 ajax form 전송</h3>
<form action="login.jsp" method="post" id="myForm">
	<label for="id">아이디</label>
	<input type="text" name="id" id="id"/>
	<label for="pwd">비밀번호</label>
	<input type="text" name="pwd" id="pwd"/>
	<button type="submit">로그인</button>
</form>
<div class="result">

</div>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.js"></script>
<script>
	$("#myForm").submit(function(){
		//폼에 입력한 값을 serialize 문자열로 읽어내기
		// id=xxx?pwd=xxx ....
		var param=$(this).serialize();
		console.log(param);
		
		//ajax request 를 이용해서 폼에 입력한 내용 서버에 전송
		$.ajax({
			url:"login.jsp", //요청경로
			method:"post", //요청 메소드
			data: param, //요청 파라미터 
			success: function(responseData){ //응답 데이터 
				console.log(responseData);
				$(".result").text(responseData);
				//responseData 는 object 이다.
				if(responseData.isSuccess){
					alert("로그인 되었습니다.");
				}else{
					alert("아이디 혹은 비밀 번호가 틀려요.");
				}
			},
			error: function(xhr){
				$(".result").text(xhr.responseText);
			}
		});
		
		return false;//폼 전송 막기(페이지 전환 방지)
	});
</script>
</body>
</html>













