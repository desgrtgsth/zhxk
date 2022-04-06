package com.zh.zhxk.web.ListenerAndFilter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CharCoderFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/*" })
public class CharCoderFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CharCoderFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		    // TODO Auto-generated method stub
		    // place your code here
		    HttpServletRequest req = (HttpServletRequest) request;
		    HttpServletResponse res = (HttpServletResponse) response;
		    if (req.getMethod().equalsIgnoreCase("post")) {
		      req.setCharacterEncoding("utf-8");
		    } else{ //get
		      req = new HttpServletRequestWrapper(req){

		        @Override
		        public String getParameter(String name) {
		          String value= null;
		          try {
		            if(super.getParameter(name)!=null){
		              value =  new String(super.getParameter(name).getBytes("iso8859-1"), "utf-8");
		            }
		          } catch (UnsupportedEncodingException e) {
		          }
		          return value;
		        }
		        
		      };
		    }
		    res.setCharacterEncoding("utf-8");
		    chain.doFilter(request, response);
		  }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
