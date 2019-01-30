package com.html.controller.action;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardDAO;
//import com.html.dto.BoardVO;
import com.html.dao.BoardUserDAO;
import com.html.dto.BoardUserVO;
import com.html.dto.CommUpOnceVO;

import util.Test;

public class TestActionUp implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String boardnum = request.getParameter("boardnum");

		// String recomm = request.getParameter("boardnum");

		BoardUserDAO uDao = BoardUserDAO.getInstance();
		BoardUserVO uVo = null;
		uVo = (BoardUserVO) request.getSession().getAttribute("loginUser");
		System.out.println("uVo not null??????? " + (uVo != null));
		
		CommUpOnceVO commUpOnce = (CommUpOnceVO)request.getServletContext().getAttribute("commuponce");
		
		if(commUpOnce == null) commUpOnce = new CommUpOnceVO();

//		System.out.println("컴업원스가 널? : " + commUpOnce == null);
		
		if (!(commUpOnce.get(Test.getCurrentIp().getHostAddress()) == Integer.parseInt(boardnum))) {
			if (uVo != null) // 로그인된 유저이면
			{
				if (uVo.getUserClass() == -1) {
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().println("<script>");
					response.getWriter().println("alert('강등회원은 추천이 불가능합니다!!!!!!!'); history.go(-1);");
					response.getWriter().println("</script>");
				} else {
					BoardDAO bDao = BoardDAO.getInstance();
					bDao.updateUpRecomm(boardnum);

					commUpOnce.put(Test.getCurrentIp().getHostAddress(), Integer.parseInt(boardnum));
					request.getServletContext().setAttribute("commuponce", commUpOnce);
					new BoardViewAction().execute(request, response);
				}
			} else // 비회원이면
			{
				if (uDao.checkBannedIP(Test.getCurrentIp().getHostAddress()) == 2) // 차단된 ip주소면
				{
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().println("<script>");
					response.getWriter().println("alert('차단된 IP주소입니다!!!!!!!'); history.go(-1);");
					response.getWriter().println("</script>");
				} else {
					BoardDAO bDao = BoardDAO.getInstance();
					bDao.updateUpRecomm(boardnum);

					commUpOnce.put(Test.getCurrentIp().getHostAddress(), Integer.parseInt(boardnum));
					request.getServletContext().setAttribute("commuponce", commUpOnce);
					new BoardViewAction().execute(request, response);
				}
			}
		} else {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println("<script>");
			response.getWriter().println("alert('이미 추천하셨습니다!!!!!!!'); history.go(-1);");
			response.getWriter().println("</script>");
		}
	}

}
