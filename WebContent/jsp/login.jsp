<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../header.html" %>

<h1>ログイン画面</h1>
<p>${error}</p>
<form action="../jp.co.aforce/servlet/login-servlet" method="post">

	ログインID(名前): <input type="text" name="user_name" required><br>

	パスワード : <input type="password" name="password" required><br>

	<button type="submit">ログイン</button>

</form>
<%@include file="../footer.html" %>