package com.html.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.html.dto.BoardUserVO;

import util.DBManager;

public class BoardUserDAO {
	private BoardUserDAO() {
	}

	private static BoardUserDAO instance = new BoardUserDAO();

	public static BoardUserDAO getInstance() {
		return instance;
	}

	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();

		return conn;
	}

	// t사용자 인증시 사용하는 메소드
	public int userCheck(String userid, String pwd) {
		int result = -1;
		String sql = "select userpw from boarduser where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("userpw") != null && rs.getString("userpw").equals(pwd)) {
					result = 1;
				} else {
					result = 0;
				}
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// 아이디로 회원정보 가져오는 메소드
	public BoardUserVO getMember(String userid) {
		BoardUserVO mVo = null;
		String sql = "select * from boarduser where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mVo = new BoardUserVO();
				/*
				 * private int userNum; private String userId; private String userPw; private
				 * String userNick; private int userPhone; private String userName; private
				 * String userEmail; private Timestamp joindate; private int userClass;
				 */
				mVo.setUserNum(rs.getInt("userNum"));
				mVo.setUserName(rs.getString("userName"));
				mVo.setUserId(rs.getString("userId"));
				mVo.setUserPw(rs.getString("userPw"));
				mVo.setUserEmail(rs.getString("userEmail"));
				mVo.setUserPhone(rs.getInt("userPhone"));
				mVo.setUserNick(rs.getString("userNick"));
				mVo.setUserClass(rs.getInt("userClass"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return mVo;
	}

	public int confirmID(String userid) {

		int result = -1;
		String sql = "select userid from boarduser where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int insertBoardUser(BoardUserVO mVo) {
		int result = -1;
		String sql = "insert into boarduser (usernum,username,userid,usernick,userpw,useremail,userphone)"
				+ " values(user_seq.nextval,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getUserName());
			pstmt.setString(2, mVo.getUserId());
			pstmt.setString(3, mVo.getUserNick());
			pstmt.setString(4, mVo.getUserPw());
			pstmt.setString(5, mVo.getUserEmail());
			pstmt.setInt(6, mVo.getUserPhone());
			System.out.println("---------------------------" + mVo.getUserName() + "---------------------------");
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int updateMember(BoardUserVO mVo) {
		int result = -1;
		String sql = "update boarduser set userpw=?,useremail = ?," + "userphone=?, usernick = ? where userid = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getUserPw());
			pstmt.setString(2, mVo.getUserEmail());
			pstmt.setInt(3, mVo.getUserPhone());
			pstmt.setString(4, mVo.getUserNick());
			pstmt.setString(5, mVo.getUserId());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public BoardUserVO searchId(String userName, String userPhone) {
		BoardUserVO uVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			System.out.println(userPhone);
			int p = Integer.parseInt(userPhone);
			conn = getConnection();
			
			System.out.println("-----------" + userName + "-----------" + p);
			pstmt = conn.prepareStatement("select userid from boarduser where username = ? and userphone = ?");
			pstmt.setString(1, userName);
			pstmt.setInt(2, p);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				uVo = new BoardUserVO();
				uVo.setUserId(rs.getString("userid"));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}

		return uVo;
	}
	
	public BoardUserVO searchPw(String userId, String userPhone) {
		BoardUserVO uVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			System.out.println(userPhone);
			int p = Integer.parseInt(userPhone);
			conn = getConnection();
			
			System.out.println("-----------" + userId + "-----------" + p);
			pstmt = conn.prepareStatement("select userpw from boarduser where userid = ? and userphone = ?");
			pstmt.setString(1, userId);
			pstmt.setInt(2, p);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				uVo = new BoardUserVO();
				uVo.setUserId(rs.getString("userpw"));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}

		return uVo;
	}

	public int deleteMember(String id, String passwd)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbpasswd = ""; // db상의 비밀번호
		int x = -1;
		
		System.out.println("id: "+ id +" passwd: "+passwd);

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select userpw from boarduser where userid = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbpasswd = rs.getString("userpw");
				// pstmt.close();
				
				System.out.println("id: "+passwd +" dbId: "+dbpasswd);

				if (dbpasswd.equals(passwd)) {
					Connection conn2 = DBManager.getConnection();
					PreparedStatement pstmt2 = null;

					pstmt2 = conn2.prepareStatement("delete from boarduser where userid = ?");
					pstmt2.setString(1, id);
					x = pstmt2.executeUpdate();
					
					if (pstmt2 != null)
						try {
							pstmt.close();
						} catch (SQLException ex) {
						}
					if (conn2 != null)
						try {
							conn.close();
						} catch (SQLException ex) {
						}

				} else {
					
					x = 0; // 비밀번호 틀림
					
					
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}

	
	public int checkBannedIP(String ipnum) {
		int result = -1;
		String sql = "select ipnum from banipnum where ipnum = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ipnum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("ipnum") != null && rs.getString("ipnum").equals(ipnum)) {
					result = 2;
				}

			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int banIP(String ipnum) {
		int result = -1;
		if (checkBannedIP(ipnum) != -1)
			return result;
		result = 1;
		System.out.println(result);
		String sql = "insert into banipnum(ipnum) values(?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ipnum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public void changeUserClass(String userid, int userclass) {
		String sql = "update boarduser set userclass = ? where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userclass);
			pstmt.setString(2, userid);
			pstmt.executeUpdate();
			pstmt.close();
			pstmt = conn.prepareStatement("commit");
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean checkId(String userid, BoardUserVO out) {
		out = new BoardUserVO();
		boolean result = false;
		String sql = "select * from boarduser where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				out = new BoardUserVO();
				out.setUserNum(rs.getInt("userNum"));
				out.setUserName(rs.getString("userName"));
				out.setUserId(rs.getString("userId"));
				out.setUserPw(rs.getString("userPw"));
				out.setUserEmail(rs.getString("userEmail"));
				out.setUserPhone(rs.getInt("userPhone"));
				out.setUserNick(rs.getString("userNick"));
				out.setUserClass(rs.getInt("userClass"));
			} else {
				result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}
