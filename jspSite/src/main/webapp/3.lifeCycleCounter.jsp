<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%! 
    private int count = 0;
    public void jspInit(){
    	System.out.println("1. jspInit메소드 생성자호출 후 단 한 번 호출되는 메소드 객체초기화시 사용()");
    }
    public void jspDestroy(){
    	System.out.println("3.jspDestroy()메소드 객체가 메모리에서 해지될 때 호출(리소스반환)");
    }
    %>
    <%
    	System.out.println("2._jspService()메소드 요청시마다 호출"); 
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
			<body bgcolor=#40e0d0 style=font-size:9pt;line-height:140%;> 
			<center>			
			 현재까지의 접속자수
			<font color=#0000FF>
			 <%= ++count %>
			</font>
			 명입니다 
			</center> 
			</body> 
</html> 
    
    