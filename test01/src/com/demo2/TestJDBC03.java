package com.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.ResultSetMetaData;

public class TestJDBC03 {

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
		String sql = "select * from student";
		// 4、获取执行对象
		Statement stmt = conn.createStatement();
		// 5、执行sql语句，并处理执行状态结果
		ResultSet rs = stmt.executeQuery(sql);
		
		
		/*
		 * 
		 * 获取表字段值
		 * String java.sql.ResultSet.getString(int columnIndex)
		 * 功能：获取指定列的字段值
		 * columnIndex表示阻断明的下标，下标从1开始
		 *  stu_id | stu_name | stu_password | stu_age | stu_sex | stu_address |
		 *  1            2           3             4        5            6
		 *  rs.getString（2）那么表示指向的就是stu_name 
		 *  
		 * String java.sql.ResultSet.getString(String arg0) 
		 *  功能：获取指定字段名所在列的字段值
		 *  
		 *  获取某列字段值的类型
		 *  结果集对象.getXXX("字段名"/字段下标)
		 *  如：int rs.getInt("字段名"/字段下标)
	
		 *  	String st1=	rs.getString(2);
             	System.out.println(st1);	
	            String st2=rs.getString("stu_name");
		
		 *  
		 *    
		 */
		 
		rs.next(); 
		
		
		/*获取结构信息：
		 * ResultSetMetaData getMetaData()
		 * 功能：获取次resultset对象的列的编号、类型和属性
		 * 	 *  
		 *  int getColumnCount()
		 *  功能：返回次ResultSe对象中的列数
		 *  int count=metaData.getColumnCount();
		   System.out.println("总列数"+count);
		
		 *  String getColumnName(int column)
		 *  功能：获取指定列的名称
		 * String columnName=metaData.getColumnName(3);
		   System.out.println("列名称"+columnName);
		 * 
		 * 
		 * 
		 * 遍历列名称
		 *   for(int i=0;i<metaData.getColumnCount();i++) {
        	String columnName=metaData.getColumnName(i+1);
 		   System.out.println("列名称"+columnName);
                      }
                      
		 */
        java.sql.ResultSetMetaData metaData=rs.getMetaData();
        
        for(int i=0;i<metaData.getColumnCount();i++) {
        	String columnName=metaData.getColumnName(i+1);
 		   System.out.print(columnName+" ");
                      }
        System.out.println();
          while(rs.next()) {
        	  for(int i=0;i<metaData.getColumnCount();i++) {
              	String columnName=metaData.getColumnName(i+1);
       		   System.out.print(rs.getString(columnName)+"\t");
                            }  
        	 System.out.println();
          }
		
		
		// 6、释放资源
		rs.close();
		stmt.close();
		conn.close();
	}
}
