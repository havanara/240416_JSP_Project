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
	<h1>게시글 상세내역</h1>
	<table border="1">
		<tr>
			<th>순번</th>
			<td>${bvo.bno }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${bvo.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${bvo.writer }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${bvo.content }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${bvo.regdate }</td>
		</tr>
		<tr>
			<th>수정일</th>
			<td>${bvo.moddate }</td>
		</tr>
	</table>
	
	<c:if test="${bvo.writer == ses.id}">
	<a href="/brd/modify?bno=${bvo.bno}"><button type="button">수정</button></a>
	<a href="/brd/delete?bno=${bvo.bno}"><button type="button">삭제</button></a>	
	</c:if>
	<a href="/brd/list"><button type="button">목록</button></a>
	
<!-- comment line -->
	<hr>
	<div>
		comment line <br>
		<input type="text" id="cmtWriter" value="${ses.id }" readonly="readonly"> <br>
		<input type="text" id="cmtText" placeholder="Add Comment..."> <br>
		<button type="button" id="cmtAddBtn">등록</button>
	</div> <br>
	<hr>
	
	<!-- 댓글 출력 라인 -->
	
	<div id="commentLine">
		<div>
			<div>cno, bno, writer, regdate</div>
			<div>
				<button>수정</button>
				<button>삭제</button>
				<input type="text" value="content">
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		const bnoVal = `<c:out value="${bvo.bno}" />`;
		const id = `<c:out value="${ses.id}" />`;
		console.log(bnoVal);
		console.log(id);
	</script>
	
	<script type="text/javascript" src="/resources/board_detail.js"></script>
	
	<!-- 선언된 이후에 실행(댓글출력) printCommentList(bnoVal); -->
	<script type="text/javascript">
    	printCommentList(bnoVal);
	</script>

</body>
</html>