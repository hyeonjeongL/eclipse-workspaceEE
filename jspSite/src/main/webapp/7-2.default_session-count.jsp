<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session = "true"
%>
    
    <!-- 
    
     <<요청시 JESSIONID쿠키존재안할때>>
         1.JESSIONID쿠키존재여부판단후 JESSIONID쿠키존재하지않으면
            세션아이디 발행후 HttpSession 객체를 생성한후 세션아이디를설정반환
         2.HttpSession객체사용  
         3.JESSIONID이름의 session쿠키객체를 생성한후 응답객체에 추가 
     
      <<요청시 JESSIONID쿠키존재할때>> 
         1.JESSIONID쿠키존재여부판단후 JESSIONID쿠키존재하면
           	JSESSIONID쿠키의 값(세션아이디)을 사용해서 서버에존재하는
            HttpSession객체중에서  세션아이값과 일치하는 HttpSession객체반환(세션바인딩) 
         2.HttpSession객체사용
 -->
 <%
 
 int count= 0;
 /*
 
 */
 Integer countInt = (Integer)session.getAttribute("count");
 if(countInt==null){
	 //count key값의 속성객체가 존재하지 않는경우
	 count = 0;
 }else{
	 //count key값의 속성객체가 존재하는 경우
	 count=countInt.intValue();
 }
 count++;
 
 /*
	세션장바구니객체에 count라는 key로 Integer객체를 저장합니다.
	세션장바구니객체는 저장데이타를 HashMap으로 관리합니다.
	*/
 
 session.setAttribute("count", new Integer(count));
 
 	System.out.println("-------------------------------------------------");
	System.out.println("클라이언트IP                  --->"+request.getRemoteAddr());
	System.out.println("세션객체참조변수[생성,바인딩] --->"+session);
	System.out.println("세션객체아이디                --->"+session.getId());
	System.out.println("세션객체에저장된 카운트값     --->"+count);
	System.out.println("-------------------------------------------------");
 %>   
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HttpSession객체를 사용한 클라이언트 브라우저별 요청횟수 카운트 </h1>
	<h3><%=session.getId() %> 님 <%=count %>번째 요청입니다.</h3>
	<br>
	<br>
	<ol>
		<li> session 객체 참조변수 : <%=session%></li>
		<li> session 객체 생성여부 : <%=session.isNew()%></li>
		<li> session 객체 세션아이디 : <%=session.getId()%></li>
		<li> session 객체 생성시간 : <%=session.getCreationTime()%></li>
		<li> session 객체 유효시간 : <%=session.getMaxInactiveInterval()%></li>
		<li> session 객체 마지막바인딩시간 : <%=session.getLastAccessedTime()%></li>
</ol>
	
</body>
</html>