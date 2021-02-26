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
<form action="/shopping/account_change" method="post">
<div>
	${account.getE_mail()}<br>
	<input type="text" value="${account.getFamily_name()}" name="family_name" placeholder="姓" maxlength="15"><br>
	<input type="text" value="${account.getName()}" name="name" placeholder="名" maxlength="15"><br>
	<input type="text" value="${account.getPostal_code()}" name="postal_code" placeholder="郵便番号" maxlength="15"><br>
	<input type="text" value="${account.getAddress()}" name="address" placeholder="住所" maxlength="15"><br>
	<input type="text" value="${account.getPhone_number()}" name="phone_number" placeholder="電話番号" maxlength="15"><br>
	<input type="checkbox" id="authority" disabled><br><br></div>
<button name="account_change" value="account_change">変更</button>
<input type="text" value="${account.getUser_id()}" name="id" placeholder="姓" maxlength="15" hidden><br>
</form>
<a href="show_account_change?click=1">戻る</a><br>
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