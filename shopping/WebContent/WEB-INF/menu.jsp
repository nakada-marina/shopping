<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h4>メインメニュー</h4>
<form action="/shopping/index" method="post">
<button name="buttonType" value="product_search">商品の検索</button>
</form>
<a href="/shopping/index.jsp?url=product_search">カートの中身を見る</a><br>
<a href="#">注文内容の確認</a><br>
<h4>管理者メニュー</h4>
<form action="/shopping/index" method="post">
<button name="buttonType" value="product_regist">商品の新規登録</button>
</form>