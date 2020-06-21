<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <body>
	<%--
		jstl存入容器值
	 --%>
	 <!-- 存 
	  	var="String Key" 
	  	value="Object value" 
	  	scope="page、req est、session、application"
	 -->
	 <c:set var="sess" value="我 时session容器值<font color='red'>我时h1标签</font>" scope="session"/>
	 
	 <!-- 取 -->
	 java片段取出容器值：<%=session.getAttribute("sess") %><br>
	 EL表达式取：${sessionScope.sess }<br>
	 EL+jstl取值：<c:out value="${sessionScope.sess }"/>
	                     
	 <hr color="red">
	 
	 
	  <c:set var="sess" value="aaa" scope="session"/>
	  <c:set var="sess" value="bbb" scope="request"/>
	  <c:set var="sess" value="bbb" scope="application"/>
	 <%-- 移除 
	  方式1：
	  	<c:remove var="" />表示移除所有key值一样的容器中的参数值
	  方式2：
	    <c:remove var="" scope=""/>表示移除指定容器中的参数值
	    scope="page、request、session、application"
	 --%>
	 <c:remove var="sess" scope="session"/>
	 
	 
	 request取出值1：${requestScope.sess }<br>
	  session取出值2：${sessionScope.sess }<br>
	  application取出值3：${applicationScope.sess }<br>
	 
</body>
</html>