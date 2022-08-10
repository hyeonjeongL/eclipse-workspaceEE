package com.itwill.summer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

public class GuestMoidfyActionController implements Controller {
	private GuestService guestService;
	
	public GuestMoidfyActionController() {
		guestService = new GuestService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		try {
			if (request.getMethod().equalsIgnoreCase("GET")) {
				/*
				response.sendRedirect("guest_main.do");
				return;
				*/
				forwardPath="redirect:guest_main.do";
			}else {
				String guest_noStr = request.getParameter("guest_no");
				String guest_name = request.getParameter("guest_name");
				String guest_email = request.getParameter("guest_email");
				String guest_homepage = request.getParameter("guest_homepage");
				String guest_title = request.getParameter("guest_title");
				String guest_content = request.getParameter("guest_content");
				Guest guest = new Guest(Integer.parseInt(guest_noStr), guest_name, null, guest_email, guest_homepage,
						guest_title, guest_content);
				int rowCount = guestService.updateGuest(guest);
				//response.sendRedirect("guest_view.do?guest_no=" + guest_noStr);
				//forwardPath = String.format("redirect:guest_view.do?guest_no=%s", guest_noStr);
				forwardPath = "redirect:guest_view.do?guest_no="+guest_noStr;
			}
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
		}
		return null;
	}

}
