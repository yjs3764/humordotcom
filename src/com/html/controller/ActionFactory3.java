package com.html.controller;

import com.html.controller.action.Action;
import com.html.controller.action.ManageIPAction;
import com.html.controller.action.ManageUserAction;
import com.html.controller.action.ManageUserClassAction;
import com.html.controller.action.ManageUserInfoAction;

public class ActionFactory3
{
	private static ActionFactory3 instance = new ActionFactory3();
	
	private ActionFactory3()
	{
		super();
	}
	
	public static ActionFactory3 getInstance()
	{
		return instance;
	}
	
	public Action getAction(String command)
	{
		Action action = null;
		System.out.println("ManageActionFactory :" + command);
		
		if(command.equals("manage_user")) action = new ManageUserAction();
		else if (command.equals("manage_user_class")) action = new ManageUserClassAction();
		else if (command.equals("manage_user_info")) action = new ManageUserInfoAction();
		else if(command.equals("manage_ip")) action = new ManageIPAction();
		
		return action;
	}
}