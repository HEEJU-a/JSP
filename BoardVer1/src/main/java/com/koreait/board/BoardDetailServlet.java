package com.koreait.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("no");
		System.out.println("no : " + no);
		
		int to = Integer.parseInt(no);
		request.setAttribute("data", Database.list.get(to));
		//-Database.list.get(to) 랑
		//똑같은것 -> BoardVO vo = Database.list.get(0);
		                          
		String jsp = "/WEB-INF/jsp/detail.jsp";
		RequestDispatcher rd =  request.getRequestDispatcher(jsp);
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
