package com.itwill.summer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.GuestService;

public class GuestRemoveActionContoller implements Controller {
	private GuestService guestService;
	public GuestRemoveActionContoller() {
		guestService = new GuestService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		try {
			if(request.getMethod().equalsIgnoreCase("GET")){
				/*
				response.sendRedirect("guest_main.do");
				return;
				*/	
				forwardPath="redirect:guest_main.do";
			}else {
				String guest_noStr =request.getParameter("guest_no");
				int rowCount=guestService.deleteGuest(Integer.parseInt(guest_noStr));
				//response.sendRedirect("guest_list.do");
				forwardPath="redirect:guest_list.do";
			}
		}catch(Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
		return forwardPath;
	}

}
