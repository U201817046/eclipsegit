<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
		EL表达式：
			EL主要用于去除容器中的数据，但是不能存入数据
			格式：${内容}
			
		主要功能：
			1、取出容器中的数据
			2、取出url携带的参数值
			3、运算，如三元运算符
	 --%>

	<%
		//page容器
		pageContext.setAttribute("pag", "我是page容器值");
		//request容器 一次请求有效
		request.setAttribute("req", "我是request容器值");
		//session容器值 一次会话有效
		session.setAttribute("sess", "我是session容器值");
		//application容器 只要服务器不关闭不重启都有效
		application.setAttribute("app", "我是application容器值");
		
	%>
	
	
	<!-- 跳转到B.jsp测试获取值 -->
	<%
		//转发
		//request.getRequestDispatcher("B.jsp").forward(request, response);
		
		//重定向
		response.sendRedirect("B.jsp");
	%>
</body>
</html>