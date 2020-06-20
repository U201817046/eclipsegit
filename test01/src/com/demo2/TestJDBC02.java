package com.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/** 
 * <p>Title: TestJDBC02.java</p> 
 * @author smallFish 
 * @date 2020年6月18日 
 * @version 1.0 
 * <p>功能描述:执行对象 </p> 
 * 创建一个 Statement 对象来将 SQL 语句发送到数据库。
 * 不带参数的 SQL 语句通常使用 Statement 对象执行。 
 * 如果多次执行相同的 SQL 语句，使用 PreparedStatement 对象可能更有效。 
 * 
 * jdbc的两个执行对象：
 * 	1、Statement
 * 			Statement stmt = conn.createStatement();
 * 		 1.1执行sql语句函数
 * 			stmt.executeQuery/Upadte(sql)
 *  2、PreparedStatement
 * 		PreparedStatement pstmt = conn.prepareStatement(sql);
 * 		2.1执行sql语句函数
 * 			pstmt.executeQuery/Upadte()
 *区别：
 *	区别1：
 *	 Statement对象可以执行静态的sql语句
 *	 PreparedStatement 可以执行带有占位符的sql语句和静态的sql语句
 *
 *	区别2：
 *		Statement对象有sql注入的风险
 *		PreparedStatement可以有效的规避sql注入
 *
 *静态的sql语句：
 *	delete from student where stu_id=1001;
 *  select * from student
 *	....
 *
 *带有占位符的SQL语句：
 *	delete from student where stu_id=?;
 *  insert into student values(?,?,?,?)
 */
public class TestJDBC02 {
	public static void main1(String[] args)throws Exception {
		//1、加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取链接数据库的会话对象
		//链接地址
		String url = "jdbc:mysql://localhost:3306/test01";
		// 用户名
		String user = "root";
		// 用户密码 你的数据库密码
		String password = "lwd123456";

		Connection conn = DriverManager.getConnection(url, user, password);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您要查询的ID：");
		String id = sc.nextLine();
		
		// 3、构造sql语句
		String sql = "select * from student where stu_id="+id;
		// 4、获取执行对象
		Statement stmt = conn.createStatement();
		// 5、执行sql语句，并处理执行状态结果
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString("stu_id")+"  "
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
	}
	
	public static void main2(String[] args)throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取链接数据库的会话对象
		//链接地址
		String url = "jdbc:mysql://localhost:3306/test01";
		// 用户名
		String user = "root";
		// 用户密码 你的数据库密码
		String password = "lwd123456";


		Connection conn = DriverManager.getConnection(url, user, password);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您要查询的ID：");
		String id = sc.nextLine();
		
		// 3、构造sql语句
		String sql = "select * from student where stu_id=?";
		// 4、获取执行对象
		 PreparedStatement stmt = conn.prepareStatement(sql);
		 
		 /*
		  * 给占位符赋值
		  * void setObject(int parameterIndex, Object x)
		  * 功能：给占位符赋值
		  * parameterIndex 表示占位符“？”的位置
		  * x 给占位符赋予的参数值
		  */
		 stmt.setObject(1, id);
		 
		 
		 System.out.println(stmt.toString());
		// 5、执行sql语句，并处理执行状态结果
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("stu_id")+"  "
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
	}
	
	public static void main(String[] args)throws Exception {
		//1、加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取链接数据库的会话对象
		//链接地址
		String url = "jdbc:mysql://localhost:3306/test01";
		// 用户名
		String user = "root";
		// 用户密码 你的数据库密码
		String password = "lwd123456";


		Connection conn = DriverManager.getConnection(url, user, password);
		
		// 3、构造sql语句
		String sql = "update student set stu_name=?,stu_sex=?,stu_age=? where stu_id=?";
		// 4、获取执行对象
		 PreparedStatement stmt = conn.prepareStatement(sql);
		 
		 /*
		  * 给占位符赋值
		  * void setObject(int parameterIndex, Object x)
		  * 功能：给占位符赋值
		  * parameterIndex 表示占位符“？”的位置
		  * x 给占位符赋予的参数值
		  * 
		  * stu_name=? 1   
		  * stu_sex=?  2
		  * stu_age=?  3
		  * tu_id=?    4
		  */
		 stmt.setObject(1, "欧阳锋");
		 stmt.setObject(2, "女");
		 stmt.setObject(3, "43");
		 stmt.setObject(4, 1007);
		 
		 System.out.println(stmt.toString());
		// 5、执行sql语句，并处理执行状态结果
		 stmt.executeUpdate();
		 
		// 6、释放资源
		stmt.close();
		conn.close();
	}
}

 