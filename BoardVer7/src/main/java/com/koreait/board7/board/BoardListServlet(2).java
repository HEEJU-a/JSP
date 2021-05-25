package com.koreait.board7.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;


@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징 부분
		BoardDTO param = new BoardDTO();
		final int recordCnt = 5; // -> 지금은 하드코딩 되어있는데 나중에 파라미터로 받을거다
		
		int cPage = MyUtils.getParamInt("cPage", request);
		if(cPage == 0) {
			cPage =  1; // 여기서 0이 넘어왓다는 것은 실제로 0을보냈거나 쿼리스트링 키값을 안보냈을때!
		}
		int startIdx = (cPage -1) * recordCnt;
		
		//검색 부분
		int searchType = MyUtils.getParamInt("searchType", request);
		String searchText = request.getParameter("searchText");
		if(searchType != 0 && searchText != null && !searchText.equals("")) {
			// -> sarchtype이 1,2,3,4중 한개고 검색에 text가 널이 아니고, 빈칸이 아닐때!
			param.setSearchType(searchType);
			param.setSearchText(searchText);
			
		}
		param.setStratIdx(startIdx);
		param.setRecordCnt(recordCnt);
		
		request.setAttribute("pagingCnt", BoardDAO.selPagingCnt(param)); // ->boarddao에 메소드만들고 나중에 적어주기 
		request.setAttribute("list", BoardDAO.selBoardList(param));
		MyUtils.openJSP("리스트", "board/boardList", request, response);
	}


}
