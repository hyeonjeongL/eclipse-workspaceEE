package com.itwill.guest.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.summer.Controller;

/*
 * - 클라이언트요청한개를 처리하는 비즈니스로직을 담고있는 객체
 * - DispatcherServlet객체가 호출하는 handleRequest메쏘드를가짐
 * - handleRequest메쏘드가호출되면 DispatcherServlet객체에 forwardPath를 반환해줌
 */
public class GuestModifyActionController implements Controller {
	private GuestService guestService;
	public GuestModifyActionController() {
		guestService = new GuestService();
	}

	public String handleRequest(HttpServletRequest request, HttpServletResponse response)  {
		String forwardPath = "";
		/*
		 * 1.GET방식이면 user_main.do로 redirection
		 * 2.파라메타받기
		 * 3.GuestService객체사용해서 수정
		 * 4.guest_view.do 로 redirection
		 */
		try {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			response.sendRedirect("guest_main.do");
		}else {
			String guest_noStr = request.getParameter("guest_no");
			String guest_name = request.getParameter("guest_name");
			String guest_date = request.getParameter("guest_date");
			String guest_email = request.getParameter("guest_email");
			String guest_homepage = request.getParameter("guest_homepage");
			String guest_title = request.getParameter("guest_title");
			String guest_content = request.getParameter("guest_content");
			Guest guest = new Guest(Integer.parseInt(guest_noStr), guest_name, guest_date, guest_email, guest_homepage, guest_title, guest_content);
			int rowCount = guestService.updateGuest(guest);
			forwardPath = "redirect:guest_view.do?guest_no="+guest_noStr;
			
		}
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/guest_error.do";
			
		}
		return forwardPath;
	}
}
