<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%
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
<h4>商品の検索</h4>
<form action="/shopping/product_search" method="post">
<div style="float:left;">サーチ :&nbsp;&nbsp;&nbsp;<br></div>
<div>
	<input type="text" name="product_search" placeholder="なにをお探しですか？" maxlength="15">
	<button name="buttonType" value="product_search">検索</button>
</div>
<br><br>
<table border="0">
		<tr>
			<th bgcolor="#c68eff"><font color="#FFFFFF"></font></th>
			<th bgcolor="#c68eff"><font color="#FFFFFF">商品名</font></th>
			<th bgcolor="#c68eff"><font color="#FFFFFF">価格</font></th>
			<th bgcolor="#c68eff"><font color="#FFFFFF">説明</font></th>
		</tr>
	<c:forEach var="product" items="${productList}">
		<tr>
			<td><img src="${product.url}"width="100px" height="100px"></td>
			<td><c:out value="${product.name}" /></td>
			<td><c:out value="${product.price}" /></td>
			<td><c:out value="${product.info}" /></td>
		</tr>
	</c:forEach>
</table>
</form>
</div>
</div>
</body>
</html>
