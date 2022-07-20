<%@page import="com.itwill.address.AddressService"%>
<%@page import="com.itwill.address.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
 * 0.요청객체encoding설정
 * 1.파라메타받기(id,name,phone,address)--> Address객체생성
 * 2.AddressService객체생성
 * 3.AddressService.insert(Address객체)메쏘드실행
 * 4.address_list.jsp 로 redirection
 */

%>

