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
<h4>イメージの新規登録</h4>
<form action="/shopping/image_regist" enctype="multipart/form-data" method="post">
	<input type="file" name="file" accept=".png, .jpg, .jpeg, .pdf, .doc"/>
<div>
	<button name="buttonType" value="do_image_regist">イメージを登録</button>
</div>
<div>
</div>
<table border="1">
	<c:forEach var="image" items="${imageList}">
		<tr>
		<td><img src="${image.url}"width="100px" height="100px"></td>
		</tr>
	</c:forEach>
</table>
</form>
</div>
</div>
</body>
</html>
