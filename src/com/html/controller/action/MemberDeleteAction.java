package com.html.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardUserDAO;
import com.html.dto.BoardUserVO;

public class MemberDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		BoardUserVO mVo = (BoardUserVO)request.getSession().getAttribute("loginUser");
		String id = mVo.getUserId();
		String passwd = request.getParameter("passwd");
		BoardUserDAO manager = BoardUserDAO.getInstance();
		int check = manager.deleteMember(id, passwd);
		if (check == 1)
		{
			request.getSession().invalidate();
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println("<script>alert('회원정보가 삭제되었습니다 안녕히 가세요');location.href='/boardproject/index.jsp'</script>");
		} else {	
			response.getWriter().println("<script>alert(\"비밀번호가 맞지 않습니다.\"); history.go(-1);</script>");
			}
	}
}