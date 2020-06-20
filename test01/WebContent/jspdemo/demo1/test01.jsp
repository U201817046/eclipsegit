<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	hello world JSP!
	
	<%
		for(int i=0;i<5;i++){
	%>
	<h1>我是h1标签<%=i+1 %></h1>
	<%} %>
	<!-- 
		jsp：
			jsp是动态网页技术之一，他是运行在服务端的程序，不可以直接运行在本地浏览器上运行
			
			jsp第一次为什么运行比较慢，第二次比较快？
			
	 -->
	 
	 
	 
	 
	 
	 
</body>
</html>