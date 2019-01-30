package com.html.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardUserDAO;

public class ManageIPAction implements Action
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		String ipnum = request.getParameter("ipnum");
		System.out.println(ipnum);
		int result =-1;
		BoardUserDAO uVo = BoardUserDAO.getInstance();
		result = uVo.checkBannedIP(ipnum);
		//AdminServlet?command=manage_ip
		if(result == 2) {
			
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println("<script>alert('이미 차단된 IP입니다');history.go(-1)</script>");
			
		}else {
			
			uVo.banIP(ipnum);
			request.getRequestDispatcher("admin/manageip.jsp").forward(request, response);
			
		}
	}
}
