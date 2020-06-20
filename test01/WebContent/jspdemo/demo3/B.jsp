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
		EL取出容器值格式：
			${key}
	
	 --%>
	 
	取出request容器值：<%=request.getAttribute("req") %><br>
	取出session容器值：<%=session.getAttribute("sess") %><br>
	取出application容器值：<%=application.getAttribute("app") %><br>
	<hr color="blue">
	EL取出request容器值：${requestScope.req }<br>
	EL取出session容器值：${sessionScope.sess} <br>
	EL取出application容器值：${applicationScope.app}<br>
	
	<hr color="yellow">
	<%--
		EL取出url参数值
		格式：${param[.参数名]}
	--%>
	EL取出url参数值：${param }
	<hr>
	用户名：${param.userName }<br>
	密 码：${param.userPassword }<br>
	<hr>
	<%=request.getParameter("userName") %>
	
</body>
</html>