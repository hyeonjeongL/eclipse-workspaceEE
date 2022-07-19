<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<TITLE>방가워요 JSP</TITLE>
</HEAD>
<BODY>
	<center>
		<H2>JSP 잘났어 정말 별꼴이야!!!!!!!!!</H2>
		<%-- 
			스크립렛 <% ~ %>
		 --%>
		<img src='snoopy.jpg' />
		<H2>JSP구구단[scriptlet(스크립트렛)]</H2>
		<table border=1 width=600 bgcolor=#CCFF33 bordercolordark=#FF6600
			cellspacing=0>
			<%
			for (int i = 1; i <= 9; i++) {
			%>
			<tr>
				<%
				for (int j = 2; j < 9; j++) {
				%>
				<td align=center><%out.println(j);%>*<%out.println(i);%>=<%out.println(j*i);%></td>
				<%
				}
				%>
			</tr>
			<%
			}
			%>
		</table>
		<%--
			표현식 <% ~ %>
 		 --%>
		<H2>JSP구구단[expression(표현식)]</H2>
		<table border=1 width=600 bgcolor=#CCFF33 bordercolordark=#FF6600
			cellspacing=0>
			<%
			for (int i = 1; i <= 9; i++) {
			%>
			<tr>
				<%
				for (int j = 2; j < 9; j++) {
				%>
				<td align=center><%=j%>*<%=i%>=<%=j*i%></td>
				<%
				}
				%>
			</tr>
			<%
			}
			%>
		</table>
	</center>
	<br />
</BODY>
</HTML>
