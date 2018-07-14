package imooc.servlet;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import imooc.domain.Book;

/**
 * Servlet implementation class searchBook
 */
@WebServlet("/searchBook")
public class searchBook extends HttpServlet {
	public List<Book> booklist;
	public List<Book> result;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookID = request.getParameter("bookID");
		String bookName = request.getParameter("bookName");
		String catgoryName = request.getParameter("catgoryName");
		//System.out.println("bookID "+bookID+"bookName "+bookName+" catgoryName "+catgoryName);
		if(request.getSession().getAttribute("booklist")!=null) {
			 booklist= (List<Book>) request.getSession().getAttribute("booklist");
		}
		result=new ArrayList<>();
		for(Book b: booklist) {
			if(b.getBookname().equals(bookName)||b.getCatgoryName().equals(catgoryName)||(b.getId()+"").equals(bookID))
				result.add(b);
		}
		for(Book b:result) {
			System.out.println(b.toString());
		}
		//JSONObject jsonobject= new JSONObject("{flag:true}");
		JSONArray jsonarray= new JSONArray(result);
		//response.getOutputStream().write(jsonobject.toString().getBytes("UTF-8"));
		response.getOutputStream().write(jsonarray.toString().getBytes("UTF-8"));
		//response.sendRedirect(request.getContextPath()+"/BookManage/searchBooks.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
