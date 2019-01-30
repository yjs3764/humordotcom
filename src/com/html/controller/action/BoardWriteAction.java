package com.html.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardDAO;
import com.html.dto.BoardVO;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BoardVO bVo = new BoardVO();
		
		bVo.setIpnum(request.getRemoteAddr());
		bVo.setBoardtitle(request.getParameter("boardtitle"));
		bVo.setBoardcontent(request.getParameter("boardcontent"));
		bVo.setUsernick(request.getParameter("usernick"));
		bVo.setBoardpass(request.getParameter("boardpass"));
		bVo.setBoardfile(request.getParameter("boardfile"));
		bVo.setIsmember(Integer.parseInt(request.getParameter("ismember")));
		bVo.setReadcount(0);
		
		System.out.println(bVo.getIpnum());
		System.out.println(bVo.getBoardtitle());
		System.out.println(bVo.getBoardcontent());
		System.out.println(bVo.getUsernick());
		System.out.println(bVo.getBoardpass());
		System.out.println(bVo.getBoardfile());
		System.out.println(bVo.getIsmember());
		System.out.println(bVo.getReadcount());
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.insertBoard2(bVo);
		
		request.getRequestDispatcher("/BoardServlet?"
				+ "command=board_list&col=none&word=").forward(request, response);
	}
}
