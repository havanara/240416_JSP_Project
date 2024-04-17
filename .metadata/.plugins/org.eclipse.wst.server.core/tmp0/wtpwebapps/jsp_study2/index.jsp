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
	<h1>My JSP Project TEST</h1>	
	<c:if test="${ses.id eq null }">
		<form action="/mem/login" method="post">
		아이디 : <input type="text" name="id"> <br>
		비밀번호 : <input type="password" name="pwd"> <br>
		<br>
		<button type="submit">로그인</button> <br>
		<a href="/mem/join">회원가입</a>
		</form>
	</c:if>
	<c:if test="${ses.id ne null }">
		${ses.id }님이 로그인 하셨습니다. <br>
		<br>
		최근 활동일 : ${ses.regdate } <br>
		최근 접속일 : ${ses.lastlogin } <br>
		<br>
		<a href="/brd/register"><button>게시글 작성</button></a>
		<a href="/brd/list"><button>게시글 목록</button></a> <br>
		<a href="/mem/list"><button>회원리스트</button></a> <br>
		<br>
		<h3>마이페이지</h3>
		<a href="/mem/modify?id=${ses.id }"><button>회원정보수정</button></a> <br>
		<a href="/mem/logout"><button>로그아웃</button></a> <br>
	</c:if>
	
	<script type="text/javascript">
		const msg_register = `<c:out value = "${msg_register}" />`;
		console.log(msg_register);
		if(msg_register === '성공'){
			alert("회원가입이 완료되었습니다.")
		}
		
		const msg_login = `<c:out value="${msg_login }"></c:out>`;
		console.log(msg_login);
		if(msg_login === '-1'){
			alert("로그인 정보가 일치하지 않습니다.");
		}
		
		const msg_update = `<c:out value = "${msg_update}" />`;
		console.log(msg_update);
		if(msg_update === '성공'){
			alert("회원정보수정이 완료되었습니다. 다시 로그인하세요")
		}
		
		const msg_delete = `<c:out value = "${msg_delete}" />`;
		console.log(msg_delete);
		if(msg_delete === '성공'){
			alert("회원 탈퇴가 완료되었습니다.")
		}
	</script>
	
</body>
</html>