<%@page import="com.itwill.shop.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="login_check.jspf" %>  
 <% 
 
 	if(request.getMethod().equalsIgnoreCase("GET")){
 		response.sendRedirect("main.jsp");
 		return;
 	}
 	try{
	UserService userService = new UserService();
	
	int removeUser = userService.remove(s_u_id);
	
	response.sendRedirect("user_logout_action.jsp");
 	}catch(Exception e){
 		e.printStackTrace();
 		response.sendRedirect("main.jsp");
 	}
	
	%>
 