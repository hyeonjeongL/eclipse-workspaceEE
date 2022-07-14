package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleFounterServlet
 */
@WebServlet("/lifecycle_counter.do")
public class LifeCycleCounterServlet extends HttpServlet {
	
	public LifeCycleCounterServlet() {
		System.out.println("0.LifeCycleCounterServlet() 기본생성자호출[최초 요청시 단 한 번의 객체 생성] 객체주소-->"+this);
	}
	@Override
		public void init(ServletConfig config) throws ServletException {
			super.init(config);
			System.out.println("1. init()메소드 --> 생성자호출 직후에 단 한 번 호출[객체초기화,리소스획득]");
		}
	
	@Override
	public void destroy() {
		System.out.println("3. destroy()메소드 --> 서블릿객체가 메모리에서 해제되기 직전에 호출[리소스반납]");
	}

	private int count=0;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		count++;
		System.out.println("2. service메소드실행(count=" +count +")클라이언트["+request.getRemoteAddr()+"]가 요청 할 때 마다 실행 객체주소"+this);
		/*
		 * 응답객체에 contentType설정
		 */
		response.setContentType("text/html;charset=UTF-8");
		/*
		 * 클라이언트로 전송할 스트림객체생성
		 */
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body bgcolor=#40e0d0 style=\"font-size: 9pt; line-height: 140%;\">");
		out.println("	<center>");
		out.println("		현재까지의 페이지뷰수 <font color=#0000FF> "+ count +" </font> 번입니다");
		out.println("	</center>");
		out.println("</body>");
		out.println("</html>");
	}

}
