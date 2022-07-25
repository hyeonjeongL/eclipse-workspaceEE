<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("UTF-8");

if(request.getMethod().equals("GET")){
	response.sendRedirect("guest_main.jsp");
	return;
}

String noStr = request.getParameter("guest_no");

GuestService guestService = new GuestService();
guestService.deleteGuest(Integer.parseInt(noStr));

response.sendRedirect("guest_main.jsp");


%>