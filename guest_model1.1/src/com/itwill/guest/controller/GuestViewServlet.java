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
@WebServlet("/guest_view.do")
public class GuestViewServlet extends HttpServlet {
		private GuestService guestService;
		public GuestViewServlet() {
			guestService=new GuestService();
		}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 0.요청객체encoding설정
		 * 1.파라메타받기
		 * 2.GuestService객체생성
		 * 3.GuestService객체 selectByNo() 메쏘드호출
		 * 4.Guest 객체얻기
		 */
		 //request.setCharacterEncoding("UTF-8");
		String forwardPath="";
		try {
		 String guest_noStr=request.getParameter("guest_no");
		 if(guest_noStr==null ||guest_noStr.equals("")){
			 response.sendRedirect("guest_main.do");
			 return;
		 }
		 Guest guest=guestService.selectByNo(Integer.parseInt(guest_noStr));
		 request.setAttribute("guest", guest);
		 forwardPath="/WEB-INF/views/guest_view.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			 forwardPath="/WEB-INF/views/guest_error.jsp";
		}
		forwardPath="/WEB-INF/views/guest_view.jsp";
		
		
		RequestDispatcher rd=
				request.getRequestDispatcher(forwardPath);
		rd.forward(request, response);
		
	}

}