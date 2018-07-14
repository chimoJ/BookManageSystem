package imooc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
	private FilterConfig config;
	//销毁过滤器
	public void destroy() {
		System.out.println("CharacterEncoding Filter destroy ... ...");
	}
	//dofilter 关键方法
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
		//获得编码字符集filter
		request.setCharacterEncoding(config.getInitParameter("charset"));
		//System.out.println("characterEncodingFilter doFilter");
		chain.doFilter(request, response);
		//System.out.println("characterEncodingFilter ");
	}
	//初始化过滤器
	public void init(FilterConfig config) throws ServletException {
		System.out.println("CharacterEncoding Filter init ... ...");
		this.config = config;
	}
	//过滤器配置类
	public FilterConfig getConfig() {
		return config;
	}
	public void setConfig(FilterConfig config) {
		this.config = config;
	}
}
