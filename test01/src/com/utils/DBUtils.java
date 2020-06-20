package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//123
/** 
 * <p>Title: DBUtils.java</p> 
 * @author smallFish 
 * @date 2020年6月18日 
 * @version 1.0 
 * <p>功能描述:操作数据库的工具类</p>  
 */
public class DBUtils {
	// 链接地址
	private String url = "jdbc:mysql://localhost:3306/test01?useUnicode=true&characterEncoding=utf8";
	// 用户名
	private String user = "root";
	// 用户密码 你的数据库密码
	private String password = "lwd123456";
	//数据库连接对象
	private  Connection conn = null;
	
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	/**
		1、加载驱动
	 */
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 /**
	  *<p>Title: getConnect</p> 
	  *<p>功能描述:获取链接数据库的会话对象</p>
	 * @throws SQLException 
	  */
	private void getConnect() {
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("链接数据库成功！！");
		} catch (SQLException e) {
			System.out.println("链接数据库失败！！！");
			e.printStackTrace();
		}

	}
	
	/**
	 *<p>Title: doUpdate</p> 
	 *<p>功能描述:只执行执行增删改的sql </p>
	 *@return int i 表示执行sql的影响行数
	 *@param String Sqls 表示要执行的增删改的sql语句
	 */
	public int doUpdate(String Sqls) {
		//调用连接对象的函数
		getConnect();
		int i=0;
		try {
			//获取执行对象
			stmt = conn.prepareStatement(Sqls);
			
			//执行sql语句，并处理执行状态结果
			i = stmt.executeUpdate();
			System.out.println("执行状态："+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	/**
	 *<p>Title: doQuery</p> 
	 *<p>功能描述: 只执行查询的sql语句</p> 
	 * @param String Sqls 表示查询的sql语句
	 * @return 返回一个ResultSet结果集对象
	 */
	public ResultSet doQuery(String Sqls) {

		// 调用连接对象的函数
		getConnect();
		try {
			// 获取执行对象
			stmt = conn.prepareStatement(Sqls);

			// 执行sql语句，并处理执行状态结果
			rs = stmt.executeQuery();
			
			//处理结果集对象
			if (rs.next()) {//至少有一条数据记录
				//将光标移到第一行数据之前
				rs.beforeFirst();
				while (rs.next()) {
					System.out.println(rs.getString("stu_id")+"  "
							+rs.getString("stu_name")+" "
							+rs.getString("stu_password")+"  "
							+rs.getString("stu_age")+" "
							+rs.getString("stu_sex")+" "
							+rs.getString("stu_address"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 *<p>Title: getClose</p> 
	 *<p>功能描述: 释放资源</p>
	 */ 
	public void getClose() {
		 try {
			if (rs!=null) {
				rs.close();
			}
			if (stmt!=null) {
				stmt.close();
			}
			if (conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
 
	
}

 