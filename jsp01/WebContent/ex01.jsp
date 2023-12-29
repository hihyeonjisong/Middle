<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP예제</title>
</head>
<body>
	<%
	java.util.Random ran = new java.util.Random();
	
	int total=0;
	for(int i =1; i<=ran.nextInt(10); i++){
		total+=i;
	}
	
	%>
	1부터10까지의 합: <%= total %>
</body>
</html>