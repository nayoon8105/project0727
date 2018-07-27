<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 직접적인 응답은 하지 않고 Controller 를 타게 함
	String cPath=request.getContextPath();

	response.sendRedirect(cPath+"/home.do");
%>
