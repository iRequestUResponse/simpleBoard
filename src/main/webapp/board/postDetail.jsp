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

    section .name,
    section .value {
        display: inline-block;
    }

    section .name {
		font-weight: bold;
		display: inline-block;
		width: 120px;
		text-align: right;
		padding-right: 2em;
    }
</style>
<body>
	<jsp:include page="/common/header.jsp">
		<jsp:param value="메인화면" name="title"/>
	</jsp:include>
	<jsp:include page="/common/left.jsp"></jsp:include>
    <section>
    	<div><div class="name">제목</div><div class="value">${ post.POST_TITLE }</div></div>
    	<div><div class="name">글내용</div><div class="value">${ post.POST_CONT }</div></div>
    	<div>
    		<div class="name">첨부파일</div>
    		<div class="value">
    			<c:forEach items="${ attList }" var="att">
    				${ att }
    			</c:forEach>
    		</div>
  		</div>
    	<div>
    		<div class="name">댓글</div>
    		<div class="value">${ null }</div>
   		</div>
    </section>
</body>
</html>