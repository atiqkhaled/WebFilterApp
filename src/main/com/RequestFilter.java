package main.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/* 
  Author     : atiqkhaled
*/
public class RequestFilter implements Filter {
	private FilterConfig fc =  null;
	private String dbPass = "jamil";
	private String dbUserName = "jamil";
	
	public String getDbPass() {
		return dbPass;
	}
	public void setDbPass(String dbPass) {
		this.dbPass = dbPass;
	}
	public String getDbUserName() {
		return dbUserName;
	}
	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}

	public void doFilter(ServletRequest req, ServletResponse resp,  
	  FilterChain chain) throws IOException, ServletException {  
	    String name = "";
	    String pass = "";
	    String msg = "";
	    String path = "";
	    
	    HttpServletRequest request = (HttpServletRequest)  req; 
	    name = req.getParameter("name");
	    pass = req.getParameter("pass");
	    path = request.getServletPath();
	    // intialize request attribute map. 
	    req.setAttribute("msg", msg);
	    // check authentication...
	    if(!(getDbUserName().equalsIgnoreCase(name) && getDbPass().equalsIgnoreCase(pass))) {
	    	if(path.equalsIgnoreCase("/welcome")) {
	    	   msg = "not matched";
	    	   req.setAttribute("msg", msg);
	    	}  
	      req.getRequestDispatcher("login.jsp").forward(req, resp);
	    } 	
	    
	    // sends request to next resource
	    chain.doFilter(req, resp);  
	 
	 } 
	    
	 public void init(FilterConfig filterConfig) throws ServletException {
	    this.fc = filterConfig;
	 } 
	    
	 public void destroy() {
	    	  
	 }  
	 
}
