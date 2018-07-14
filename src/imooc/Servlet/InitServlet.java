package imooc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import imooc.domain.Book;
import imooc.domain.User;
import java.util.*;
/**
 * 用户注册初始化servlet
 */
public class InitServlet extends HttpServlet {
  public void init() throws ServletException{
	 //创建一个list用于保存用户的注册信息
	  List<User> list=new ArrayList<>();//存放user类的初始化
	  this.getServletContext().setAttribute("list", list);
	 
  }
}
