package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloTextServlet extends HttpServlet {
	
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");//응답객체헤더
		PrintWriter out = response.getWriter();
		out.println("Hello text[dynamic resource 1]!!!"); //바디데이터
		out.println("Hello text[dynamic resource 2]!!!");
		out.println("Hello text[dynamic resource 3]!!!");
		return; //컨테이너에게 반환

	}

}
