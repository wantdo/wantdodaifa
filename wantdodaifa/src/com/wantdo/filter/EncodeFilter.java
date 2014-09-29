package com.wantdo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodeFilter implements Filter {
	 private FilterConfig filterConfig=null;
	public void destroy() {
		 this.filterConfig=null;

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req; 
		HttpServletResponse response = (HttpServletResponse)resp;
		request.setCharacterEncoding(this.filterConfig.getInitParameter("encoding"));
		response.setCharacterEncoding(this.filterConfig.getInitParameter("encoding"));
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		  this.filterConfig=filterConfig;
		 }

}
