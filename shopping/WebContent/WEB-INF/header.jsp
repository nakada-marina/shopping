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
<a href="account_management">アカウント管理画面</a>
<!-- ログアウト時。 -->
<a href="login.jsp">ログアウトする</a>
<span>いらっしゃいませ${account.getName()}さん！</span>
<%} else {%>
<a href="account_regist.jsp">アカウントを登録する</a>
<a href="login.jsp">ログインする</a>
<span>いらっしゃいませ！</span>
<%}%>
<br><br>
