<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="bean.AccountBean" %>
<%
// Get_SessionScope
AccountBean name = (AccountBean)session.getAttribute("account");
%>
<h1>ショッピングサイト</h1>
<% if(!(name == null)) {%>
<form action="/shopping/index" method="post">
<button name="buttonType" value="account_management">アカウント管理</button>
</form>
<form action="/shopping/index" method="post">
<button name="buttonType" value="logout">ログアウトする</button>
</form>
<span>いらっしゃいませ${account.getName()}さん！</span>
<%} else {%>
<form action="/shopping/index" method="post">
<button name="buttonType" value="index">アカウントを登録する</button>
</form>
<form action="/shopping/index" method="post">
<button name="buttonType" value="index">ログインする</button>
</form>
<span>いらっしゃいませ！</span>
<%}%>
<br><br>
