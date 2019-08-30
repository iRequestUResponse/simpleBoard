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
		float: left;
		width: calc(100% - 200px);
    }
</style>
<body>
	<!-- DEBUG BEGIN -->
   	<div style="position: fixed; left: 0; top: 0; z-index: 9999; background-color: #fff; color: #000;">
    	<c:if test="${!empty param.post_parent}">
    	${ param.post_parent }에 대한 답글입니다
    	</c:if>
   	</div>
   	<!-- DEBUG END -->
	<jsp:include page="/common/header.jsp">
		<jsp:param value="글쓰기" name="title"/>
	</jsp:include>
	<jsp:include page="/common/left.jsp"></jsp:include>
    <section>
    	<div>
    	<jsp:include page="/SE2/index.jsp">
    	<jsp:param value="${ param.board_id }" name="board_id"/>
    	</jsp:include>
    	</div>
    </section>
</body>
</html>