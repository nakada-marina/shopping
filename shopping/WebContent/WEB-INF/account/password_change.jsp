<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ショッピングサイト</title>
<link href="${pageContext.request.contextPath}\css\menu.css" rel="stylesheet">
</head>
<body>
<h4>パスワードを再設定します。</h4>
<div style="float:left;">現在のパスワード :<br>パスワード :&nbsp;&nbsp;&nbsp;</div>
<form action="/shopping/password_change" method="post">
<div>
	<input type="text" name="rePassword" required placeholder="PASS" maxlength="15"><br>
	<input type="password" name="newPassword" required placeholder="PASS" maxlength="15"><br><br>
</div>
<button name="password_change" value="password_change">変更</button>
</form>
<form action="/shopping/index" method="post">
<button name="buttonType" value="account_management">戻る</button>
</form>
		</div>
	</div>
</body>
</html>
