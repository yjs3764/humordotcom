package com.html.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberSearchIdFormAction implements Action
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("UTF-8");
		String url = "/member/searchIdForm.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}
