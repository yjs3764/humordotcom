package com.html.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardDAO;
import com.html.dto.BoardVO;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = null;
		
		String boardnum = request.getParameter("boardnum");
		String boardpass = request.getParameter("boardpass");
		
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO bVo = bDao.selectOneBoardByNum(boardnum);
		
		System.out.println(boardnum + "******************************" + boardpass);
		
		System.out.println(bVo.getBoardpass());
		
		if (bVo.getBoardpass().equals(boardpass)) { // 성공
			url = "/board/checkSuccess.jsp";
			System.out.println("checkpass성공");
		} else { // 실패
			url = "/board/boardCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
