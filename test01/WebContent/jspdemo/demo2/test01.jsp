<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>  
<body>
	<!-- jsp的四大域 也称为四个容器
	    容器的范围：
		page：
			当前页面有效。
		request：
			一次请求有效。（转发有效）
		session：
			一次会话有效，session超时除外。（转发和重定向有效）
		application：
			只要服务器不重启不关闭都有效。
		存：
			容器名.setAttribute(String key, Object values) 
		取：
			容器名.getAttribute(key)
		移除：
			容器名.removeAttribute(key)
		注意：这些容器在servlet中也一样可以用。
	-->
	 
	<!-- 存 -->
	<%
		//page容器
		pageContext.setAttribute("pag", "我是page容器值");
		//request容器 一次请求有效
		request.setAttribute("req12", "我是request容器值");
		//session容器值 一次会话有效
		session.setAttribute("sess", "我是session容器值");
		//application容器 只要服务器不关闭不重启都有效
		application.setAttribute("app", "我是application容器值");
		
	%>
	<!-- 取 -->
	<%=pageContext.getAttribute("pag")%>
	
	<!-- 跳转到A.jsp测试获取值 -->
	<%
		//转发
		//request.getRequestDispatcher("A.jsp").forward(request, response);
		
		//重定向
		response.sendRedirect("A.jsp");
	%>
	
	
</body>
</html>