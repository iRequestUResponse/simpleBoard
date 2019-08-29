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
    
    header .login,
    header .logout {
    	position: absolute;
    	right: 0;
    	top: 0;
    }
    
    header .login a,
    header .logout a {
    	color: grey;
    	font-size: 16px;
    }
    
    header a {
    	text-decoration: none;
        color: #585858;
    }
</style>
<header>
	<span><a href="${ cp }/">${ param.title }</a></span>
	<c:choose>
	<c:when test="${ user == null }">
		<div class="login"><a href="${ cp }/login">login</a></div>
	</c:when>
	<c:otherwise>
		<div class="logout"><a href="${ cp }/logout">logout</a></div>
	</c:otherwise>
	</c:choose>
</header>