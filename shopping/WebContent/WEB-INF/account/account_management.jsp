<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h4>アカウント管理</h4>
<form action="/shopping/account_management" method="post">
<button name="buttonType" value="account_change">アカウント情報を変更する</button>
</form>
<form action="/shopping/account_management" method="post">
<button name="buttonType" value="password_change">パスワードを変更する</button>
</form>
<form action="/shopping/account_management" method="post">
<button name="buttonType" value="account_delete">アカウントを削除する</button>
</form>
<br>
		</div>
	</div>
</body>
</html>

