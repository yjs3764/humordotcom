package com.html.controller;

import com.html.controller.action.Action;
import com.html.controller.action.MemberDeleteAction;
import com.html.controller.action.MemberDeleteFormAction;
import com.html.controller.action.MemberIdCheckAction;
import com.html.controller.action.MemberJoinAction;
import com.html.controller.action.MemberJoinFormAction;
import com.html.controller.action.MemberLoginAction;
import com.html.controller.action.MemberLoginFormAction;
import com.html.controller.action.MemberLogoutAction;
import com.html.controller.action.MemberSearchIdAction;
import com.html.controller.action.MemberSearchIdFormAction;
import com.html.controller.action.MemberSearchPwAction;
import com.html.controller.action.MemberSearchPwFormAction;
import com.html.controller.action.MemberUpdateAction;
import com.html.controller.action.MemberUpdateFormAction;

public class ActionFactory2 {
	private static ActionFactory2 instance = new ActionFactory2();

	private ActionFactory2() {
		super();
	}

	public static ActionFactory2 getInstance() {
		return instance;
	}

	public Action getAction2(String command) {
		Action action = null;
		System.out.println("ActionFactory :" + command);

		if (command.equals("login")) {
			action = new MemberLoginAction();
		} else if (command.equals("join")) {
			action = new MemberJoinAction();
		} else if (command.equals("joinform")) {
			action = new MemberJoinFormAction();
		} else if (command.equals("loginform")) {
			action = new MemberLoginFormAction();
		} else if (command.equals("logout")) {
			action = new MemberLogoutAction();
		} else if (command.equals("searchidform")) {
			action = new MemberSearchIdFormAction();
		} else if (command.equals("searchid")) {
			action = new MemberSearchIdAction();
		} else if (command.equals("searchpwform")) {
			action = new MemberSearchPwFormAction();
		} else if (command.equals("searchpw")) {
			action = new MemberSearchPwAction();
		} else if (command.equals("updateform")) {
			action = new MemberUpdateFormAction();
		} else if (command.equals("update")) {
			action = new MemberUpdateAction();
		} else if (command.equals("deleteform")) {
			action = new MemberDeleteFormAction();
		} else if (command.equals("delete")) {
			action = new MemberDeleteAction();
		} else if (command.equals("idcheck")) {
			action = new MemberIdCheckAction();
		}

		return action;
	}

}
