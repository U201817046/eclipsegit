<%@page import="java.security.interfaces.RSAKey"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   %>
 <%@ page  import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
查询结果:<br>
<%
Class.forName("com.mysql.jdbc.Driver");
		//2、获取链接数据库的会话对象
		//链接地址
		String url = "jdbc:mysql://localhost:3306/test01";
		// 用户名
		String user = "root";
		// 用户密码 你的数据库密码
		String password = "lwd123456";

		Connection conn = DriverManager.getConnection(url, user, password);
		
		String id=request.getParameter("userID");
		
		// 3、构造sql语句
		String sql = "select * from student where stu_id="+id;
		// 4、获取执行对象
		Statement stmt = conn.createStatement();
		// 5、执行sql语句，并处理执行状态结果
		ResultSet rs = stmt.executeQuery(sql);
	

//         out.println(rs.getString("stu_id")+"  "
// 					+rs.getString("stu_name")+" "
// 					+rs.getString("stu_password")+"  "
// 					+rs.getString("stu_age")+" "
// 					+rs.getString("stu_sex")+" "
// 					+rs.getString("stu_address"));
				
		while (rs.next()) {
					out.println(rs.getString("stu_id")+"  "
							+rs.getString("stu_name")+" "
							+rs.getString("stu_password")+"  "
							+rs.getString("stu_age")+" "
							+rs.getString("stu_sex")+" "
							+rs.getString("stu_address"));
				}
		// 6、释放资源
		rs.close();
		stmt.close();
		conn.close();

%>
</body>
</html>