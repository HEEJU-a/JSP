package com.koreait.first;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardList2Servlet
 */
@WebServlet("/list2")
public class BoardList2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/WEB-INF/jsp/list2.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response); 
	}

	
	

}
