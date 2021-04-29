package com.koreait.board3;

import java.sql.Connection;
import java.sql.PreparedStatement;

//Data Access Object (DB담당)
public class BoardDAO {

	public static int insertBoard(BoardVO3 vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board (title, ctnt) "
				+ " VALUES (?, ?)";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
	}
}
