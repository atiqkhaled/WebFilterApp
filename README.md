# WebFilterApp
**Project URL :** *http://localhost:8080/WebFilterApp*

This Project is for research purpose for understanding how servlet filter works. WebFilterApp is about checking credentials of user and displaying welcome page if user is authentic.

Following points are key elements of this Application :

- Filter class (RequestFilter.java)
- Web deployment descriptor file (web.xml)
- End user interaction interface (login.jsp) 

Filters are defined in web.xml file and mapped URL to filter name which particular name refer to filter implemented class.

```
  <filter>
    <filter-name>filterReq</filter-name>
    <filter-class>main.com.RequestFilter</filter-class>
  </filter>
  <filter-mapping>
    <filter-name>filterReq</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
```

In this application filter class (RequestFilter.java) intercepts request sending from end user and filter those data before sending back to requested resources. Following code snnipet has about checking authentication : 

```
   if(!("jamil".equalsIgnoreCase(name) && "jamil".equalsIgnoreCase(pass))) {
	     if(path.equalsIgnoreCase("/welcome")) {
	    	   msg = "not matched";
	    	   req.setAttribute("msg", msg);
	     }  
	     req.getRequestDispatcher("login.jsp").forward(req, resp);
	  } 	
	  // sends request to next resource
	  chain.doFilter(req, resp);
```

Login interface defined in login.jsp file whcih deployed in servlet container. Jsp enginge compile this file into servlet class and content of this file written on response object which later sent to the browser to present html for end user. Following code snippet showing alert message for invalid credentials :

```
<%
String msg = (String) request.getAttribute("msg");
if(msg != null && msg.equalsIgnoreCase("not matched")) {
%>
<div align = "center" style = "color : red">
Your input parameter been filtered but not authentic !
</div>
<% } %>
```


###Licence
This project is of course public and author is **atiqkhaled**.



