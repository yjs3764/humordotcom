package com.html.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.html.dao.BoardUserDAO;
import com.html.dto.BoardUserVO;

public class MemberJoinAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		System.out.println(name);
		System.out.println("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
		String userid = request.getParameter("userid");

		String nick = request.getParameter("nick");

		String pwd = request.getParameter("pwd");

		String email = request.getParameter("email");

		String phone = request.getParameter("phone");

		BoardUserVO mVo = new BoardUserVO();

		mVo.setUserName(name);

		mVo.setUserId(userid);

		mVo.setUserPw(pwd);

		mVo.setUserNick(nick);

		mVo.setUserEmail(email);

		mVo.setUserPhone(Integer.parseInt(phone));

		BoardUserDAO mDao = BoardUserDAO.getInstance();

		int result = mDao.insertBoardUser(mVo);

		HttpSession session = request.getSession();
		if (result == 1)
		{

			session.setAttribute("userid", mVo.getUserId());

			request.setAttribute("message", "회원 가입에 성공했습니다");

		}
		else

		{

			request.setAttribute("message", "회원 가입에 실패했습니다");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/login.jsp");

		dispatcher.forward(request, response);
		
	}
}
