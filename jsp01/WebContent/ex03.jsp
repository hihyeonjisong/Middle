<%@page import="com.itextpdf.text.log.SysoCounter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSPInit</title>
</head>
<body>
	<%
	/* private int num1=0; */
	/* public void jspInit(){
		System.out.println("jspInit()호출됨");
	}
	public void jspDestroy(){
		System.out.println("jspDestroy()호출됨");
	} */
	%>
	<%
	int num2=0;
	//num1++;
	num2++;
	//System.out.println("num1: ");
	System.out.println("num2: ");
	%>
	<ul>
		<%-- //<li>num1: <%=num1 %></li> --%>
		<li>num2: <%=num2 %></li>
	</ul>

</body>
</html>