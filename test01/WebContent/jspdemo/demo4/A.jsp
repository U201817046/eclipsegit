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
		jstl:
			注意：使用jstl标签库需要导入当前jsp页面。
			导入格式：
				<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	 
	 		jstl也称为自定义标签库，不可以太随意的起名字，一般都使用默认的"c"做为自定义的标签名字
	 --%>
	 
	 <!-- 输出方式1：默认输出 -->
	 <c:out value="我是输出 的字符串"/>
	 <hr>
	  <!-- 输出方式2：默认输出,如果value没有参数值的时候，输出default的值
	   
	  		注意，jstl的输出标签的默认值，需要在el表达式取不到容器值时可以进行输出默认值
	   -->
	  <%//request.setAttribute("req", "res值"); %>
	 <c:out value="${requestScope.req12 }" default="我是默认值"/>
	 
	 <hr>
	  <!-- 输出方式3：设置输入得内容显示的格式 
	  	escapeXml设置输入的内容显示的格式：
	  		false为默认值，表示可以输入代码
	  		true表示输入的代码将被转译成字符串进行显示
	  -->
	  <c:out value="<h1>我是h1标签</h1>" escapeXml="true"/>
	  
	  
	  
	  
</body>
</html>