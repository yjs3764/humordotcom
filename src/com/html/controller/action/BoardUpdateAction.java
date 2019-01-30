package com.html.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardDAO;
import com.html.dto.BoardVO;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BoardVO bVo = new BoardVO();
		
		bVo.setBoardnum(Integer.parseInt(request.getParameter("boardnum")));
		bVo.setUsernick(request.getParameter("usernick"));
		bVo.setBoardpass(request.getParameter("boardpass"));
		bVo.setBoardtitle(request.getParameter("boardtitle"));
		bVo.setBoardcontent(request.getParameter("boardcontent"));
		bVo.setBoardfile(request.getParameter("boardfile"));
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.updateBoard(bVo);
		
		new BoardListAction().execute(request, response);
		
	}

}
