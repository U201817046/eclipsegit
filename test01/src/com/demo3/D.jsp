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
		EL运算符
	 --%>
	 ${8-9 }
	 ${8<9 }
	 
	 <hr>
	 <%--
		EL运算符
			注意：EL会自动转型
	 --%>
	 <%
	 	String strNum = "20";
	 
	 	request.setAttribute("req",strNum);
	 %>
	 ${requestScope.req+5 }
	  <hr>
	 <%--
	 	三元运算符（三目运算符）
	 		运算符格式：
	 			条件？true执行：fasle执行
	  --%>
	 ${2>1?"执行1":"执行2" }
	 
	<hr>
	<%
		String sex = "女";
	    request.setAttribute("sex", sex);
	    
	    
	%>
	<input type="radio" ${requestScope.sex=="男"?"checked":"" }>男 
	<input type="radio" ${requestScope.sex=="女"?"checked":"" }>女 
	
	<input type="radio" <%=request.getAttribute("sex").equals("男")?"checked":"" %>>
	 
</body>
</html>