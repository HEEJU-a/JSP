package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board4.MyUtils;


@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		if(loginUser != null) {
			response.sendRedirect("/board/list");
			return;
		}
		
		MyUtils.openJSP("user/login", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		UserVO vo = new UserVO();
		vo.setUid(uid);
		vo.setUpw(upw);
		
		int result = UserDAO.loginUser(vo);
		System.out.println("result : " + result);
		
		if(result == 1) {// 로그인 성공
			HttpSession hs = request.getSession();
			//레퍼런스 변수이기때문에 담기전에 지워도되고 담고난 후에 지워도됨
			vo.setUpw(null); //-> pw지웠음
			hs.setAttribute("loginUser", vo); // ->이때 vo가 가리키는 userVO객체는
			                                     // (iuser, uid, unm 값만 담고있다)
			
			
			response.sendRedirect("/board/list");
			return;
		}
		
		String errMsg = null;
		switch(result) {
		case 0:
			errMsg = "에러가 발생하였습니다.";
			break;
		case 2:
			errMsg = "아이디를 확인해주세요.";
			break;
		case 3:
			errMsg = "비밀번호를 확인해 주세요.";
			break;
			
		}
			request.setAttribute("errMsg", errMsg);
			doGet(request, response);			
//			response.sendRedirect("login");
			
		}
	
}
