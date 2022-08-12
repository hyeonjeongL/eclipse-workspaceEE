package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;

public class UserLogoutController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		/*****************로그인체크 login_check*******************/
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		if(sUserId==null){
			forwardPath="redirect:user_main.do";
		}
		/**********************************************************/
		request.getSession(false).invalidate();
		forwardPath="redirect:user_main.do";
		
		return forwardPath;

	}

}
