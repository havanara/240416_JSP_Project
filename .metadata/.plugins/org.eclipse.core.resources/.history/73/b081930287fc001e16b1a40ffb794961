<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 목록</h1>
	<table border="1">
		<tr>
			<td>순번</td>
			<td>제목</td>
			<td>작성자</td>
			<td>내용</td>
			<td>작성일</td>
		</tr>
		
		<c:forEach items="${list }" var="bvo">
			<tr>
				<td>${bvo.bno }</td>
				<td><a href="/brd/detail?bno=${bvo.bno }">${bvo.title }</a></td>
				<td>${bvo.writer }</td>
				<td>${bvo.content }</td>
				<td>${bvo.regdate }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="../index.jsp"><button type="button">이전으로</button></a>
</body>
</html>