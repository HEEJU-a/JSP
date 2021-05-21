package com.koreait.board6.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board6.DBUtils;

public class BoardDAO {
	
	public static List<BoardVO> selBoardList(BoardVO param){
	List<BoardVO> list =  new ArrayList();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String sql = "SELECT A.iboard, A.title, B.unm, A.regdt, A.iuser "
			+" FROM t_board A "
			+" LEFT JOIN t_user B "
			+" ON A.iuser = B.iuser "
			+" ORDER BY iboard DESC "
			+"limit ?, ? ";
	try {
		con = DBUtils.getCon();
		ps = con.prepareStatement(sql);
		ps.setInt(1, param.getsIdx());
		ps.setInt(2, param.getPage());
		rs = ps.executeQuery();
		
		while(rs.next()) {
			int iboard = rs.getInt("iboard");
			String title = rs.getString("title");
			String unm = rs.getString("unm");
			String regdt = rs.getString("regdt");
			int  iuser = rs.getInt("iuser");
			
			BoardVO vo = new BoardVO();
			vo.setIboard(iboard);
			vo.setTitle(title);
			vo.setUnm(unm);
			vo.setRegdt(regdt);
			vo.setIuser(iuser);
			
			list.add(vo);
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DBUtils.close(con, ps, rs);
	}
	return list;
	}
}
