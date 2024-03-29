package com.itwill.summer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

public class GuestViewController implements Controller {
	private GuestService guestService;
	public GuestViewController() {
		guestService = new GuestService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		try {
			 String guest_noStr=request.getParameter("guest_no");
			 if(guest_noStr==null ||guest_noStr.equals("")){
				 /*
				 response.sendRedirect("guest_main.do");
				 return;
				 */
				 forwardPath="redirect:guest_main.do";
			 }else {
				 Guest guest=guestService.selectByNo(Integer.parseInt(guest_noStr));
				 request.setAttribute("guest", guest);
				 forwardPath="forward:/WEB-INF/views/guest_view.jsp";
			 }
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
		return forwardPath;
	}

}
