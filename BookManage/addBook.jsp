<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
<title>图书添加</title>
</head>
<body>
	<center>
	<%
           String msg="";
           if(request.getAttribute("msg")!=null){
        	      msg= (String)request.getAttribute("msg");
           }
         %>
        <h3 align="center"><font color="red"><%=msg %></font></h3>
		<h1>图书添加</h1>
		<form action="<%=basePath%>/AddBookServlet" method="post">
			<table width="400px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>图书ID</td>
					<td><input type="text" name="id" placeholder="请输入数字" pattern="\d+" required="required"></td>
				</tr>
				<tr>
					<td>图书名</td>
					<td><input type="text" name="bookName"></td>
				</tr>
				<tr>
					<td>图书分类</td>
					<td>
						<select name="catgoryName">
							<c:forEach items="${catelist }" var="map">
                                 <option value="${map.catgoryName }">${map.catgoryName }</option>
                             </c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>价格</td>
					<td><input type="text" name="price" pattern="\d+\.[0-9]+" placeholder="请输入价格" ></td>
				</tr>
				<tr>
					<td>描述</td>
					<td><input type="text" name="description" placeholder="请输入描述信息"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="添加">
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
