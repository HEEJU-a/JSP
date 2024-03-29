package com.koreait.board5.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.DBUtils;

public class CmtDAO {
	
	public static void insCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO t_board_cmt "
				+"(iboard, cmt, iuser) "
				+"VALUES (?, ?, ?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setString(2, param.getCmt());
			ps.setInt(3, param.getIuser());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		
	}
	
	public static List<CmtVO> selCmtList(int iboard){
		List<CmtVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT A.icmt, A.iuser, A.cmt, A.regdate, B.unm "
					+"FROM t_board_cmt A "
					+"LEFT JOIN t_user B "
					+"ON A.iuser = B.iuser "
					+"WHERE iboard = ? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CmtVO vo = new CmtVO();
				list.add(vo);
				
				
				vo.setIcmt(rs.getInt("icmt"));
				vo.setCmt(rs.getString("cmt"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setUnm(rs.getString("unm"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
			
		return list;
	}
	
	public static void delCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM t_board_cmt "
				+" WHERE icmt = ? AND iuser = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIcmt());
			ps.setInt(2, param.getIuser());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
}
