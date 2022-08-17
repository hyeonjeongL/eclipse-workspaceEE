<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("sUserId", "guard1");
	request.setAttribute("name", "제임스딘");
	request.setAttribute("age", new Integer(34));
	request.setAttribute("age", 29);
	request.setAttribute("weight", 69.234);
	request.setAttribute("married", true );
	double height = 175.12;
	String address="경기도";
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL String,Wrapper객체(기본형객체) 출력</h1>
<ol>
	<li>${sUserId}</li>
	<li>${name}</li>
	<li>${age}</li>
	<li>${weight}</li>
	<li>${married}</li>
	<li>EL출력 불가능[속성객체가 아니므로]</li>
	<li>${height }</li>
	<li>${address}</li>
	
</ol>
</body>
</html>