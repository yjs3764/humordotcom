package com.html.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardDAO;

public class CommentDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String boardNum = request.getParameter("boardnum");
		String comment_num = request.getParameter("comment_num");
		System.out.println(comment_num + "코멘트넘!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.deleteComment(comment_num);
		System.out.println(boardNum + "보드넘!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		String url="BoardServlet?command=board_view&boardnum=" + boardNum;
		request.getRequestDispatcher(url).forward(request, response);
		
		//new BoardListAction().execute(request, response);
		
	}

}
