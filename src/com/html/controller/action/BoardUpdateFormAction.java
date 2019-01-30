package com.html.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardDAO;
import com.html.dao.BoardUserDAO;
import com.html.dto.BoardUserVO;
import com.html.dto.BoardVO;

import util.Test;

public class BoardUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "/board/boardUpdate.jsp";
		
		String boardnum = request.getParameter("boardnum");
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		bDao.updateReadCount(boardnum);
		
		BoardVO bVo = bDao.selectOneBoardByNum(boardnum);
		
		request.setAttribute("board", bVo);
		
		BoardUserDAO uDao = BoardUserDAO.getInstance();
		BoardUserVO uVo = null;
		uVo = (BoardUserVO)request.getSession().getAttribute("loginUser");
		System.out.println("uVo not null??????? " + (uVo != null));
		if(uVo != null) //로그인된 유저이면
		{
			if(uVo.getUserClass() == -1)
			{
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().println("<script>");
				response.getWriter().println("alert('강등회원은 글쓰기가 불가능합니다!!!!!!!'); history.go(-1);");
				response.getWriter().println("</script>");
			}
			else
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}
		}
		else	//비회원이면
		{
			if(uDao.checkBannedIP(Test.getCurrentIp().getHostAddress()) == 2) //차단된 ip주소면
			{
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().println("<script>");
				response.getWriter().println("alert('차단된 IP주소입니다!!!!!!!'); history.go(-1);");
				response.getWriter().println("</script>");
			}
			else
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}
		}
		
	}

}
