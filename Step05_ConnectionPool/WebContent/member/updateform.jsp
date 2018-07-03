<%@page import="test.member.dto.MemberDto"%>
<%@page import="test.member.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>member/updateform.jsp</title>
</head>
<body>
<%
	// /member/updateform.jsp?num=x
	
	//파라미터로 전달되는 수정할 회원의 번호 읽어오기
	int num=Integer.parseInt(request.getParameter("num"));
    //수정할 회원의 정보 읽어오기 
	MemberDao dao=MemberDao.getInstance();
    MemberDto dto=dao.getData(num);
%>
<h3>회원 정보 수정 폼 입니다.</h3>
<form action="update.jsp" method="post">
	<input type="hidden" name="num" value="<%=dto.getNum()%>"/>
	<label>번호</label>
	<input type="text" value="<%=dto.getNum()%>" disabled/><br/>
	<label for="name">이름</label>
	<input type="text" name="name" id="name" 
		value="<%=dto.getName() %>" /><br/>
	<label for="addr">주소</label>
	<input type="text" name="addr" id="addr" 
		value="<%=dto.getAddr()%>" /><br/>
	<button type="submit">수정확인</button>
</form>
</body>
</html>









