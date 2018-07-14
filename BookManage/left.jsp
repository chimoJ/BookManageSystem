<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path;
%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书后台管理</title>
</head>
<body>
	<p><a href="<%=basePath%>/BookManage/category.jsp" target="main">分类添加</a></p>
	<p><a href="<%=basePath%>/BookManage/addBook.jsp" target="main">图书添加</a></p>
	<!-- <p><a href="<%=basePath%>/BookManage/showBooks.jsp" target="main">图书展示</a></p>-->
	<p><a href="<%=basePath%>/BookManage/searchBooks.jsp" target="main">图书查询</a></p>
</body>
</html>
