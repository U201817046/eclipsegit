jsp：
	jsp是动态网页技术之一，他是运行在服务端的程序，不可以直接运行在本地浏览器上运行
			
	jsp第一次为什么运行比较慢，第二次比较快？
	
jsp小脚本:	
	jsp小脚本，业内称为java片段.
	
	注意1：jsp是一个固有的模板，不可以去服务器中去修改的它xxx_jsp.java的结构
	注意2：jsp就是一个java类，servlet可以做的事情，jsp也可以做。
	
	局部成员：
		<% java代码  %>  
		注意：所有的局部变量都会生产在jsp模板的_jspService（）函数中。
	全局成员：
		<%! java代码   %>
	输出：
		System.out.print/ln();
		System.err.print/ln();
		
	表达式：
		<%=要输出到页面上的值 %>
		注意，不要有任何的结束符号
		
	jsp注释：
		<%--  java片段  --%>