<%@page import="test.member.dao.MemberDao"%>
<%@page import="test.member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//post 방식 전송 파라미터 한글 인코딩 설정
	request.setCharacterEncoding("utf-8");
	//폼전송되는 파라미터 추출
	String name=request.getParameter("name");
	String addr=request.getParameter("addr");
	//MemberDto 에 담아서
	MemberDto dto=new MemberDto();
	dto.setName(name);
	dto.setAddr(addr);
	//MemberDao 객체를 이용해서 DB 에 저장
	MemberDao dao=MemberDao.getInstance();
	dao.insert(dto);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>member/insert.jsp</title>
</head>
<body>
<p>회원 정보가 추가 되었습니다.</p>
<a href="list.jsp">목록보기</a>
</body>
</html>















