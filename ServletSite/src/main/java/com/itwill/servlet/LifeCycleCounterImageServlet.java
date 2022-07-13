package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle_image_counter.do")
public class LifeCycleCounterImageServlet extends HttpServlet {

	private int count = 0;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		count++;
		System.out.println("2.service 메쏘드실행(count=" + count + ") -->클라이언트가 요청할때마다실행");
		/*
		 * 응답헤더의 contentType설정
		 */
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body bgcolor=#40e0d0 style=\"font-size: 9pt; line-height: 140%;\">");
		out.println("	<center>");
		/*
		 * img 태그를 사용해서 출력
		 */
		out.println("		현재까지의 페이지뷰수 <font color=#0000FF> " + count + "</font> 번입니다");
		out.println("<br>");
		out.println("현재까지의 페이지뷰수");
		
		String strCount = Integer.toString(count);
		for(int i = 0; i<strCount.length(); i++) {
			out.println("<img src='images/"+ strCount.charAt(i)+".png'>");
		}
		
		
//		out.println("<img src='images/"+count/10+".png'>");
//		out.println("<img src='images/"+count%10+".png'>");
		
		
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
//				out.println("<img src='images/"+i+".png'>");
//
//			}
//		}
//			
//		
//		if (count == 1) {
//			out.println("<img src='images/1.png'>");
//		} else if (count == 2) {
//			out.println("<img src='images/2.png'>");
//		} else if (count == 3) {
//			out.println("<img src='images/3.png'>");
//		} else if (count == 4) {
//			out.println("<img src='images/4.png'>");
//		} else if (count == 5) {
//			out.println("<img src='images/5.png'>");
//		} else if (count == 6) {
//			out.println("<img src='images/6.png'>");
//		} else if (count == 7) {
//			out.println("<img src='images/7.png'>");
//		} else if (count == 8) {
//			out.println("<img src='images/8.png'>");
//		} else if (count == 9) {
//			out.println("<img src='images/9.png'>");
//		} else if (count == 0) {
//			out.println("<img src='images/0.png'>");
//		}




//		if(count == count++) {
//			out.println("<img src='images/1.png'>");
//		}
//		
		// out.println("<img src='images/5.png'>");

		out.println(" 번입니다");
		out.println("	</center>");
		out.println("</body>");
		out.println("</html>");
	}
}