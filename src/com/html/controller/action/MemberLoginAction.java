package com.html.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.html.dao.BoardUserDAO;
import com.html.dto.BoardUserVO;

public class MemberLoginAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/member/login.jsp";
		
		String userid = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		BoardUserDAO mDao = BoardUserDAO.getInstance();
		int result = mDao.userCheck(userid, pwd);

		if (result == 1)
		{
			BoardUserVO mVo = mDao.getMember(userid);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mVo);
			request.setAttribute("message", "회원가입에 성공했습니다");
			url = "/index.jsp";//////////////////////임시로 처리해놓음
		}
		else if (result == 0)
		{
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}
		else if (result == -1)
		{
			request.setAttribute("message", "존재하지 않은 회원입니다.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
