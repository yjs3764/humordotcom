package com.html.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardDAO;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String boardnum = request.getParameter("boardnum");
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.deleteBoard(boardnum);
		
		request.getRequestDispatcher("/BoardServlet?"
				+ "command=board_list&col=none&word=").forward(request, response);
	}
}