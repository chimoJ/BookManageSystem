<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	String flag = request.getParameter("flag");
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path;
%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书后台管理登录界面</title>
<script type="text/javascript">
    var flag = '<%=flag %>';
    if("1"==flag){
    	alert("请登录系统！");
    }
</script>
</head>
<body>
<%
String username="";
if(session.getAttribute("UserName")!=null){
    username=(String)session.getAttribute("UserName");//注册后在登录界面中直接显示用户名
}
String msg="";
if(request.getAttribute("msg")!=null) {
	       msg=(String)request.getAttribute("msg");
}
String msg1="";
if(request.getAttribute("msg1")!=null) {
    msg1=(String)request.getAttribute("msg1");
}
%>
	<center>
	    <h3><font color="red" align="center"><%= msg %></font></h3>
	     <h3><font color="red" align="center"><%= msg1 %></font></h3>
		<h1>登录 | <a href="<%=basePath%>/regist.jsp">注册</a></h1>
		<form action="<%=basePath%>/LoginServlet" method="post">
			<table width="350px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" value="<%=username%>" placeholder="用户名为3-12位字母数字或下划线组合" ></td>
				</tr>
				<tr>
					<td>密&nbsp;码</td>
					<td><input type="password" name="password" placeholder="长度为6-12位的纯数字" ></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="登录">
						<input type="reset" value="取消">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
