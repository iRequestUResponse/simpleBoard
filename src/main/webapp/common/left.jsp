<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
    aside {
        float: left;
        background: #e4eaec;
        color: #585858;
        width: 200px;
        height: calc(100vh - 80px);
    }
</style>
<aside>
	<ul>
		<li><a>게시판 생성</a></li>
		<c:forEach items="${ boardList }" var="board">
		<li><a>${ board }</a></li>
		</c:forEach>
	</ul>
</aside>