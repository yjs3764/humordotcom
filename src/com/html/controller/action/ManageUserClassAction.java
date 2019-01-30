package com.html.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardUserDAO;

public class ManageUserClassAction implements Action
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		System.out.println(userid);
		int userclass = 0;
		
		userclass = Integer.parseInt(request.getParameter("userclass"));
		
		System.out.println(userclass);
		
		System.out.println("ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
		BoardUserDAO uDao = BoardUserDAO.getInstance();
		System.out.println("ggggggggggggggggggggggggggggggggggggggggg");
		uDao.changeUserClass(userid, userclass);
		System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		
		//response.setContentType("text/html;charset=UTF-8");
		//response.getWriter().println("<script>alert('변경되었습니다');history.go(-1)</script>");
		System.out.println("끝끝끝");
		//request.getRequestDispatcher("/boardproject/AdminServlet?command=manage_user").forward(request, response);
		request.getRequestDispatcher("/AdminServlet?command=manage_user").forward(request, response);
		
	}
}
