<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/users/signup_form.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<div class="container">
		<h3>회원 가입 페이지 입니다.</h3>
	<form action="signup.do"  method="post" class="form" id="signupForm">
		<label for="id">아이디</label>
		<input type="text" name="id" id="id"/><br />
		<span id="checkResult"></span><br />
		<label for="pwd">비밀번호</label>
		<input type="password" name="pwd" id="pwd"/><br />
		<label for="email">이메일</label>
		<input type="text" name="email" id="email"/><br />
		<button type="submit" class="btn">가입</button>
	</form>
</div>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.js"></script>
<script>
	// 폼의 유효성 여부
	var formValid=false;
	$("#signupForm").submit(function(){
		if(formValid==false){ // 만일 폼의 유효성 여부가 false 이면
			return false; // 폼 전송 막기
		}
	})
	
	// 아이디 입력란에 입력했을 때 실행할 함수 등록
	$("#id").on("input",function(){
		// 입력한 아이디를 읽어와서
		var inputId=$(this).val();
		console.log(inputId);
		// ajax 요청을 이용해서 서버에 보낸다.
		// ajax는 페이지 이동 없이 백그라운드로 요청이 일어 남
				// -> 서버 이동 없이 데이터를 서버로 요청을 보내고, 응답을 받고 싶을 때 사용
		// 서버 입장에서는 같은 요청이지만 클라이언트의 응답 방식에 차이가 있다.
		$.ajax({
			url:"checkid.do",
			method:"post",
			data:{inputId:inputId},
			success:function(responseData){
				// checkid.jsp 에서 응답한 내용은 함수로 받아 짐. responseData 인자로 들어 옴
				// 응답 형식은 checkid.jsp 에서
				// 뭐가 응답되는지 콘솔에 출력해보기
				console.log(responseData.canUse);
				
				// responseDate는 object이다.
				// {canUse:true} 또는 {canUse:false}
				if(responseData.canUse){
					$("#checkResult")
					.text("사용 가능한 아이디입니다!")
					.css("color","#0000ff");
					formValid=true;
				} else{
					$("#checkResult")
					.text("사용 불가능한 아이디입니다!")
					.css("color","#ff0000");
					formValid=false;
				}
			}
			
		});
	});
</script>
</body>
</html>