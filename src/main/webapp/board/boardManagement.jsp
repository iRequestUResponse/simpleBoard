<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <title>Document</title>
</head>
<style>
    body {
        margin: 0;
        font-family: 'Noto Sans KR', sans-serif;
    }

    section {

    }
</style>
<body>
	<jsp:include page="/common/header.jsp">
		<jsp:param value="게시판 관리" name="title"/>
	</jsp:include>
	<jsp:include page="/common/left.jsp"></jsp:include>
	<section>
		<div>
			<form action="${ cp }/boardManagement" method="POST">
				<input type="hidden" name="type" value="create">
				<span>게시판 이름</span> <input name="board_name">
				<select name="board_use">
					<option value="Y">사용</option>
					<option value="N">미사용</option>
				</select>
				<button type="submit">생성</button>
			</form>
		</div>
		<c:forEach items="${ boardList }" var="board">
		<div>
			<form action="${ cp }/boardManagement" method="POST">
				<input type="hidden" name="type" value="modify">
				<input type="hidden" name="board_id" value="${ board.BOARD_ID }">
				<input type="hidden" name="userId" value="${ board.USERID }">
				<span>게시판 이름</span> <input name="board_name" value="${ board.BOARD_NAME }">
				<select name="board_use">
					<option value="Y" ${ board.BOARD_USE == 'Y' ? "selected" : "" }>사용</option>
					<option value="N" ${ board.BOARD_USE == 'N' ? "selected" : "" }>미사용</option>
				</select>
				<button type="submit">수정</button>
			</form>
		</div>
<%-- 		${ board.BOARD_ID } ${ board.BOARD_NAME } ${ board.BOARD_USE } ${ board.USERID } ${ board.BOARD_TIME }<br> --%>
		</c:forEach>
	</section>
</body>
</html>