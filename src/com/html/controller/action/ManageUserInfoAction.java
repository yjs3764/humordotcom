package com.html.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardUserDAO;
import com.html.dto.BoardUserVO;

public class ManageUserInfoAction implements Action
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		BoardUserDAO uDao = BoardUserDAO.getInstance();
		BoardUserVO uVo = null;
		uDao.checkId(userid, uVo);
		request.setAttribute("userInfo", uVo);
		request.getRequestDispatcher("/memberUpdate.do").forward(request, response);
		System.out.println();
	}
}