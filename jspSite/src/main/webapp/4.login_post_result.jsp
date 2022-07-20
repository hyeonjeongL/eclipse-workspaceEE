<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	if (request.getMethod().equalsIgnoreCase("GET")) {
	/*
	클라이언트에서 GET방식의 요청으로 실행하면
	4.login_post+form.jsp으로 REDIRECT(방향재지정)
	*/
	response.sendRedirect("4.login_post+form.jsp");
	return;
	}
	/*
	0. 요청객체 인코딩 설정
	*/
	request.setCharacterEncoding("text/html;charset=UTF-8");
	/*
	 * 1.파라메타바끼
	  	아이디:<input type="text" name="id">
		패에쓰:<input type="password" name="pass">
	 */
	 String id = request.getParameter("id");
	 String pass = request.getParameter("pass");
	 
	
	/*
	 * 2.업무실행(DB)
	 *  id |pass
	 *  ---------
	 *  xxx|1111
	 *  yyy|2222
	 */
	
	/*
	 * 3.클라이언트로 결과전송
	 */
	 
		
		boolean isMember1 = id.equals("xxx")&& pass.equals("1111");
		boolean isMember2 = id.equals("yyy")&& pass.equals("2222");
		out.println("<h1>POST로그인 결과</h1><hr>");
		if(isMember1 || isMember2) {
			//로그인 성공
			out.println("<h3>"+id+"님 로그인 성공</h><hr>");
			out.println("<a href='index.jsp'>메인으로/a>");
			
		}else {
			//로그인 실패
			out.println("<h3>"+id+"님 로그인 실패</h><hr>");
			out.println("<a href='4.login_post+form.jsp'>다시로그인</a>");
		}

 
%>
