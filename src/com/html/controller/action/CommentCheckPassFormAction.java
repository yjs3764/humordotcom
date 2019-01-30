package com.html.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentCheckPassFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "/board/comment_CheckPass.jsp";
		
		request.setAttribute("boardnum", request.getParameter("boardnum"));
		request.setAttribute("comment_num", request.getParameter("comment_num"));
		request.setAttribute("comment_boardpass", request.getParameter("comment_boardpass"));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
