package com.html.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardDAO;
import com.html.dao.BoardUserDAO;
import com.html.dto.BoardCommentVO;
import com.html.dto.BoardUserVO;
import com.html.dto.BoardVO;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/board/real_board_view.jsp";
		
		String boardnum = request.getParameter("boardnum");
		System.out.println("????볼드넒 " + boardnum);
		BoardDAO bDao = BoardDAO.getInstance();
		
		bDao.updateReadCount(boardnum);
		
		BoardVO bVo = bDao.selectOneBoardByNum(boardnum);
		List<BoardCommentVO> commentList = bDao.selectAllComments(bVo.getBoardnum());
		
		BoardUserDAO uDao = BoardUserDAO.getInstance();
		BoardUserVO uVo = null;
		BoardUserVO uVo2 = (BoardUserVO)request.getSession().getAttribute("loginUser");
		
		System.out.println("uVo2 널?????" + uVo2 == null);
		
		uVo = uDao.getMember(bVo.getUsernick());
		
		System.out.println("uVo 널?????" + uVo == null);
		
		System.out.println("uVo null ????? : " + uVo);
		System.out.println("bVo ismember???? : " + bVo.getIsmember());
		if(bVo.getIsmember() == 0)
		{
			String newUserNick = bVo.getUsernick() + "(비회원)";
			bVo.setUsernick(newUserNick);
		}
		else
		{
			request.setAttribute("memberusernick", uVo.getUserNick() + "(" + uVo.getUserId() + ")");
			bVo.setUsernick(uVo.getUserNick() + "(" + uVo.getUserId() + ")");
		}
		
		for(BoardCommentVO comm : commentList)
		{
			if(comm.getComment_ismember() == 0)
			{
				String newUserNick = comm.getComment_usernick() + "(비회원)";
				comm.setComment_usernick(newUserNick);
			}
			else
			{
				BoardUserVO newUser = uDao.getMember(comm.getComment_usernick());
				comm.setComment_usernick(newUser.getUserNick() + "(" + newUser.getUserId() + ")");
			}	
		}
		
		if(uVo2 != null)
		{
			System.out.println(uVo2.getUserNick() + "(" + uVo2.getUserId() + ")");
			request.setAttribute("loginusernick", uVo2.getUserNick() + "(" + uVo2.getUserId() + ")");
		}
		else
		{
			request.setAttribute("loginusernick", "notloginuser");
		}
		
		
		
		request.setAttribute("board", bVo);
		request.setAttribute("commentList", commentList);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}


}
