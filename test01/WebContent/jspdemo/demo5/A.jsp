<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.endity.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	jstl流程控制语句
 --%>
 <%--
 	if语句
 		格式1：
 			<c:if test="条件"></c:if>
  --%>
 <c:set var="sess" value="true" scope="session"/>
 <c:if test="${sessionScope.sess }">
 	执行1
 </c:if>
 <hr color="red">
  <%--
 	if语句
 		格式2：
 			<c:if test="条件" var="" scope=""></c:if>
 			将条件值存到容器中
 			 var="key" scope="page、request、session、application"
 			 注意此时的容器存储的值就是 test的条件值
 			
  --%>
 <c:if test="${3>2 }" var="se2" scope="session">
 	执行1
 </c:if>
 <br>
 <c:if test="${sessionScope.se2 }" >
 	执行2
 </c:if>
 
 <hr color="green">
  <%--
	for循环
		格式1：<c:forEach begin="1" end="5">
		begin="开始" end="结束"
  --%>
  <c:forEach begin="1" end="5">
  	<h1>我是h1标签</h1>
  </c:forEach>
  <hr color="yellow">
   <%--
	for循环
		格式2：<c:forEach items="" var="">
		items="数组/集合" var="变量名"
		
		取值：${var的值}
  --%>
  <%
 	 String str[] = {"aa","bb","cc","dd"};
  
  	request.setAttribute("arr", str);
  %>
  <c:forEach items="${requestScope.arr }" var="ar">
  	${ar }<br>
  </c:forEach>
    <hr color="green">
   <%--
	for循环
		格式3：<c:forEach items="" var="">
		items="数组/集合" var="变量名"
		varStatus="下标名称"
		
		取出数组或者集合值的格式：${var的值}
		获取下标的取值格式：${下标名称.index}
  --%>
  <%
 	 String st2[] = {"aa","bb","cc","dd"};
  
  	request.setAttribute("arr", st2);
  %>
  <c:forEach items="${requestScope.arr }" var="ar" varStatus="xxz">
  	${ar } ${xxz.index}<br>
  </c:forEach>
  <hr color="blue">
   <%--
	for循环
		格式4：<c:forEach items="" var="">
		items="数组/集合" var="变量名"
		varStatus="下标名称"
		
		取出数组或者集合值的格式：${var的值}
		获取下标的取值格式：${下标名称.index}
  --%>
  <%
  	//存放学生的list集合
 	List<Student> list = new ArrayList<Student>();
  
  	//构造学生
  	Student stu1 = new Student();
				stu1.setStuID(1011);
				stu1.setStuName("卡卡西2");
				stu1.setStuPassWord("abc123");
				stu1.setStuAge("32");
				stu1.setStuSex("男");
				stu1.setStuAddress("木叶村");
  	Student stu2 = new Student();
				stu2.setStuID(1002);
				stu2.setStuName("佐助");
				stu2.setStuPassWord("abc");
				stu2.setStuAge("18");
				stu2.setStuSex("男");
				stu2.setStuAddress("木叶村");
	
	//存入到集合中
	list.add(stu1);
	list.add(stu2);
	
  	request.setAttribute("listStu", list);
  %>
  <c:forEach items="${requestScope.listStu }" var="stu" >
  	${stu.stuName }${stu.stuPassWord } <br>
  </c:forEach>
  
  
  <%
  	Map<String,Student> map 
  		= new HashMap<String,Student>();
  		
  	map.put("stu1", stu1);
  	map.put("stu2", stu2);
  
  	request.setAttribute("mapStu", map);
   %>
  
  <c:forEach items="${requestScope.mapStu }" var="stuMap" >
  	${stu1.stuName }${stu1.stuPassWord } <br>
  </c:forEach>
  

</body>
</html>