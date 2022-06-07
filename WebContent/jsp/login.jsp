<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../header.html" %>

<h1>ログイン画面</h1>

<form action="../jp.co.aforce.servlet/login-servlet" method="post">

	ログインID(名前): <input type="text" name="name" required><br>

	パスワード : <input type="password" name="password" required><br>

	<p>
	${error_msg}
	${user}
	</p>

	<button type="submit">ログイン</button>

</form>
<%@include file="../footer.html" %>