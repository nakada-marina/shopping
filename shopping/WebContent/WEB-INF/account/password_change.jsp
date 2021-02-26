<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="bean.AccountBean" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ショッピングサイト</title>
<link href="${pageContext.request.contextPath}\css\menu.css" rel="stylesheet">
</head>
<body>
	<div id="wrapper">
   	 <div class="top-column"><%@ include file="/WEB-INF/header.jsp"%></div>
		<div class="left-column"><%@ include file="/WEB-INF/menu.jsp"%></div>
		<div class="right-column">
			<h4>パスワードを再設定します。</h4>
			<div style="float:left;">現在のパスワード :<br>パスワード :&nbsp;&nbsp;&nbsp;</div>
			<form action="/shopping/password_change" method="post">
				<div>
					<input type="text" name="rePassword" required placeholder="PASS" maxlength="15"><br>
					<input type="password" name="newPassword" required placeholder="PASS" maxlength="15"><br><br>
				</div>
				<button name="password_change" value="password_change">変更</button>
			</form>
			<a href="show_account_change?click=1">戻る</a><br>
		</div>
	</div>
</body>
</html>

