<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("UTF-8");


if(request.getMethod().equalsIgnoreCase("GET")){
	response.sendRedirect("guest_main.jsp");
	return;
}

String name= request.getParameter("guest_name");
String email= request.getParameter("guest_email");
String homepage= request.getParameter("guest_homepage");
String title= request.getParameter("guest_title");
String content= request.getParameter("guest_content");

Guest guest = new Guest(0, name, null, email, homepage, title, content);
GuestService guestService = new GuestService();

guestService.insertGuest(guest);

response.sendRedirect("guest_view.jsp");



%>