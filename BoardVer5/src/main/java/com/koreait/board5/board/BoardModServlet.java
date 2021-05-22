package com.koreait.board5.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board5.MyUtils;
import com.koreait.board5.user.UserVO;

@WebServlet("/board/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int iboard = MyUtils.getParamInt("iboard", request);
		BoardVO data = BoardDAO.selBoard(iboard);
		request.setAttribute("data", data);
		
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
		if(loginUser.getIuser() != data.getIuser()) {
			response.sendRedirect("list");
			return;
		}
		
		//uid가 pk일때
		/*
		if(!loginUser.getUid().equals(data.getUid())){
			response.sendRedirect("list");
			return;
		*/
		
		MyUtils.openJSP("board/boardMod", request, response);
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPk(request);
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		vo.setIboard(iboard);
		vo.setIuser(iuser);
		
		BoardDAO.updBoard(vo);
		response.sendRedirect("detail?iboard=" + iboard);
		
	}

}
