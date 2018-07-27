<%@page import="test.users.dao.UsersDao"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 이 밑에 내용은 signup_form의 ajax success function의 매개변수로 들어간다.
	jquery 에서 사용하므로 되도록 json을 사용하는게 좋다. 
			-> jquery에선 json을 자동으로 parse해서 function의 매개변수로 넣어준다.
--%>
{"canUse": ${canUse }}