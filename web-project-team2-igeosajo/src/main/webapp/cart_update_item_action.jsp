<%@page import="com.itwill.toy.service.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="login_check.jspf"%> 
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("product_list.jsp");
		return;
	}
	String cart_noStr=request.getParameter("c_no");
	String cart_qtyStr=request.getParameter("c_qty");
	CartService cartService=new CartService();
	if(cart_qtyStr.equals("0")){
		cartService.deleteCartItem(Integer.parseInt(cart_noStr));
	}else{
		cartService.updateCart(Integer.parseInt(cart_noStr),Integer.parseInt(cart_qtyStr));
	}
	response.sendRedirect("cart_view.jsp");
	/*
	response.sendRedirect("cart_view_select_update_qyt_all_check_delete_image.jsp");
	*/
%>