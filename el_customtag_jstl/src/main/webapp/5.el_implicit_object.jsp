<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%
	 pageContext.setAttribute("url", "page.jsp");
	 request.setAttribute("url", "request.jsp");
	 session.setAttribute("url", "session.jsp");
	 application.setAttribute("url", "papplication.jsp");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL 내장객체(implicit object) 타입은맵이다.</h1><hr>
<ul>
	<li>---pageScope,requestScope,sessionScope,applicationScope---</li>
	<li>${url }</li>
	<li>${pageScope.url }</li>
	<li>${requestScope.url }</li>
	<li>${sessionScope.url }</li>
	<li>${applicationScope.url }</li>
	
	<li>--------param---------</li>
	<li>${param }</li>
	<li>${param.id }</li>
	<li>${param.name }</li>
	<li>${param.hobby }</li>
	
	<li>--------paramValues---------</li>
	<li>${paramValue.hobby }</li>
	<li>${paramValue.hobby[0] }</li>
	<li>${paramValue.hobby[1] }</li>
	<li>${paramValue.hobby[2] }</li>
	
	<li>--------cookie---------</li>
	<li>${cookie}</li>
	<li>${cookie.JSESSIONID }</li>
	<li>${cookie.JSESSIONID.value }</li>
	<li>--------pageContext[빈객체]---------</li>
	<li>${pageContext.out}</li>
	<li>${pageContext.request}</li>
	<li>${pageContext.request.method}</li>
	<li>${pageContext.session}</li>
	<li>${pageContext.session.maxInactiveInterval}</li>
	<li>${pageContext.response}</li>
	<li>${pageContext.response.bufferSize}</li>
	<li>${pageContext.servletConfig}</li>
	<li>${pageContext.servletConfig.initParameterNames}</li>
	<li>${pageContext.servletContext}</li>
	
</ul>
</body>
</html>