<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="bean.AccountBean" %>
<%
// Get_SessionScope
AccountBean account = (AccountBean)session.getAttribute("account");
%>
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
<h4>アカウント情報を変更します</h4>
<div style="float:left;">E-mail :<br>姓 ：<br>名:<br>郵便番号：<br>住所：<br>電話番号：<br>管理者:</div>
<form action="/shopping/account_delete" method="post">
<div>
	${account.getE_mail()}<br>
	${account.getFamily_name()}<br>
	${account.getName()}<br>
	${account.getPostal_code()}<br>
	${account.getAddress()}<br>
	${account.getPhone_number()}<br>
	<input type="checkbox" id="authority" disabled><br><br>
</div>
<button name="account_delete" value="account_delete">削除</button>
<input type="text" value="${account.getUser_id()}" name="id" placeholder="姓" maxlength="15" hidden><br>
</form>
<form action="/shopping/index" method="post">
<button name="buttonType" value="account_management">戻る</button>
</form>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
const authority = '<%=account.getAuthority() %>';
if(authority == 1){
	document.getElementById("authority").checked = true;
}
</script>