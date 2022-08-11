package com.itwill.guest.controller;

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
public class GuestRemoveActionController implements Controller {
	private GuestService guestService;

	public GuestRemoveActionController() {
		guestService = new GuestService();
	}

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		/*
		 * 1.GET방식이면 user_main.do로 redirection 
		 * 2.파라메타받기 
		 * 3.GuestService객체사용해서 삭제
		 * 4.guest_list.do 로 redirection
		 */
		try {
			if (request.getMethod().equalsIgnoreCase("GET")) {
				//response.sendRedirect("guest_main.do");
				forwardPath="redirect:guest_main.do";

			} else {

				String guest_noStr = request.getParameter("guest_no");
				int rowCount = guestService.deleteGuest(Integer.parseInt(guest_noStr));
				forwardPath="redirect:guest_list.do";
				//왜 리다이렉트지? 포워드하면 왜 오류가 날까
			}
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/guest_error.jsp";

		}
		return forwardPath;
	}
}
