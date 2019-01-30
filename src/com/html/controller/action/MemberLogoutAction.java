package com.html.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberLogoutAction implements Action
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		request.getSession().invalidate();
		
		System.out.println(response.getCharacterEncoding());
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("<script>alert('로그아웃되었습니다');location.href='/boardproject/index.jsp'</script>");
		//RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		//dispatcher.forward(request, response);
	}
}
