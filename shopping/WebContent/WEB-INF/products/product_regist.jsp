<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%
%>
<h4>商品の新規登録</h4>
<form action="/shopping/product_regist" method="post">
<div style="float:left;">商品名 :<br>商品説明 ：<br>価格:<br>イメージ：</div>
<div>
	<input type="text" name="product_name" placeholder="商品名" maxlength="15"><br>
	<input type="text" name="info" placeholder="商品説明" maxlength="15"><br>
	<input type="text" name="price" placeholder="価格" maxlength="15"><br>
	<select name="image">
		<c:forEach var="product" items="${productList}">
		<option label="${product.name}" value ="${product.name}"></option>
		</c:forEach>
	</select>
	<br><br>
	<button name="buttonType" value="product_regist">商品の登録</button>
</div>
</form>
<form action="/shopping/image_regist" enctype="multipart/form-data" method="post">
	<button name="buttonType" value="image_regist">イメージを追加する</button>
</form>