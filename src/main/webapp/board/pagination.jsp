<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
현재 페이지 : page
전체 페이지 : pageLength
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
		<c:when test="${ param.page > 1 }">
			<a class="link first" href="${ param.linkTo }?page=1&pageSize=${ param.pageSize }">&lt;&lt;</a>
			<a class="link first" href="${ param.linkTo }?page=${ param.page - 1 }&pageSize=${ param.pageSize }">&lt;</a>
		</c:when>
		<c:otherwise>
			<span class="link first">&lt;&lt;</span>
			<span class="link first">&lt;</span>
		</c:otherwise>
	</c:choose>
	<!-- pages... -->
	<c:choose>
		<c:when test="${ param.page < param.pageLength }">
			<a class="link last" href="${ param.linkTo }?page=${ param.page + 1 }&pageSize=${ param.pageSize }">&gt;</a>
			<a class="link last" href="${ param.linkTo }?page=${ param.pageLength }&pageSize=${ param.pageSize }">&gt;&gt;</a>
		</c:when>
		<c:otherwise>
			<span class="link last">&gt;</span>
			<span class="link last">&gt;&gt;</span>
		</c:otherwise>
	</c:choose>
</c:if>
</div>