package com.itwill.guest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

/**
 * Servlet implementation class GuestMainServlet
 */
@WebServlet("/guest_modify_form.do")
public class GuestModifyFormServlet extends HttpServlet {
	
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String forwardPath="";
	forwardPath="forward:/WEB-INF/views/guest_modify_form.jsp";
	
	/*
	GET방식이면 guest_main.jsp redirection

	 	0.요청객체encoding설정
	 	1.guest_no 파라메타받기
	 	2.GuestService객체생성
	 	3.GuestService객체 selectByNo(guest_no) 메쏘드호출
	 	4.Guest 객체 얻기
	 	5. ruquest에 객체담기
	*/
	try {
		
	if(request.getMethod().equalsIgnoreCase("GET")){
		//response.sendRedirect("guest_main.do");
		//return;
		forwardPath = "redirect:guest_main.do";
	}
	String guest_noStr=request.getParameter("guest_no");
	GuestService guestService=new GuestService();
	Guest guest=
			guestService.selectByNo(Integer.parseInt(guest_noStr));
		request.setAttribute("guest", guest);
		forwardPath = "froward:/WEB-INF/views/guest_modify_form.jsp";
	
	} catch (Exception e) {
		e.printStackTrace();
		forwardPath = "froward:/WEB-INF/views/guest_error.jsp";

		
	}
	/********************** forward, redirect *********************/
	/*
	   forward --> forward : /WEB-INF/views/guest_xxx.jsp; 
	   redirect --> redirect : guest_xxx.do
	 */
	String[] pathArray = forwardPath.split(":");
	String forwardOrRedirect = pathArray[0];
	String path=pathArray[1];
	if(forwardOrRedirect.equals("redirect")) {
		response.sendRedirect(path);
	} else if(forwardOrRedirect.equals("forward")) {
		RequestDispatcher rd = 
				request.getRequestDispatcher(path);
		rd.forward(request,response);
	}else {
		
	}
	/*************************************************************/
	

	}
}
