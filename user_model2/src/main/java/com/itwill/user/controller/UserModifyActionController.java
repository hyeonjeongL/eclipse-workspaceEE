package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserModifyActionController implements Controller {
	private UserService userService;
	public UserModifyActionController() throws Exception{
		userService = new UserService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		/*****************로그인체크 login_check*******************/
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		if(sUserId==null){
			forwardPath="redirect:user_main.do";
		}
		/**********************************************************/
		/*
		0.login 여부체크
		1.GET방식이면 user_main.jsp redirection
		2.요청객체인코딩설정
		3.파라메타받기(password,name,email)
		4.세션의 sUserId와 파라메타(password,name,email) 로 User객체생성후  UserService.update 메쏘드호출
		5.성공:user_view.jsp redirection
		  실패:user_error.jsp 
	*/
	try {
		if(request.getMethod().equalsIgnoreCase("GET")){
		forwardPath="redirect:user_main.do";
	}
	String password=request.getParameter("password");
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	int rowCount = userService.update(new User(sUserId,password,name,email));
	forwardPath="redirect:user_view.do";
	}catch (Exception e) {
		e.printStackTrace();
		forwardPath = "forward:/WEB-INF/views/user_error.jsp";
	}
	return forwardPath;
	}

}
