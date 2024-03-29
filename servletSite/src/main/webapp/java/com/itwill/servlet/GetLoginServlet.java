package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetLoginServlet
 */
@WebServlet("/get_login.do")
public class GetLoginServlet extends HttpServlet {
/*
 *  client GET방식 요청에 의해 실행되는 메소드
 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		/*
		 * 1. 요청시 전송되는 파라메타받기
		 *  - 파라메타의 이름은 input element의 name속성과 일치
		 *    아이디 : <input type="text" name="id"><br>
		 *    패에쓰 : <input type="password" name="pass"<br><br>
		 */
		
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		if(id==null || id.equals("") || pass==null||pass.equals("")){
			
			return;
		}
		/*
		 * 2.f 로그인 업무실행(Servixe객체)
		 * id | pass
		 * ----------
		 * xxx|1111
		 * yyy|2222
		 */
		
		boolean isMember1 = id.equals("xxx")&& pass.equals("1111");
		boolean isMember2 = id.equals("yyy")&& pass.equals("2222");
		out.println("<h1>GET로그인 결과</h1><hr>");
		if(isMember1 || isMember2) {
			//로그인 성공
			out.println("<h3>"+id+"님 로그인 성공</h><hr>");
		}else {
			//로그인 실패
			out.println("<h3>"+id+"님 로그인 실패</h><hr>");
			out.println("<a href='05-01.login_get.hrml'>다시로그인</a>");
		}

	}

}