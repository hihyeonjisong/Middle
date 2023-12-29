<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP기본문법</title>
</head>
<body>
	<h2>JSP기본문법예제</h2>
	<%
	String str = "스트립틀릿 입니다.";
	String comment = "주석";
	%>
	선언문 : <%= declration %> <br> <!-- 표현식: 값을출력(처리,연산코드사용불가 -->
	스크립틀릿: <%= str %> <br>
	<!-- <%= comment %>-->
	<%-- <%= comment %>--%>
	
	<%! //선언문(멤버필드,멤버메소드정의)
	String declration = "선언문"; 
	%>
</body>
</html>