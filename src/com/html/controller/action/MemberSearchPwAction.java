package com.html.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardUserDAO;
import com.html.dto.BoardUserVO;

public class MemberSearchPwAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("id");
		String userPhone = request.getParameter("phone");
		
		BoardUserDAO uDao = BoardUserDAO.getInstance(); // DAO
		BoardUserVO uVo;
		uVo = uDao.searchPw(userId, userPhone);
		if (uVo != null)
		{
			request.getSession().setAttribute("userid", uVo.getUserId());
			request.setAttribute("message", "회원님의 비밀번호는 : " + uVo.getUserId() + "입니다");
		}
		else
		{
			request.setAttribute("message", "아이디 혹은 휴대폰 번호가 틀렸습니다.");
		}
		
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("/ManageMemberServlet?command=searchidform").forward(request, response);
	}

}
