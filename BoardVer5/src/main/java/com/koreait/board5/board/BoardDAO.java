package com.koreait.board5.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.DBUtils;

public class BoardDAO {
	public static int insBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO t_board "
				+" (title, ctnt, iuser) "
				+"VALUES (?, ?, ?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIuser());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	public static List<BoardVO> selBoardList(){
		List<BoardVO> list =  new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT A.iboard, A.title, B.unm, A.regdt "
				+" FROM t_board A "
				+" LEFT JOIN t_user B "
				+" ON A.iuser = B.iuser "
				+" ORDER BY iboard DESC ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String unm = rs.getString("unm");
				String regdt = rs.getString("regdt");
				
				BoardVO vo = new BoardVO();
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setUnm(unm);
				vo.setRegdt(regdt);
				
				list.add(vo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
				
	}
	
	public static BoardVO selBoard(int iboard) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT A.iboard, A.title, A.ctnt, B.unm, A.regdt, A.iuser "
				+" FROM t_board A "
				+" LEFT JOIN t_user B "
				+" ON A.iuser = B.iuser "
				+" WHERE iboard = ? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String unm = rs.getString("unm");
				String regdt = rs.getString("regdt");
				int iuser = rs.getInt("iuser");
				
				BoardVO vo = new BoardVO();
				vo.setTitle(title);
				vo.setCtnt(ctnt);
				vo.setUnm(unm);
				vo.setRegdt(regdt);
				vo.setIuser(iuser);
				
				return vo;				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}
	
	public static int delBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM t_board "
				+" WHERE iboard = ? AND iuser = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			ps.setInt(2, vo.getIuser());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	public static int updBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE t_board "
				+"SET title = ? "
				+", ctnt = ? "
				+"WHERE iboard = ? "
				+"AND iuser = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());
			ps.setInt(4, vo.getIuser());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
}
