<%@page import="test.member.dao.MemberDao"%>
<%@page import="test.member.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/member/list.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
</head>
<body>
<%
	// request에 담긴 회원목록 얻어오기
	List<MemberDto> list=(List<MemberDto>)request.getAttribute("list");
%>
<div class="container">
<a href="insertform.do">회원 추가</a>
<h3>회원 목록 입니다.</h3>
	<table class="table table-borderd">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>주소</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<%for(MemberDto tmp:list) {%>
				<tr>
					<td><%=tmp.getNum() %></td>
					<td><%=tmp.getName() %></td>
					<td><%=tmp.getAddr() %></td>
					<td><a href="updateform.do?num=<%=tmp.getNum()%>">수정</a></td>
					<td><a href="javascript:deleteConfirm(<%=tmp.getNum()%>)">삭제</a></td>
				</tr>
			<%} %>
		</tbody>
	</table>
<a href="${pageContext.request.contextPath}/home.do">Home</a>
</div>
<script>
	function deleteConfirm(num){
		var isDelete=confirm("정말 삭제하시겠습니까?");
		if(isDelete){
			location.href="delete.do?num="+num;
		}
	};
</script>
</body>
</html>