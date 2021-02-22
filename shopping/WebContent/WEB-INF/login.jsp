<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%
// Get_SessionScope
String errorFlg = (String)request.getAttribute("errorFlg");
%>
<h4>ログインしてください。</h4>
<form action="/shopping/dologin" method="post">
<c:if test="${errorFlg == '1' }" >
<div align="left"><font color="red">※　不正な入力です</font></div>
</c:if>
<c:if test="${empty errorFlg}">
  <br>
</c:if>
<div style="float:left;">E-mail :<br>パスワード :&nbsp;&nbsp;&nbsp;</div>
<div>
	<input type="text" name="mail" required placeholder="E-mail" maxlength="15"><br>
	<input type="password" name="password" required placeholder="PASS" maxlength="15"><br><br>
</div>
	<button name="login" value="login">ログインする</button>
</form>
<form action="/shopping/index" method="post">
<button name="buttonType" value="account_regist">アカウントを新規登録する</button>
</form>
