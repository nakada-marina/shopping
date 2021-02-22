<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="bean.AccountBean" %>
<%
// Get_SessionScope
String url = (String)request.getAttribute("url");
AccountBean reAccess = (AccountBean)session.getAttribute("account");
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
		<%if (url == "account_management") {%>
			<%@ include file="./WEB-INF/account_management.jsp" %>
		<%}else if (url == "account_regist") {%>
			<%@ include file="./WEB-INF/account_regist.jsp" %>
		<%}else if (url == "account_change") {%>
			<%@ include file="./WEB-INF/account_change.jsp" %>		
		<%}else if (url == "account_delete") {%>
			<%@ include file="./WEB-INF/account_delete.jsp" %>		
		<%}else if (url == "password_change") {%>
			<%@ include file="./WEB-INF/password_change.jsp" %>				
		<%}else if (url == "password_change") {%>
			<%@ include file="./WEB-INF/password_change.jsp" %>					
		<%}else if (url == "product_search") {%>
			<%@ include file="./WEB-INF/products\product_search.jsp" %>						
		<%}else if (url == "product_regist") {%>
			<%@ include file="./WEB-INF/products\product_regist.jsp" %>											
		<%}else if (url == "image_regist") {%>
			<%@ include file="./WEB-INF/products\image_regist.jsp" %>						
		<%}else if (url == "logout") {%>
			<%@ include file="./WEB-INF/login.jsp" %>
		<%}else if (!(reAccess == null)) {%>
			<%@ include file="./WEB-INF/account_management.jsp" %>
		<%} else {%>
			<%@ include file="./WEB-INF/login.jsp" %>
		<%}%>
		</div>
	</div>
</body>
</html>

