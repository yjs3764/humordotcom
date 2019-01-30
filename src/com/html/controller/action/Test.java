package com.html.controller.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.html.dto.BoardVO;

import util.DBManager;

public class Test {
	
	public List<BoardVO> searchBoards(HashMap<String, Object> listOpt) { // 게시글 검색기능
//		String sql = "select * from board where boardtitle like ? order by boarddate desc";
		String opt = (String)listOpt.get("opt"); // 검색옵션 (제목, 내용, 닉네임 등)
		String condition = (String)listOpt.get("condition"); // 검색내용
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			String sql1 = new String();
			
			rs = stmt.executeQuery(sql1);
			
			if(opt.equals("0")) // 제목으로 검색한 글의 개수
            {
                sql1.concat("select * from BOARD where BOARDTITLE like ? ");
                sql1.concat("order by BOARDDATE desc");
                pstmt = conn.prepareStatement(sql1.toString());
                pstmt.setString(1, '%'+condition+'%');
                
  /*              sql1.delete(0, sql1.toString().length());*/
            } 
			
			else if(opt.equals("1")) // 내용으로 검색
			{
				sql1.concat("select * from BOARD where BOARDCONTENT like ? ");
				sql1.concat("order by BOARDDATE desc");
                pstmt = conn.prepareStatement(sql1.toString());
                pstmt.setString(1, '%'+condition+'%');
			}
			
			else if(opt.equals("2")) // 제목 + 내용으로 검색
			{
				sql1.concat("select * from BOARD where BOARDTITLE like ? or BOARDCONTENT like ? ");
				sql1.concat("order by BOARDDATE desc");
				pstmt = conn.prepareStatement(sql1.toString());
                pstmt.setString(1, '%'+condition+'%');
			}
			
			else if(opt.equals("3")); // 작성자로 검색
			{
				sql1.concat("select * from BOARD where USERNICK like ? ");
				sql1.concat("order by BOARDDATE desc");
				pstmt = conn.prepareStatement(sql1.toString());
                pstmt.setString(1, '%'+condition+'%');
			}
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO bVo = new BoardVO();	
				
				bVo.setBoardnum(rs.getInt("boardnum"));
				bVo.setBoarddate(rs.getTimestamp("boarddate"));
				bVo.setBoardtitle(rs.getString("boardtitle"));
				bVo.setBoardcontent(rs.getString("boardcontent"));
				bVo.setUsernick(rs.getString("usernick"));
				bVo.setRecomm(rs.getInt("recomm"));
				bVo.setIpnum(rs.getString("ipnum"));
				bVo.setIsmember(rs.getInt("ismember"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setBoardpass(rs.getString("boardpass"));
				
				list.add(bVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		 return list;
	}

}
