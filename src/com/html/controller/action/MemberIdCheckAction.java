package com.html.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardUserDAO;

public class MemberIdCheckAction implements Action
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		BoardUserDAO mDao = BoardUserDAO.getInstance();
		int result = mDao.confirmID(userid);
		request.setAttribute("userid", userid);
		request.setAttribute("result", result);
		System.out.println("dddddd");
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/idcheck.jsp");
		dispatcher.forward(request, response);
	}
}
