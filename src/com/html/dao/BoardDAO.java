package com.html.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.html.dto.BoardCommentVO;
import com.html.dto.BoardVO;

import util.DBManager;

public class BoardDAO {
	private BoardDAO() {
	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	public List<BoardVO> selectAllBoards() {
		String sql = "select * from board order by boardnum desc";

		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				BoardVO bVo = new BoardVO();

				bVo.setBoardnum(rs.getInt("boardnum"));
				bVo.setBoarddate(rs.getTimestamp("boarddate"));
				bVo.setBoardtitle(rs.getString("boardtitle"));
				bVo.setBoardcontent(rs.getString("boardcontent"));
				bVo.setBoardfile(rs.getString("boardfile"));
				bVo.setBoardpass(rs.getString("boardpass"));
				bVo.setUsernick(rs.getString("usernick"));
				bVo.setRecomm(rs.getInt("recomm"));
				bVo.setIpnum(rs.getString("ipnum"));
				bVo.setIsmember(rs.getInt("ismember"));
				bVo.setReadcount(rs.getInt("readcount"));

				list.add(bVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	public void insertBoard(BoardVO bVo) { // 회원(로그인) 글쓰기
		String sql = "insert into board(" + "boardnum, boardtitle, boardcontent, boardfile, ismember)"
				+ "values(board_seq.nextval, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bVo.getBoardtitle());
			pstmt.setString(2, bVo.getBoardcontent());
			pstmt.setString(3, bVo.getBoardfile());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void insertBoard2(BoardVO bVo) { // 비회원(비로그인) 글쓰기
		String sql = "insert into board" + "(" + "boardnum," + "usernick," + "boardtitle," + "boardcontent,"
				+ "boardfile," + "boardpass," + "ipnum," + "readcount," + "ismember" + ")"
				+ "values(board_seq.nextval,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bVo.getUsernick());
			pstmt.setString(2, bVo.getBoardtitle());
			pstmt.setString(3, bVo.getBoardcontent());
			pstmt.setString(4, bVo.getBoardfile());
			pstmt.setString(5, bVo.getBoardpass());
			pstmt.setString(6, bVo.getIpnum());
			pstmt.setInt(7, bVo.getReadcount());
			pstmt.setInt(8, bVo.getIsmember());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void updateReadCount(String boardnum) {
		String sql = "update board set readcount=readcount+1 where boardnum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardnum);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 게시판 글 상세 내용 보기 : 글번호로 찾아온다. : 실패 null,

	public BoardVO selectOneBoardByNum(String boardnum) {
		String sql = "select * from board where boardnum=?";

		BoardVO bVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardnum);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				bVo = new BoardVO();

				bVo.setBoardnum(rs.getInt("boardnum"));
				bVo.setBoarddate(rs.getTimestamp("boarddate"));
				bVo.setBoardtitle(rs.getString("boardtitle"));
				bVo.setBoardcontent(rs.getString("boardcontent"));
				bVo.setBoardfile(rs.getString("boardfile"));
				bVo.setBoardpass(rs.getString("boardpass"));
				bVo.setUsernick(rs.getString("usernick"));
				bVo.setRecomm(rs.getInt("recomm"));
				bVo.setIpnum(rs.getString("ipnum"));
				bVo.setIsmember(rs.getInt("ismember"));
				bVo.setReadcount(rs.getInt("readcount"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bVo;
	}

	public void updateBoard(BoardVO bVo) { // 회원(로그인시), 비회원 게시물 수정, 어차피 제목과 내용만 수정하므로 회원, 비회원 수정 따로 놓지않고 통합으로 기능구현하였음
		String sql = "update board set boardtitle=?, boardcontent=?, boardpass=?, usernick=?, boardfile=? where boardnum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bVo.getBoardtitle());
			pstmt.setString(2, bVo.getBoardcontent());
			pstmt.setString(3, bVo.getBoardpass());
			pstmt.setString(4, bVo.getUsernick());
			pstmt.setString(5, bVo.getBoardfile());
			pstmt.setInt(6, bVo.getBoardnum());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public BoardVO checkPassWord(String boardpass, String boardnum) {
		String sql = "select * from board where boardpass=? and boardnum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO bVo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, boardpass);
			pstmt.setString(2, boardnum);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				bVo = new BoardVO();

				bVo.setBoardnum(rs.getInt("boardnum"));
				bVo.setBoarddate(rs.getTimestamp("boarddate"));
				bVo.setBoardtitle(rs.getString("boardtitle"));
				bVo.setBoardcontent(rs.getString("boardcontent"));
				bVo.setBoardfile(rs.getString("boardfile"));
				bVo.setBoardpass(rs.getString("boardpass"));
				bVo.setUsernick(rs.getString("usernick"));
				bVo.setRecomm(rs.getInt("recomm"));
				bVo.setIpnum(rs.getString("ipnum"));
				bVo.setIsmember(rs.getInt("ismember"));
				bVo.setReadcount(rs.getInt("readcount"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bVo;
	}

	public void deleteBoard(String boardnum) {
		String sql = "delete board where boardnum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, boardnum);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<BoardVO> list(String col, String word) { // 검색기능
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();

		try {

			conn = DBManager.getConnection();
			sql = new StringBuffer();

			if (col.equals("none")) {
				sql.append(" SELECT boardnum, boarddate, boardtitle, boardcontent,"
						+ " boardfile, usernick, recomm, ipnum, ismember, readcount, boardpass ");
				sql.append(" FROM board ");
				sql.append(" WHERE usernick LIKE ? OR boardcontent LIKE ?  OR boardtitle LIKE ?");
				sql.append(" ORDER BY boarddate DESC");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%" + word + "%");
				pstmt.setString(2, "%" + word + "%");
				pstmt.setString(3, "%" + word + "%");

			} else if (col.equals("rname")) {
				sql.append(" SELECT boardnum, boarddate, boardtitle, boardcontent,"
						+ " boardfile, usernick, recomm, ipnum, ismember, readcount, boardpass ");
				sql.append(" FROM board");
				sql.append(" WHERE usernick LIKE ?");
				sql.append(" ORDER BY boarddate DESC");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%" + word + "%");
			} else if (col.equals("title")) {
				sql.append(
						" SELECT boardnum, boarddate, boardtitle, boardcontent, boardfile, usernick, recomm, ipnum, ismember, readcount, boardpass ");
				sql.append(" FROM board ");
				sql.append(" WHERE boardtitle LIKE ?");
				sql.append(" ORDER BY boarddate DESC");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%" + word + "%");
			} else if (col.equals("content")) {
				sql.append(
						" SELECT boardnum, boarddate, boardtitle, boardcontent, boardfile, usernick, recomm, ipnum, ismember, readcount, boardpass ");
				sql.append(" FROM board ");
				sql.append(" WHERE boardcontent LIKE ?");
				sql.append(" ORDER BY boarddate DESC");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%" + word + "%");
			} else if (col.equals("title_content")) {
				sql.append(
						" SELECT boardnum, boarddate, boardtitle, boardcontent, boardfile, usernick, recomm, ipnum, ismember, readcount, boardpass ");
				sql.append(" FROM board ");
				sql.append(" WHERE boardtitle LIKE ? OR boardcontent LIKE ?");
				sql.append(" ORDER BY boarddate DESC");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, "%" + word + "%");
				pstmt.setString(2, "%" + word + "%");
				/*
				 * } else if (col.equals("ost")) { sql.
				 * append(" SELECT ostno,rname, title, cnt, rdate, music, img1,img2,img1size,img2size,content,viewyn, thumb "
				 * ); sql.append(" FROM ost "); sql.append(" WHERE music LIKE ?");
				 * sql.append(" ORDER BY ostno DESC"); pstmt =
				 * conn.prepareStatement(sql.toString()); pstmt.setString(1, "%" + word + "%");
				 */
			}

			else {
				sql.append(
						" SELECT boardnum, boarddate, boardtitle, boardcontent, boardfile, usernick, recomm, ipnum, ismember, readcount, boardpass ");
				sql.append(" FROM board ");
				sql.append(" ORDER BY boarddate DESC");
				pstmt = conn.prepareStatement(sql.toString());
			}

			rs = pstmt.executeQuery(); // SELECT

			while (rs.next()) { /* (rs.next() == true) */
				BoardVO bVo = new BoardVO();

				bVo.setBoardnum(rs.getInt("boardnum")); // Record -> �ڹ� ��ü
				bVo.setBoarddate(rs.getTimestamp("boarddate"));

				bVo.setBoardtitle(rs.getString("boardtitle"));
				bVo.setBoardcontent(rs.getString("boardcontent"));
				bVo.setBoardfile(rs.getString("boardfile"));
				bVo.setUsernick(rs.getString("usernick"));
				bVo.setRecomm(rs.getInt("recomm"));

				bVo.setIpnum(rs.getString("ipnum"));
				bVo.setIsmember(rs.getInt("ismember"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setBoardpass(rs.getString("boardpass"));

				list.add(bVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	
	public List<BoardCommentVO> selectAllComments(int boardNum) { //댓글 목록 출력
		String sql = "select * from board_comment where comment_board = " + boardNum + " order by comment_num asc";
		
		List<BoardCommentVO> listCom = new ArrayList<BoardCommentVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
			
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				BoardCommentVO bCo = new BoardCommentVO();
				
				bCo.setComment_num(rs.getInt("comment_num"));
				bCo.setComment_board(rs.getInt("comment_board"));
				bCo.setComment_content(rs.getString("comment_content"));
				bCo.setComment_pass(rs.getString("comment_pass"));
				bCo.setComment_usernick(rs.getString("comment_usernick"));
				bCo.setComment_ismember(rs.getInt("comment_ismember"));
				
				listCom.add(bCo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		 return listCom;
	}

	public void insertComment2(BoardCommentVO bCo, int boardNum) { //비회원(비로그인) 댓글쓰기
		String sql = "insert into board_comment(" 
				+ "comment_num, comment_content,"
				+ " comment_usernick, comment_pass, comment_board, comment_ismember)"
				+ "values(comment_seq.nextval ,?, ?, ?, ?, ?)";	
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println("sql : " + bCo.getComment_content());
		System.out.println("sql : " + bCo.getComment_usernick());
		System.out.println("sql : " + bCo.getComment_pass());
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bCo.getComment_content());
			pstmt.setString(2, bCo.getComment_usernick());
			pstmt.setString(3, bCo.getComment_pass());
			pstmt.setInt(4, boardNum);
			pstmt.setInt(5, bCo.getComment_ismember());
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void deleteComment(String comment_num) { // 댓글삭제
		String sql = "delete board_comment where comment_num=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, comment_num);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUpRecomm(String boardnum) {
		String sql = "update board set recomm=recomm+1 where boardnum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardnum);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void updateDownRecomm(String boardnum) {
		String sql = "update board set recomm=recomm-1 where boardnum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardnum);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	/*
	 * public List<BoardVO> searchBoards() { // 게시글 검색기능 // String sql =
	 * "select * from board where boardtitle like ? order by boarddate desc"; String
	 * opt = (String)listOpt.get("opt"); // 검색옵션 (제목, 내용, 닉네임 등) String condition =
	 * (String)listOpt.get("condition"); // 검색내용
	 * 
	 * List<BoardVO> list = new ArrayList<BoardVO>(); Connection conn = null;
	 * Statement stmt = null; ResultSet rs = null; PreparedStatement pstmt = null;
	 * 
	 * try { conn = DBManager.getConnection(); stmt = conn.createStatement(); String
	 * sql1 = new String();
	 * 
	 * rs = stmt.executeQuery(sql1);
	 * 
	 * if(opt.equals("0")) // 제목으로 검색한 글의 개수 {
	 * sql1.concat("select * from BOARD where BOARDTITLE like ? ");
	 * sql1.concat("order by BOARDDATE desc"); pstmt =
	 * conn.prepareStatement(sql1.toString()); pstmt.setString(1,
	 * '%'+condition+'%');
	 * 
	 * sql1.delete(0, sql1.toString().length()); }
	 * 
	 * else if(opt.equals("1")) // 내용으로 검색 {
	 * sql1.concat("select * from BOARD where BOARDCONTENT like ? ");
	 * sql1.concat("order by BOARDDATE desc"); pstmt =
	 * conn.prepareStatement(sql1.toString()); pstmt.setString(1,
	 * '%'+condition+'%'); }
	 * 
	 * else if(opt.equals("2")) // 제목 + 내용으로 검색 { sql1.
	 * concat("select * from BOARD where BOARDTITLE like ? or BOARDCONTENT like ? "
	 * ); sql1.concat("order by BOARDDATE desc"); pstmt =
	 * conn.prepareStatement(sql1.toString()); pstmt.setString(1,
	 * '%'+condition+'%'); }
	 * 
	 * else if(opt.equals("3")); // 작성자로 검색 {
	 * sql1.concat("select * from BOARD where USERNICK like ? ");
	 * sql1.concat("order by BOARDDATE desc"); pstmt =
	 * conn.prepareStatement(sql1.toString()); pstmt.setString(1,
	 * '%'+condition+'%'); }
	 * 
	 * rs = pstmt.executeQuery(); while (rs.next()) { BoardVO bVo = new BoardVO();
	 * 
	 * bVo.setBoardnum(rs.getInt("boardnum"));
	 * bVo.setBoarddate(rs.getTimestamp("boarddate"));
	 * bVo.setBoardtitle(rs.getString("boardtitle"));
	 * bVo.setBoardcontent(rs.getString("boardcontent"));
	 * bVo.setUsernick(rs.getString("usernick"));
	 * bVo.setRecomm(rs.getInt("recomm")); bVo.setIpnum(rs.getString("ipnum"));
	 * bVo.setIsmember(rs.getInt("ismember"));
	 * bVo.setReadcount(rs.getInt("readcount"));
	 * bVo.setBoardpass(rs.getString("boardpass"));
	 * 
	 * list.add(bVo); } } catch (SQLException e) { e.printStackTrace(); } finally {
	 * DBManager.close(conn, stmt, rs); } return list; }
	 */

}
