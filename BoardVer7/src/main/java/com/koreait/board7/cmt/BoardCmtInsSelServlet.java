package com.koreait.board7.board.cmt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.koreait.board7.MyUtils;

@WebServlet("/board/cmtInsSel")
public class BoardCmtInsSelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	//리스트
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		System.out.println(iboard);
		
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIboard(iboard);
		
		List<BoardCmtDomain> list  = BoardCmtDAO.selBoardCmtList(param);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		response.getWriter()
		.append(json);
	}
	

	//등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		String cmt = request.getParameter("cmt");
		int iuser = MyUtils.getLoginUserPk(request);
		
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIboard(iboard);
		param.setCmt(cmt);
		param.setIuser(iuser);
		
		int result = BoardCmtDAO.insBoardCmt(param);
		
		
		response.getWriter()
		.append("{")
		.append("\"result\":")
		.append(String.valueOf(result))
		.append("}")
		.flush();// -> 이거는 굳이 안적어줘도 됨
		//{"result" : 1} //-> 이런게 json형태이다
				
	}

}
