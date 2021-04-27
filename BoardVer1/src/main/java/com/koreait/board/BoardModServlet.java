package com.koreait.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		System.out.println(no);
		
		int to = Integer.parseInt(no);
		//Database.list.get(to);
		
		request.setAttribute("data", Database.list.get(to));
		
		String jsp = "/WEB-INF/jsp/mod.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String no = request.getParameter("no");// -> no값 까지 받아야함 // request(브라우저,HTML)에서 넘어왔기 땜에 전부다 getParameter로 받아야함
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int to = Integer.parseInt(no);
		
//		System.out.println("no: " + no);
//		System.out.println("title : " + title);
//		System.out.println("ctnt : " + ctnt);
// -> 잘되는지 이렇게 확인해보기
		
		/*
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		Database.list.set(to, vo);
		*/
	//  -> 새로 책을 써서 수정한걸 다시 넣는것
	// -> 하지만 이런방식은 진정한 수정이 아님
		
		BoardVO vo = Database.list.get(to); // BoardVO의 주소값을 얻어왔다
		vo.setTitle(title);//-> 원래 제목 aaaa에서 1111추가로 써서 결국 aaaa1111되게 하는것!
		vo.setCtnt(ctnt);
		
//		Database.list.get(to).setTitle(title);
//		Database.list.get(to).setCtnt(ctnt);
//       -> 책장에있는 책을 빼서 수정하는것
		
		// 주소값이동(디테일 화면으로 이동) : 
		response.sendRedirect("/detail?no=" + no);
		
	}

}
