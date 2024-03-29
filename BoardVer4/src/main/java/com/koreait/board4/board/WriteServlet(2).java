package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVO;


@WebServlet("/board/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		//로그인 안되어 있으면 로그인화면으로 이동
		if(loginUser == null) {
			response.sendRedirect("/user/login");
			return;
		}
		MyUtils.openJSP("board/write", request, response);
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//제목, 내용, 글쓴이 pk값을 BoardVO객체에 담아주세요
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
//		
//		HttpSession hs = request.getSession();
//		UserVO loginuser = (UserVO)hs.getAttribute("loginUser");
//		int iuser = loginuser.getIuser();
		
		int iuser =  MyUtils.getLoginUserPk(request);
		
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		vo.setIuser(iuser);
		
		BoardDAO.insBoard(vo);
		
		response.sendRedirect("/board/list");
		
	}

}
