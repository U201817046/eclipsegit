<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jsp小脚本 ：
		jsp小脚本，业内称为java片段
	-->
	<!-- 局部变量 -->
	<%
		String name="张三";
	%>	
	
	<!-- 全局变量 -->
	<%! String password = "abc123"; %>
	
	<!-- 定义函数 -->
	<%!
	 public void t1(){
		
		
	 }
	%> 
	
	
	<!-- 输出 -->
	控制台输出：
	<%
		System.out.println("我是在控制台上进行的输出"+name);
		System.err.println("我是在控制台上进行的输出"+name);
	%>
	<br>
	在jsp页面上输出：
		<%
			out.println("李四<br>");
			out.write("赵六");
		%>
		
	<br>
	<!-- 表达式输出 -->
	<%="田七" %><br>
	<%=name %>
	
	<br>
	<!-- 注释：
		注意，htnl注释无法注释java片段,而注释java程序只能使用java的注释或者jsp注释
	 -->
	<!-- <%=1+2 %> -->
	
	<!-- jsp注释 -->
	<%--
		<%=10+2 %>
	--%>
		<%//=20+2 %> 
</body>
</html>