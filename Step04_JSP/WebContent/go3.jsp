<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("go3.jsp 에서 요청 처리중...");
	
	/*
		- forward 이동은 응답을 다른 jsp 페이지로 위임할때 사용한다.
		- forward 이동 경로는 context path 경로를 제외한 절대 경로를 
		  사용한다. (다른 Project 로 forward 이동 불가)
	*/
	
	pageContext.forward("/gura.jsp");
%>



