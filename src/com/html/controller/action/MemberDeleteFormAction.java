package com.html.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardUserDAO;
import com.html.dto.BoardUserVO;

public class MemberDeleteFormAction implements Action
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		BoardUserVO uVo = null;
		uVo = (BoardUserVO)request.getSession().getAttribute("loginUser");
		System.out.println("uVo not null??????? " + (uVo != null));
		if(uVo != null) //로그인된 유저이면
		{
			if(uVo.getUserClass() == -1)
			{
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().println("<script>");
				response.getWriter().println("alert('강등회원은 회원탈퇴가 불가능합니다!!!!!!!'); history.go(-1);");
				response.getWriter().println("</script>");
			}
			else
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("member/deleteForm.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
