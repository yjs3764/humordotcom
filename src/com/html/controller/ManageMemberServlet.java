package com.html.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.html.controller.action.Action;

@WebServlet("/ManageMemberServlet")
public class ManageMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManageMemberServlet()
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println("BoardServlet에서 요청을 받음을 확인 : " + command);
		ActionFactory2 af = ActionFactory2.getInstance();
		Action action = af.getAction2(command);
		
		action.execute(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}