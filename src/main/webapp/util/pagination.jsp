<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
현재 페이지 : page
전체 페이지 수 : pageLength
페이지당 아이템 수 : pageSize
링크 주소 : linkTO
	==> "${ linkTo}?page=${ page }&pageSize=${ pageSize }"
--%>
<style>
.link {
	width: 1.6em;
	height: 1.6em;
	display: inline-block;
	text-align: center;
	background: #eee;
	border-radius: 1em;
	margin: 0.25em;
	user-select: none;
	-webkit-user-select: none;
	text-decoration: none;
}

a.link {
	color: #3287FC;
}

a.link:hover {
	background: #3287FC;
	color: #fdfdfd;
	cursor: pointer;
}
</style>
<div class="pagination">
<!-- pagination -->
<c:if test="${ param.page != null && param.pageSize != null && param.pageLength != null }">
	<c:choose>
		<c:when test="${ 0 + param.page > 1 }">
			<a class="link" href="${ param.linkTo }?page=1&pageSize=${ param.pageSize }">&lt;&lt;</a>
			<a class="link" href="${ param.linkTo }?page=${ param.page - 1 }&pageSize=${ param.pageSize }">&lt;</a>
		</c:when>
		<c:otherwise>
			<span class="link">&lt;&lt;</span>
			<span class="link">&lt;</span>
		</c:otherwise>
	</c:choose>
	<c:set var="least" value="${ param.page - (param.page - 1) % 10 }"/>
	<c:set var="_most" value="${ param.page + 9 - (param.page + 9) % 10 }"/>
	<c:set var="most" value="${ param.pageLength < _most ? param.pageLength : _most }"/>
	<c:forEach var="vPage" begin="${ least }" end="${ most }">
		<a class="link" href="${ param.linkTo }?page=${ vPage }&pageSize=${ param.pageSize }">${ vPage }</a>
	</c:forEach>
	<c:choose>
		<c:when test="${ 0 + param.page < param.pageLength }">
			<a class="link" href="${ param.linkTo }?page=${ param.page + 1 }&pageSize=${ param.pageSize }">&gt;</a>
			<a class="link" href="${ param.linkTo }?page=${ param.pageLength }&pageSize=${ param.pageSize }">&gt;&gt;</a>
		</c:when>
		<c:otherwise>
			<span class="link">&gt;</span>
			<span class="link">&gt;&gt;</span>
		</c:otherwise>
	</c:choose>
</c:if>
</div>