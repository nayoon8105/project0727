<%@page import="test.member.dao.MemberDao"%>
<%@page import="test.member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>member/update.jsp</title>
</head>
<body>
<%
	//폼 전송되는 한글 깨지지 않도록 
	request.setCharacterEncoding("utf-8");
	//폼 전송되는 수정할 회원의 정보를 읽어온다. 
	int num=Integer.parseInt(request.getParameter("num"));
	String name=request.getParameter("name");
	String addr=request.getParameter("addr");
	//MemberDao 객체를 이용해서 DB 에 수정반영
	MemberDto dto=new MemberDto(num, name, addr);
	MemberDao dao=MemberDao.getInstance();
	dao.update(dto);
	//응답하기 
%>
<p> <strong><%=num %></strong> 번 회원의 정보를 수정했습니다.</p>
<a href="list.jsp">목록 보기</a>
</body>
</html>









