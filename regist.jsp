<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>注册界面</title>
</head>
<script>
        //两次密码比对
        var check = function(value){
            var password1st = document.getElementById("password").value;
            if(value == password1st)
                ;
            else
                alert("两次输入的密码不一致");
        };
</script>
<body>
	<center>
	 <%
           String msg="";
           if(request.getAttribute("msg")!=null){
        	      msg= (String)request.getAttribute("msg");
           }
         %>
        <h3 align="center"><font color="red"><%=msg %></font></h3>
		<h1>用户注册</h1>
		<form action="<%=basePath%>/RegisteServlet" method="post">
			<table width="400px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" pattern="[a-zA-Z_]{3,12}" placeholder="用户名为3-12位字母数字或下划线组合" ></td>
				</tr>
				<tr>
					<td>密&nbsp;码</td>
					<td><input type="password" name="password" pattern="[0-9]{6,12}" placeholder="密码长度为6-12位的纯数字"  id="password"></td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><input type="password" name="checkPWD" onblur="check(this.value)" placeholder="请再次输入密码" "></td>
				</tr>
				<tr>
					<td>手机号码</td>
					<td><input type="text" name="phone" pattern="1[3578]\d{9}" placeholder="请输入正确的手机号码格式" ></td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td><input type="email" name="email" pattern="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$" placeholder="请输入正确邮箱格式" required="required"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="注册">
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</center>
	
</body>
</html>
