<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 작성</h1>
	<form action="/brd/insert" method="post">
	title : <input type="text" name="title"> <br>
	writer : <input type="text" name="writer" value="${ses.id }" readonly="readonly"> <br>
	content : <textarea rows="10" cols="30" name="content"></textarea> <br>
	<button type="submit">작성</button>
	</form>
	<a href="/index.jsp"><button type="button">이전페이지</button></a>
</body>
</html>