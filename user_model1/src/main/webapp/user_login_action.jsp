
<%@page import="com.itwill.user.User"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%
	/*
	0  . GET방식요청일때 user_main.jsp로 redirection
	1  . 요청객체 인코딩설정
	2  . 파라메타 받기
	3  . UserService객체생성
	4  . UserService.create() 메쏘드실행
	5-1. 아이디중복이면 user_write_form.jsp  
	5-2. 가입성공이면   user_login_form.jsp 로 redierction
	 */
	 request.setCharacterEncoding("UTF-8");
	if (request.getMethod().equalsIgnoreCase("GET")) {
		response.sendRedirect("user_login_form.jsp");
		return;
	}	
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	UserService userService = new UserService();
	int result = userService.login(userId, password);
	
	/*
	 * 회원로그인
	 * 
	 * 0:아이디존재안함
	 * 1:패쓰워드 불일치
	 * 2:로그인성공(세션)
	 */
	 
	if(result==0){
		//0:아이디존재안함
		String msg1 = userId+"는  존재하지 않는 아이디입니다.";
		/**************case1 script**************
		out.println("<script>");
		out.println("alert('"+msg1+"')");
		out.println("location.href='user_login_form.jsp';");
		out.println("</script>");
		*/
		
		/************case 2 forward********************/
		request.setAttribute("msg1", msg1);
		User fuser = new User(userId,password,"","");
		request.setAttribute("fuser", fuser );
		
		RequestDispatcher rd = request.getRequestDispatcher("user_login_form.jsp");
		rd.forward(request, response);
		
	} else if(result==1){
		//1:패스워드 불일치
		String msg2 = "패스워드가 일치하지 않습니다.";
		/**************case2 script1**************
		out.println("<script>");
		out.println("alert('"+msg2+"')");
		out.println("location.href='user_login_form.jsp';");
		out.println("</script>");
		*/
		request.setAttribute("msg2", msg2);
		User fuser = new User(userId,password,"","");
		request.setAttribute("fuser", fuser );
		
		RequestDispatcher rd = request.getRequestDispatcher("user_login_form.jsp");
		rd.forward(request, response);
	} else if(result==2){
		//2:로그인성공(세션)
		session.setAttribute("sUserId", userId);
		response.sendRedirect("user_main.jsp");
	}
	 
		/*################# result == 0 ###################*/
	
	/*################# result == 1 ###################*/
	
	/*################# result == 2 ###################*/
%>