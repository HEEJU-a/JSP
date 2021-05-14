package com.koreait.board5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board5.user.UserVO;


public class MyUtils {
	public static void openJSP(String fileNm, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String jsp = "/WEB-INF/view/"+ fileNm + ".jsp";
		req.getRequestDispatcher(jsp).forward(req, res);//forward가 throw하고 있기때문에 빨간줄 뜬다
	}
	
	
	public static int parseStringToInt(String val) {
		try {
		return Integer.parseInt(val);
		} catch(Exception e) {
			return 0;
		}
	}
	
	public static int getParamInt(String key, HttpServletRequest req) {
		String val = req.getParameter(key);
		int intVal = MyUtils.parseStringToInt(val);
		//int intVal = parseStringToInt(val);
		//->지금 parseStringToInt메소드는 같은 클래스에 있기
		//   때문에 MyUtils를 생략해도 된다!
		return intVal;
	}
	
	
	public static UserVO getLoginUser(HttpServletRequest req) {
		if(req == null) {return null;} 
		HttpSession hs = req.getSession();
		return (UserVO) hs.getAttribute("loginUser");
	}
	
	public static int getLoginUserPk(HttpServletRequest req) {
		
//		UserVO vo =  getLoginUser(req);
//		return vo.getIuser();
		if(req == null) {return 0;} 
		return getLoginUser(req).getIuser();
		
	}
	
}
