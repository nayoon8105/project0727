<%@page import="test.file.dao.FileDao"%>
<%@page import="test.file.dto.FileDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/file/list.jsp</title>
</head>
<body>
<%
	List<FileDto> list=FileDao.getInstance().getList();
%>
<a href="private/upload_form.jsp">새파일 업로드</a>
<h3>파일 목록 입니다.</h3>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>파일명</th>
			<th>다운로드 횟수</th>
			<th>등록일</th>
		</tr>	
	</thead>
	<tbody>
		<%for(FileDto tmp:list){ %>
		<tr>
			<td><%=tmp.getNum() %></td>
			<td><%=tmp.getWriter() %></td>
			<td><%=tmp.getTitle() %></td>
			<td><%=tmp.getOrgFileName() %></td>
			<td><%=tmp.getDownCount() %></td>
			<td><%=tmp.getRegdate() %></td>
		</tr>
		<%} %>
	</tbody>
</table>
</body>
</html>

















