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

import util.Test;

public class CommentWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;

		BoardUserDAO uDao = BoardUserDAO.getInstance();
		BoardUserVO uVo = null;
		uVo = (BoardUserVO) request.getSession().getAttribute("loginUser");
		System.out.println("uVo not null??????? " + (uVo != null));
		if (uVo != null) // 로그인된 유저이면
		{
			if (uVo.getUserClass() == -1) {
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().println("<script>");
				response.getWriter().println("alert('강등회원은 글쓰기가 불가능합니다!!!!!!!'); history.go(-2);");
				response.getWriter().println("</script>");
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}
		} else if (uDao.checkBannedIP(Test.getCurrentIp().getHostAddress()) == 2) {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println("<script>");
			response.getWriter().println("alert('차단된 IP주소입니다!!!!!!!'); history.go(-2);");
			response.getWriter().println("</script>");
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} else {
			url = "/board/real_board_view.jsp";
			BoardCommentVO bCo = new BoardCommentVO();
			System.out.println(request.getParameter("boardNum"));
			int boardNum = Integer.parseInt(request.getParameter("boardNum"));
			System.out.println(boardNum);

			bCo.setComment_content(request.getParameter("comment_content"));
			bCo.setComment_pass(request.getParameter("comment_pass"));
			bCo.setComment_usernick(request.getParameter("comment_usernick"));
			bCo.setComment_ismember(request.getSession().getAttribute("loginUser") == null ? 0 : 1);

			BoardDAO bDao = BoardDAO.getInstance();
		
			bDao.insertComment2(bCo, boardNum);

			request.setAttribute("boardnum", boardNum);
			// new BoardViewAction().execute(request, response);

			String boardnum = "" + boardNum;
			bDao.updateReadCount(boardnum);

			BoardVO bVo = bDao.selectOneBoardByNum(boardnum);

			List<BoardCommentVO> commentList = bDao.selectAllComments(bVo.getBoardnum());
			System.out.println("commentList null ? : " + commentList == null);
			request.setAttribute("board", bVo);

			request.setAttribute("commentList", commentList);

			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}

}
