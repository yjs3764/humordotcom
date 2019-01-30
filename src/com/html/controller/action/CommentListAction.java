package com.html.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardDAO;
import com.html.dto.BoardCommentVO;

public class CommentListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "/board/real_board_view.jsp"; // 추후 경로 설정 무조건 해야함
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		List<BoardCommentVO> commentList = bDao.selectAllComments();
		
		request.setAttribute("commentList", commentList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
