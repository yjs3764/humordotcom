package com.html.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardUserDAO;
import com.html.dto.BoardUserVO;

public class MemberSearchIdAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("name");
		String userPhone = request.getParameter("phone");
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("phone"));
		BoardUserDAO uDao = BoardUserDAO.getInstance(); // DAO
		BoardUserVO uVo;
		uVo = uDao.searchId(userName, userPhone);
		if (uVo != null)
		{
			request.getSession().setAttribute("userid", uVo.getUserId());
			request.setAttribute("message", "회원님의 아이디는 : " + uVo.getUserId() + "입니다");
		}
		else
		{
			request.setAttribute("message", "이름 혹은 휴대폰 번호가 틀렸습니다.");
		}
		
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("/ManageMemberServlet?command=searchidform").forward(request, response);
	}
}