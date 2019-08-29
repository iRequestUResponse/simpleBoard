<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    header {
        height: 80px;
        background: linear-gradient(90deg, #e9ecf9, #f3dfdf);
        text-align: center;
        color: #585858;
        font-weight: bold;
        font-size: 48px;
    }
    
    .login,
    .logout {
    	position: absolute;
    	right: 0;
    	top: 0;
    }
    
    .login a,
    .logout a {
    	text-decoration: none;
    	color: grey;
    	font-size: 16px;
    }
</style>
<header>
	<span>${ param.title }</span>
	<c:choose>
	<c:when test="${ user == null }">
		<div class="login"><a href="${ cp }/login">login</a></div>
	</c:when>
	<c:otherwise>
		<div class="logout"><a href="${ cp }/logout">logout</a></div>
	</c:otherwise>
	</c:choose>
</header>