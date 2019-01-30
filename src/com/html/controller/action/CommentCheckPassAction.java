package com.html.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardDAO;
import com.html.dto.BoardCommentVO;
import com.html.dto.BoardVO;

public class CommentCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String url = null;
		int boardNum = Integer.parseInt(request.getParameter("boardnum"));
		System.out.println(boardNum);
		int commentNum = Integer.parseInt(request.getParameter("comment_num"));
		System.out.println(commentNum);
		String comment_boardpass = request.getParameter("comment_boardpass");
		System.out.println(comment_boardpass);
		
		BoardDAO bDao = BoardDAO.getInstance();

		List<BoardCommentVO> bCo = bDao.selectAllComments(boardNum);

		BoardCommentVO cVo = null;

		for (BoardCommentVO get : bCo) {
			if (get.getComment_num() == commentNum) {
				cVo = get;
				break;
			}
		}

		if (cVo != null && cVo.getComment_pass().equals(comment_boardpass)) { // 성공
			//bDao.deleteComment("" + commentNum);
			System.out.println("!!!!!!!!!!!!!!성공!!!!!!!!!!!!");
			url = "/board/checkSuccess.jsp";
			request.setAttribute("boardnum", boardNum);
			System.out.println("보드넘!!!!!!!!!!!!!!! " + boardNum);
			//new BoardViewAction().execute(request, response);
			request.getRequestDispatcher(url).forward(request, response);
		} else { // 실패
			url = "/board/comment_CheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}

}
