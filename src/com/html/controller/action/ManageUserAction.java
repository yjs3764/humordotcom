package com.html.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dto.BoardUserVO;

public class ManageUserAction implements Action
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		String url = "/boardproject/index.jsp";
		
		BoardUserVO uVo = (BoardUserVO)request.getSession().getAttribute("loginUser");
		
		if (!(uVo.getUserClass() == 1))
		{
			response.getWriter().println("<script>alert(\"관리자가 아닙니다!!!!!!!!\");history.go(-1);</script>");
			request.getRequestDispatcher(url).forward(request, response);
		}
		
		url = "admin/manageuser.jsp";
		request.getRequestDispatcher(url).forward(request, response);
//		response.sendRedirect("admin/manageuser.jsp");
	}	
}
