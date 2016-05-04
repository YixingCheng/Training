package com.mercury.servlet;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mercury.beans.User;
import com.mercury.service.HelloService;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HelloService hs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        System.out.println("HelloServlet is up");
        // TODO Auto-generated constructor stub
        if (hs == null){
        	hs = new HelloService();
        }
    }
    
    /*
    @Override
    public void init(ServletConfig config) throws ServletException {
    	
    	Properties p = null;
    	try{
    		String fileName = config.getInitParameter("jdbc-config");
        	InputStream input = config.getServletContext().getResourceAsStream(fileName);
        	System.out.println(fileName);
        	
        	p = new Properties();
        	p.load(input);
        	
        	Enumeration<?> e = p.propertyNames();
    		while (e.hasMoreElements()) {
    			String key = (String) e.nextElement();
    			String value = p.getProperty(key);
    			System.out.println("Key : " + key + ", Value : " + value);
    		}
    	} catch(IOException e){
    		
    	}
    	
    }
    */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//String name = request.getParameter("name");
		//int age = Integer.parseInt(request.getParameter("age"));
		User user = parse(request);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//HelloService hs = new HelloService();              //use singleton for service
		out.print(hs.sayHello1(user));
		//out.print("<h2 style='color: green;'>");
		//out.print("Hello " + name + ", your age is " + age);
		//out.print("</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		User user = parse(request);
		request.setAttribute("userInfo", hs.process(user));
		String url = "/result.jsp";
		//request.setAttribute("msg", hs.sayHello2(user));
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private User parse(HttpServletRequest request){
		User user = new User();
		user.setName(request.getParameter("name"));
		System.out.println(request.getParameter("age"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		return user;
	}
	
}
