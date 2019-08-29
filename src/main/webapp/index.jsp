<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<jsp:param value="메인화면" name="title"/>
	</jsp:include>
	<jsp:include page="/common/left.jsp"></jsp:include>
<!--     <section>Hello world</section> -->
    
<%--     <jsp:include page="/board/pagination.jsp"> --%>
<%--     	<jsp:param value="${ param.page }" name="page"/> --%>
<%--     	<jsp:param value="${ param.pageSize }" name="pageSize"/> --%>
<%--     	<jsp:param value="5" name="pageLength"/> --%>
<%--     </jsp:include> --%>
</body>
</html>