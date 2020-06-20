    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr color="red">
	取出request容器值：<%=request.getAttribute("req12") %><br>
	取出session容器值：<%=session.getAttribute("sess") %><br>
	取出application容器值：<%=application.getAttribute("app") %><br>
</body>
</html>