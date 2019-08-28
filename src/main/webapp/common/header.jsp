<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
    header {
        height: 80px;
        background: linear-gradient(90deg, #e9ecf9, #f3dfdf);
        text-align: center;
        color: #585858;
        font-weight: bold;
        font-size: 48px;
    }
    
    .logout {
    	position: absolute;
    	right: 0;
    	top: 0;
    }
    
    .logout a {
    	text-decoration: none;
    	color: grey;
    	font-size: 16px;
    }
</style>
<header>
	<span>${ param.title }</span>
	<div class="logout"><a href="${ cp }/logout">logout</a></div>
</header>