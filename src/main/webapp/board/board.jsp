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

    section .post {
		cursor: pointer;
    }
    
    section .post:hover {
    	color: #3287FC;
    }
    
    section table th:first-child {
/*     	width: 80px; */
    }
    
    section table th:nth-child(2) {
    	width: 400px;
    }
    
</style>
<body>
	<jsp:include page="/common/header.jsp">
		<jsp:param value="${ title }" name="title"/>
	</jsp:include>
	<jsp:include page="/common/left.jsp"></jsp:include>
    <section>
    	<table>
	    	<thead>
	    		<tr>
	    			<th>게시글 번호</th>
	    			<th>제목</th>
	    			<th>작성자 아이디</th>
	    			<th>작성일시</th>
	    		</tr>
	    	</thead>
	    	<tbody>
	    	<c:forEach items="${ postList }" var="post">
	    		<c:choose>
	    		<c:when test="${ post.POST_DEL == 'N' }">
	    		<tr class="post" data-postid="${ post.POST_ID }">
	    			<td>${ post.POST_ID }</td>
	    			<td><c:forEach begin="2" end="${ post.LEVEL }" var="blank"> </c:forEach>
	    			${ post.POST_TITLE }</td>
	    			<td>${ post.USERID }</td>
	    			<td data-time="${ post.POST_TIME }"></td>
	    		</tr>
	    		</c:when>
	    		<c:otherwise>
	    		<tr>
	    			<td>-</td>
	    			<td>[삭제된 게시글입니다]</td>
	    			<td>-</td>
	    			<td>-</td>
	    		</tr>
	    		</c:otherwise>
	    		</c:choose>
	    	</c:forEach>
	    	<script>
	    		var times = document.querySelectorAll('[data-time]');
	    		Array.prototype.forEach.call(times, function(e) {
	    			e.innerText = e.dataset.time.substring(0, 10);
	    		});
	    		
	    		var posts = document.querySelectorAll('.post');
	    		Array.prototype.forEach.call(posts, function(e) {
	    			var postId = e.dataset.postid;
	    			e.addEventListener('click', function() {
	    				location.replace('/post?post_id=' + postId);
	    			});
	    		});
	    	</script>
	    	</tbody>
    	</table>
	</section>
    
    <div class="wrapper">
		<jsp:include page="/util/pagination.jsp">
	    	<jsp:param value="${ param.page }" name="page"/>
	    	<jsp:param value="${ param.pageSize }" name="pageSize"/>
	    	<jsp:param value="${ pageLength }" name="pageLength"/>
	    </jsp:include>
	    
	    <a href="${ cp }/postForm?board_id=${ param.board_id }">새글 등록</a>
    </div>
</body>
</html>