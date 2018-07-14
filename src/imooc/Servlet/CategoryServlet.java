package imooc.servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	public List<HashMap<String,String>> catelist;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String id=(String)request.getParameter("id");
	    String catgoryName=(String)request.getParameter("catgoryName");
	    String description=(String)request.getParameter("description");
	    catelist = (List<HashMap<String, String>>) request.getSession().getAttribute("catelist");
	    if(catelist==null) {
	      	catelist= new ArrayList<>();
	     	HashMap<String,String> map= new HashMap<>();
	    	    map.put("id",id);map.put("catgoryName", catgoryName);map.put("description", description);
	        catelist.add(map);
	    	   
	    }
	    else {
	    	    for(HashMap<String,String> category: catelist) {
	    	    	   if(category.get("catgoryName").equals(catgoryName)) {
		    	    	    category.put("id", id);
		    	    	    category.put("description", description);return;
		    	    }
	    	      }
	    	    	   HashMap<String,String> map= new HashMap<>();
			   map.put("id",id);map.put("catgoryName", catgoryName);map.put("description", description);
			   catelist.add(map);
	    	 	
	    }
	    for(HashMap<String,String> cate:catelist) {
	    	  System.out.println(cate.get("catgoryName"));
	    }
	    request.getSession().setAttribute("catelist", catelist);
	    response.sendRedirect(request.getContextPath()+"/BookManage/category.jsp");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
