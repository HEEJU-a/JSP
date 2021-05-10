package com.koreait.board3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {
	
	public static int getParamInt(String key, HttpServletRequest request) {
		String strVal = request.getParameter(key);
//		int intVal = parseStringToInt(strVal);
//		return intVal;
		return parseStringToInt(strVal);
	}
	
	public static int parseStringToInt(String strNum) {
		try {
			return Integer.parseInt(strNum);
		}catch(Exception e) {
			return 0;
		}
	}
	
		
	public static void openJSP(String fileNm, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher(jsp).forward(request, response);
		
		String jsp = "/WEB-INF/view/" + fileNm + ".jsp";
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
		
		
	}
}
