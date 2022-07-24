<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	
<%	if(request.getMethod().equalsIgnoreCase("GET")){
	response.sendRedirect("guest_main.jsp");
	return;
	}
	
	request.setCharacterEncoding("UTF-8");
	
	String noStr =request.getParameter("guest_no");
	String name =request.getParameter("guest_name");
	String date = request.getParameter("geust_date");
	String email =request.getParameter("guest_email");
	String homepage =request.getParameter("guest_homepage");
	String title =request.getParameter("guest_title");
	String content =request.getParameter("guest_content");
	
	int guest_no = Integer.parseInt(noStr);
	
	Guest guest = new Guest(guest_no, name, date, email, homepage, title, content);
	
	GuestService guestService = new GuestService();
	guestService.updateGuest(guest);
	
	response.sendRedirect("guest_view.jsp?guest_no="+noStr);
	%>