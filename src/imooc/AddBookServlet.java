package imooc.servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import imooc.domain.Book;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	public List<Book> booklist;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		String bookname= request.getParameter("bookName");
		String catgoryName= request.getParameter("catgoryName");
		String price= request.getParameter("price");
		String description= request.getParameter("description");
		booklist = (List<Book>) request.getSession().getAttribute("booklist");
		if(booklist==null) {
			booklist=new ArrayList<>();
		}
		else {
			  for(Book b:booklist) {
					if((b.getId()+"").equals(id)) {
						request.setAttribute("msg", "该id已经存在！");
						request.getRequestDispatcher("/BookManage/addBook.jsp").forward(request, response);
						return;
					}
			}
		}
		Book book= new Book();
		book.setBookname(bookname);
		book.setCatgoryName(catgoryName);
		book.setDescription(description);
		book.setId(Integer.parseInt(id));
		book.setPrice(price);
		booklist.add(book);
		Collections.sort(booklist, (a,b)-> a.getId()- b.getId());
		request.getSession().setAttribute("booklist", booklist);
		//JSONArray jsonarray= new JSONArray(booklist);
		//response.getOutputStream().write(jsonarray.toString().getBytes("UTF-8"));
		response.sendRedirect(request.getContextPath()+"/BookManage/searchBooks.jsp");
		//response.sendRedirect(request.getContextPath()+"/BookManage/searchBooks.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
