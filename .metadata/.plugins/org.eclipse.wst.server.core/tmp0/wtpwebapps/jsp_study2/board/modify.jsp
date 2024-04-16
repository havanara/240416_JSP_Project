<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 수정</h1>
	<form action="/brd/update" method="post">
		<table border="1">
			<tr>
				<th>순번</th>
				<td><input type="text" name="bno" value="${bvo.bno }" readonly="readonly"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${bvo.title }"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="${bvo.writer }" readonly="readonly"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="30" name="content">${bvo.content }</textarea></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><input type="text" name="regdate" value="${bvo.regdate }" readonly="readonly"></td>
			</tr>
			<tr>
				<th>수정일</th>
				<td><input type="text" name="moddate" value="${bvo.moddate }" readonly="readonly"></td>
			</tr>
		</table>
		<button type="submit">수정</button>
	</form>
	<a href="/brd/list"><button type="button">목록</button></a>
</body>
</html>