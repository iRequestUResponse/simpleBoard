<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.dbConnection.service.BoardService"%>
<%@page import="kr.or.ddit.dbConnection.service.IBoardService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	IBoardService boardService = new BoardService();
	List boardList = boardService.selectAll();
	pageContext.setAttribute("boardList", boardList);
%>
<style>
    aside {
        float: left;
        background: #e4eaec;
        color: #585858;
        width: 200px;
        height: calc(100vh - 80px);
    }
    
    aside a {
    	text-decoration: none;
    	color: #3287FC;
    }
    
    aside ul {
    	list-style: none;
    }
</style>
<aside>
	<a href="${ cp }/boardManagement">게시판 생성</a>
	<ul>
		<c:forEach var="board" items="${ boardList }">
		<li><a href="${ cp }/board?board_id=${ board.BOARD_ID }&page=1&pageSize=10">${ board.BOARD_NAME }</a></li>
		</c:forEach>
	</ul>
</aside>