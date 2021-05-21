package com.koreait.board6.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board6.MyUtils;


@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = MyUtils.getParamInt("page", request);
		if(page == 0) {page = 1;} // ->쿼리 스트링이 0일때 이거나 진짜 0을 보냈을때
		int recordCnt = 3; // 페이지당 3개가 나옴
		
		int sIdx = (page - 1) * recordCnt;
		
		BoardVO param = new BoardVO();
		param.setsIdx(sIdx);
		param.setPage(recordCnt);
		
		request.setAttribute("list", BoardDAO.selBoardList(param));
		
		MyUtils.openJSP("리스트", "board/boardList", request, response);
	}

	
	

}
