package com.html.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardUserDAO;
import com.html.dto.BoardUserVO;

public class MemberUpdateAction implements Action
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String name = request.getParameter("name");
		String nick = request.getParameter("nick");
		
		BoardUserVO mVo = new BoardUserVO();
		
		mVo.setUserEmail(email);
		mVo.setUserPhone(Integer.parseInt(phone));		
		mVo.setUserPw(pwd);
		mVo.setUserId(userid);
		mVo.setUserName(name);
		mVo.setUserNick(nick);
		
		BoardUserDAO mDao = BoardUserDAO.getInstance();
		mDao.updateMember(mVo);
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("<script>alert('업데이트되었습니다');location.href='/boardproject/index.jsp'</script>");
	}
}
