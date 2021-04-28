package com.koreait.board2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");//0번: 첫번째 글, 1번 : 두번째글...
		int intno = Integer.parseInt(no);
		
		
		BoardVO vo = Database.db.get(intno);
//			List<BoardVO> list = Database.db;
//			BoardVO vo = list.get(intno);
		//-> 이렇게 풀어서 써도 됨
		
		request.setAttribute("vo", vo);
//		request.setAttribute("babo", 1);
//		request.setAttribute("haha", "안녕");
		
		String jsp = "WEB-INF/jsp/detail.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

}
