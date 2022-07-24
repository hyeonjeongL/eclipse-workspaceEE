<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("UTF-8");


if(request.getMethod().equalsIgnoreCase("GET")){
	response.sendRedirect("guest_main.jsp");
	return;
}




%>