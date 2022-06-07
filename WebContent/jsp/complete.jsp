<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>

<p>ようこそ、${us.name} さん！</p>

<form action="../jp.co.aforce.servlet/logout-servlet" method="get">
<button type="submit">ログアウト</button>
</form>

<%@include file="../footer.html" %>