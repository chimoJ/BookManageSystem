package imooc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/AuthFilter")
public class AuthFilter implements Filter {

    public AuthFilter() {
       
    }
	public void destroy() {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;//转型为httpservlet
		HttpServletResponse hresponse = (HttpServletResponse) response;
		String loginUser = (String) hrequest.getSession().getAttribute("LoginUser");
		if(loginUser==null) {
			hresponse.sendRedirect(hrequest.getContextPath() + "/index.jsp?flag=1");//未登录，要求用户先登录
			return;
		}
		else {
			chain.doFilter(hrequest, hresponse);
			return;
		}
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
