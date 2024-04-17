<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보 수정</h1>
	<form action="/mem/update" method="post">
		아이디 : <input type="text" name="id" value="${ses.id }" readonly="readonly"> <br>
		패스워드 : <input type="password" name="pwd" value="${ses.pwd }"> <br>
		이메일 : <input type="text" name="email" value="${ses.email }"> <br>
		나이 : <input type="text" name="age" value="${ses.age }"> <br>
		연락처 : <input type="text" name="phone" value="${ses.phone }"> <br>
		가입일 : <input type="text" name="regdate" value="${ses.regdate }" disabled="disabled"> <br>
		최근방문일 : <input type="text" name="lastlogin" value="${ses.lastlogin }" disabled="disabled"> <br>
	<button type="submit">수정</button> <br>
	</form>
	<a href="/mem/delete?id=${mvo.id }"><button type="button">회원탈퇴</button></a> <br>
	<a href="../index.jsp"><button type="button">이전페이지</button></a>
	
	<script type="text/javascript">
		const msg_update = `<c:out value="${msg_update}"/>`;
		console.log(msg_update);
		if(msg_update === '실패'){
			alert("회원정보 수정 실패")
		}
	</script>
</body>
</html>