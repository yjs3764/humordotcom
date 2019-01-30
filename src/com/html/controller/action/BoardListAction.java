package com.html.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.dao.BoardDAO;
import com.html.dto.BoardVO;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String url = "/board/real_board_list.jsp";
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		List<BoardVO> boardList = bDao.selectAllBoards();
		
		for(int i = 0; i < boardList.size(); i++)
		{
			BoardUserDAO uDao = BoardUserDAO.getInstance();
			BoardUserVO uVo = null;
			uVo = uDao.getMember(boardList.get(i).getUsernick());
			System.out.println("uVo null ????? : " + uVo);
			if(uVo != null)
			{
				boardList.get(i).setUsernick(uVo.getUserNick() + "(" + uVo.getUserId() + ")");
				System.out.println(uVo.getUserNick() + "(" + uVo.getUserId() + ")");
			}
			
			System.out.println(boardList.get(i).getUsernick());
		}
		
		request.setAttribute("boardList", boardList);*/
		
		String url = "/board/real_board_list.jsp";

		String col = request.getParameter("col");
		String word = request.getParameter("word");
		

		System.out.println(col + "------------------------------" + word);
		
		BoardDAO bDao = BoardDAO.getInstance();

		ArrayList<BoardVO> list = bDao.list(col, word);
		request.setAttribute("boardList", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
