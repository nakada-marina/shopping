<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
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
<h4>アカウント登録</h4>
<form action="/shopping/doRegist" method="post">
<div style="float:left;">E-mail :<br>姓 ：<br>名:<br>郵便番号：<br>住所：<br>電話番号：<br>管理者:</div>
<div>
	<input type="text" name="mail" required placeholder="メールアドレス" maxlength="15"><br>
	<input type="text" name="family_name" placeholder="姓" maxlength="15"><br>
	<input type="text" name="name" placeholder="名" maxlength="15"><br>
	<input type="text" name="postal_code" placeholder="郵便番号" maxlength="15"><br>
	<input type="text" name="address" placeholder="住所" maxlength="15"><br>
	<input type="text" name="phone_number" placeholder="電話番号" maxlength="15"><br>
	<input type="checkbox" name="uthority"><br><br>
</div>
<br>
<div style="float:left;">パスワード：<br>パスワードの再入力：<br></div>
<div>
	<input type="password" name="password" placeholder="パスワード" maxlength="15"><br>
	<input type="password" name="rePassword" placeholder="パスワードの再入力" maxlength="15"><br><br>
</div>
<button name="doRegist" value="doRegist">登録</button><br>
</form>
<form action="/shopping/index" method="post">
<button name="back" value="back">戻る</button>
</form>
		</div>
	</div>
</body>
</html>