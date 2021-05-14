package com.koreait.board5.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.board5.DBUtils;

public class UserDAO {
	public static UserVO selUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		UserVO result = null;
		
		String sql = "SELECT iuser, uid, upw, unm "
				+"FROM t_user "
				+"WHERE uid = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int iuser = rs.getInt("iuser");
				String uid = rs.getString("uid");
				String upw = rs.getString("upw");
				String unm = rs.getString("unm");
				
				result = new UserVO();
				result.setIuser(iuser);
				result.setUid(uid);
				result.setUpw(upw);
				result.setUnm(unm);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}
	
	public static int insUser(UserVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String Sql = "INSERT INTO t_user "
				+" (uid, upw, unm, gender) "
				+"VALUES (?, ?, ?, ?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(Sql);
			ps.setString(1, vo.getUid());
			ps.setString(2, vo.getUpw());
			ps.setString(3, vo.getUnm());
			ps.setInt(4, vo.getGender());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	
	
}
