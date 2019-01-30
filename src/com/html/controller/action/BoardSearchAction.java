package com.html.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardDAO;
import com.html.dto.BoardVO;

public class BoardSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		BoardVO bVo = new BoardVO();

		bVo.setBoardnum(Integer.parseInt(request.getParameter("boardnum")));
		bVo.setUsernick(request.getParameter("usernick"));
		bVo.setBoardtitle(request.getParameter("boardtitle"));
		bVo.setBoardcontent(request.getParameter("boardcontent"));

		BoardDAO bDao = BoardDAO.getInstance();

		bDao.searchBoards(listOpt);

		/* new BoardListAction().execute(request, response); */

	}

}
