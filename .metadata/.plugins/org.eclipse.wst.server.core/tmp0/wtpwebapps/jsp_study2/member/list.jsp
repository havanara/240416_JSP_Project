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
	<h1>회원 목록</h1>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>나이</th>
			<th>연락처</th>
			<th>가입일</th>
			<th>최근방문일</th>
		</tr>
		
		<c:forEach items="${list }" var="mvo">
			<tr>
				<th>${mvo.id }</th>
				<th>${mvo.pwd }</th>
				<th>${mvo.email }</th>
				<th>${mvo.age }</th>
				<th>${mvo.phone }</th>
				<th>${mvo.regdate }</th>
				<th>${mvo.lastlogin }</th>
			</tr>
		</c:forEach>
	</table>
	<a href="/index.jsp"><button type="button">이전페이지</button></a>
</body>
</html>