<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="imooc.domain.Book" %>
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
<title>图书查询</title>
<script type="text/javascript" src="<%=basePath%>/resources/js/jquery-1.4.2.js"></script>
</head>
<body>
	<center>
		<h1>图书查询</h1>
		<p>
			图书ID：<input type="text" name="bookID">
			图书名：<input type="text" name="bookName">
			分类：<input type="text" name="catgoryName">
			<input type="button" value="查询" id="search">
		</p>
		<hr>
		<table width="800px" cellspacing="0px" cellpadding="0px" border="1px">
			<thead>
				<tr>
					<th>图书ID</th>
					<th>书名</th>
					<th>分类</th>
					<th>价格</th>
					<th>描述</th>
				</tr>
			</thead>
			<tbody id="cont">
				   <c:forEach items="${booklist }" var="book">
					<tr>
						<td>${book.getId() }</td>
						<td>${book.getBookname() }</td>
						<td>${book.getCatgoryName() }</td>
						<td>${book.getPrice() }</td>
						<td>${book.getDescription() }</td>
					</tr>
				</c:forEach>   	     
		  </tbody>
		</table>
	</center>
</body>
<script type="text/javascript" >
$("#search").click(function(){
	//单击查询按钮的时候触发ajax事件
	$.ajax({
		url:"<%=basePath%>/searchBook",
		type:"post",
		data:{
			bookID:$("input[name=bookID]").val(),
			bookName:$("input[name=bookName]").val(),
			catgoryName:$("input[name=catgoryName]").val()
		},
		dataType:"json",
		success:function(result){//result里封装了servlet给ajax返回的结果
			  /*var flag=result.flag;
		      if(flag==true) {
		    	     //System.out.println("json返回成功！");
		    	     response.sendRedirect(request.getContextPath()+"/BookManage/showBooks.jsp");
		      }*/
			  var list= eval(result);
			  var s = null;
			  for (var i in list){
				  var id = list[i].id;
				  var bookName = list[i].bookname;
				  var bookCategory = list[i].catgoryName;
				  var price = list[i].price;
				  var description = list[i].description;
			  s = s+ "<tr><td>" + id +"</td><td>"+bookName+"</td><td>"+bookCategory+"</td><td>"+price+"</td><td>"+
			  description+ "</td></tr>";
			  $("#cont>tr").remove();
			  }
			  $("#cont").html(s);
			  }
	});
});
</script>
</html>
