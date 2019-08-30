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
    
    section .writeComment textarea {
    	resize: none;
    }
</style>
<body>
	<jsp:include page="/common/header.jsp">
		<jsp:param value="메인화면" name="title"/>
	</jsp:include>
	<jsp:include page="/common/left.jsp"></jsp:include>
    <section>
    	<div><div class="name">제목</div><div class="value">${ post.POST_TITLE }</div></div>
    	<div><div class="name">글내용</div><div class="value">${ content }</div></div>
    	<div>
    		<div class="name">첨부파일</div>
    		<div class="value">
    			<c:forEach items="${ attList }" var="att">
    				<a href="${ cp }/download?file=${ att.ATT_PATH }">${ att.ATT_NAME }</a>
    			</c:forEach>
    		</div>
  		</div>
    	<div>
    		<div class="name">댓글</div>
    		<div class="value">
    			<div class="comments">
	    			<c:forEach items="${ cmtList }" var="cmt">
	    			<p class="comment">
	    			${ cmt.CMT_CONT }
	    			<span class="cmtTime" data-time="${ cmt.CMT_TIME }"></span>
	    			<c:if test="${ cmt.USERID == user.userId }">
		    			<a>덧글 삭제</a>
	    			</c:if>
	    			</p>
	    			</c:forEach>
    			</div>
		    	<script>
		    		var cmts = document.querySelectorAll('.cmtTime');
		    		Array.prototype.forEach.call(cmts, function(e) {
		    			e.innerText = e.dataset.time.substring(0, 10);
		    		});
		    	</script>
    			<div class="writeComment">
	    			<form method="POST">
	    				<textarea rows="4" cols="100" name="commentContent"></textarea>
	    				<button type="submit">덧글 등록</button>
	    			</form>
    			</div>
    		</div>
   		</div> 
  		<div>
  		<a>답글 쓰기</a> | 
  		<c:if test="${ user.userId == post.USERID }">
  			<a href="${ cp }/postForm?board_id=${ post.BOARD_ID }&post_id=${ post.POST_ID }">글 수정</a> | 
  			<a href="${ cp }/postDelete?post_id=${ post.POST_ID }">글 삭제</a>
  		</c:if>
  		</div>
    </section>
</body>
</html>