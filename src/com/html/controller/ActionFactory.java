package com.html.controller;

import com.html.controller.action.Action;
import com.html.controller.action.*;
/*import com.html.controller.action.BoardCheckPassFormAction;
import com.html.controller.action.BoardDeleteAction;
import com.html.controller.action.BoardListAction;
import com.html.controller.action.BoardSearch;
import com.html.controller.action.BoardSearchAction;
import com.html.controller.action.BoardUpdateAction;
import com.html.controller.action.BoardUpdateFormAction;
import com.html.controller.action.BoardViewAction;
import com.html.controller.action.BoardWriteAction;
import com.html.controller.action.BoardWriteFormAction;
import com.html.controller.action.CommentDeleteAction;
import com.html.controller.action.CommentWriteAction;
import com.html.controller.action.CommentWriteFormAction;*/

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory :" + command);

		if (command.equals("board_list")) {
			action = new BoardListAction();
		} else if (command.equals("board_write_form")) {
			action = new BoardWriteFormAction();
		} else if (command.equals("board_write")) {
			action = new BoardWriteAction();
		} else if (command.equals("board_view")) {
			action = new BoardViewAction();
		} else if (command.equals("board_check_pass_form")) {
			action = new BoardCheckPassFormAction();
		} else if (command.equals("board_check_pass")) {
			action = new BoardCheckPassAction();
		} else if (command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
		} else if (command.equals("board_update")) {
			action = new BoardUpdateAction();
		} else if (command.equals("board_delete")) {
			action = new BoardDeleteAction();
		} else if (command.equals("board_search")) {
			action = new BoardSearch();
		} else if (command.equals("comment_write_form")) {
			action = new CommentWriteFormAction();
		} else if (command.equals("comment_write")) {
			action = new CommentWriteAction();
		} else if (command.equals("comment_delete")) {
			action = new CommentDeleteAction();
		} else if (command.equals("recomm_up")) {
			action = new TestActionUp();
		} else if (command.equals("recomm_down")) {
			action = new TestActionDown();
		} else if (command.equals("comment_check_pass")) {
			action = new CommentCheckPassAction();
		} else if (command.equals("comment_check_pass_form")) {	
			action = new CommentCheckPassFormAction();
		}

		return action;
	}

}
