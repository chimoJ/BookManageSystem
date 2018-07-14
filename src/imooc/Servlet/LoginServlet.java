package imooc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imooc.domain.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String UserName1=request.getParameter("username");//get from login.jsp
		String PassWord1=request.getParameter("password");//get from login.jsp
		//从servlet context 中接受list，遍历找到相对应的username
	    List<User> list=(List<User>) this.getServletContext().getAttribute("list");
	    if(list==null) {
	      	request.setAttribute("msg1", "请先注册！");
	      	request.getRequestDispatcher("/index.jsp").forward(request,response);
	    }
	    for(User u:list) {
			//判断用户名和密码是否正确
			if(UserName1.equals(u.getUsername())) {
				if(PassWord1.equals(u.getPassword())) {
					request.getSession().setAttribute("LoginUser", u.getUsername());
					response.sendRedirect("/LibraryManageSystem/BookManage/server.jsp");return;
				}
			}
	    }
	    request.setAttribute("msg", "登录名或者密码错误！");
		request.getRequestDispatcher("/index.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
