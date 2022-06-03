<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<p>ようこそ、<%= request.getParameter("user_name")%>さん！</p>

<%@include file="../footer.html" %>