package com.koreait.first;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardList3Servlet
 */
@WebServlet("/list3")
public class BoardList3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		
		
		
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		
		String jsp = "/WEB-INF/jsp/list3.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
	}

	
	

}
