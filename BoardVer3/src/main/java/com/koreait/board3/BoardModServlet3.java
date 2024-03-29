package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod3")
public class BoardModServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String iboard = request.getParameter("iboard");
		System.out.println("iboard : " + iboard);
		
		int intIboard = Integer.parseInt(iboard);
		
		BoardVO3 data = BoardDAO.selBoard(intIboard);//-> selBoard라서 한줄만 가지고 오는것!
		request.setAttribute("data", data);
		
		
		String jsp = "/WEB-INF/view/mod3.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int intIboard = Integer.parseInt(iboard);
		
		System.out.println(title);
		System.out.println(ctnt);
		System.out.println(iboard);
		
		BoardVO3 vo = new BoardVO3();
		vo.setIboard(intIboard);
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		BoardDAO.updBoard(vo);
		
		response.sendRedirect("/detail3?iboard=" + iboard);
		// -> list3에서 location.href부분 보기!
				
	}

}
