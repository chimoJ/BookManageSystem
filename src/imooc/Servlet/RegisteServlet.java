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
 * Servlet implementation class RegisteServlet
 */
@WebServlet("/RegisteServlet")
public class RegisteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从request域中获取相关的信息
		String UserName=request.getParameter("username");
		String PassWord=request.getParameter("password");
		String Cellphone=request.getParameter("phone");
		String Email=request.getParameter("email");
		//获得servlet context的对象
		List<User> userList=(List<User>) this.getServletContext().getAttribute("list");
		//校验用户名
		if(userList!=null) {
			for(User useritem:userList) {
				if(useritem.getUsername().equals(UserName)) {
					request.setAttribute("msg", "该用户名已经存在！");
					request.getRequestDispatcher("/regist.jsp").forward(request, response);
					return;
				}
			}
		}
		User user = new User();
		user.setUsername(UserName);
		user.setPassword(PassWord);
		user.setEmail(Email);
		user.setCellphone(Cellphone);
		//将注册的信息存入到初始化的list中
		userList.add(user);
		//将更新好的list存回servletContext中
		this.getServletContext().setAttribute("list", userList);
		//注册成功 跳转到登录页面
		request.getSession().setAttribute("UserName", user.getUsername());
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
