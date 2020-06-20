package com.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;

import com.endity.Student;




/**
* @ClassName: TestJDBC01
* @Description: TODO(这里用一句话描述这个类的作用)
* @author liuweiduo
* @date 2020年6月17日
*
*/
public class TestJDBC01 {
 public static void addStudent(Student student) throws ClassNotFoundException, SQLException{
	 /*
	  *1.加载驱动
	  *加载驱动的驱动类在WebAppLIBRARIES
	  */
	 Class.forName("com.mysql.jdbc.Driver");
	  /*2.获取链接数据库的会话对象
	   * 链接地址
	   * 用户名
	   * 密码
	   */
	 String url="jdbc:mysql://localhost:3306/test01?useUnicode=true&characterEncoding=utf8";
	 String user="root";
	 String password="lwd123456"; 
      Connection conn= DriverManager.getConnection(url,user,password);
	 /*3.获取数据库的会话对象获取执行对象
	  *4.构造要执行的sql语句
	  */
      String  sql="insert into student values("+student.getStuID()+",'"+student.getStuName()+"','"+student.getStuPassWord()+"','"+student.getStuAge()+"','"+student.getStuSex()+"','"+student.getStuAddress()+"')";
      //通过数据库执行对象执行sql语句，并处理执行sql结果 
      Statement stmt=conn.createStatement();
      stmt.executeUpdate(sql);
      //释放资源
      stmt.close();
      conn.close();
	  /*5.使用数据库对象执行sql语句，并处理执行sql的状态结果
	  *6.释放资源
	  */ 
 }
 
 public static void delStudent(String stu) throws ClassNotFoundException, SQLException{
	 /*
	  *1.加载驱动
	  *加载驱动的驱动类在WebAppLIBRARIES
	  */
	 Class.forName("com.mysql.jdbc.Driver");
	  /*2.获取链接数据库的会话对象
	   * 链接地址
	   * 用户名
	   * 密码
	   */
	 String url="jdbc:mysql://localhost:3306/test01?useUnicode=true&characterEncoding=utf8";
	 String user="root";
	 String password="lwd123456"; 
      Connection conn= DriverManager.getConnection(url,user,password);
	 /*3.获取数据库的会话对象获取执行对象
	  *4.构造要执行的sql语句
	  */
      String  sql="delete from student where stu_id="+stu;
      //通过数据库执行对象执行sql语句，并处理执行sql结果 
      Statement stmt=conn.createStatement();
      stmt.executeUpdate(sql);
      //释放资源
      stmt.close();
      conn.close();
	  /*5.使用数据库对象执行sql语句，并处理执行sql的状态结果
	  *6.释放资源
	  */
	 
	 
 }
 
 public static void updateStudent() throws ClassNotFoundException, SQLException{
	 /*
	  *1.加载驱动
	  *加载驱动的驱动类在WebAppLIBRARIES
	  */
	 Class.forName("com.mysql.jdbc.Driver");
	  /*2.获取链接数据库的会话对象
	   * 链接地址
	   * 用户名
	   * 密码
	   */
	 String url="jdbc:mysql://localhost:3306/test01?useUnicode=true&characterEncoding=utf8";
	 String user="root";
	 String password="lwd123456"; 
      Connection conn= DriverManager.getConnection(url,user,password);
	 /*3.获取数据库的会话对象获取执行对象
	  *4.构造要执行的sql语句
	  */
      String  sql="update student set stu_name='奥特曼'where stu_id=1001";
      //通过数据库执行对象执行sql语句，并处理执行sql结果 
      Statement stmt=conn.createStatement();
      stmt.executeUpdate(sql);
      //释放资源
      stmt.close();
      conn.close();
	  /*5.使用数据库对象执行sql语句，并处理执行sql的状态结果
	  *6.释放资源
	  */	 
 }
 
 public static void selectFindALLStudent() throws ClassNotFoundException, SQLException{
	 /*
	  *1.加载驱动
	  *加载驱动的驱动类在WebAppLIBRARIES
	  */
	 Class.forName("com.mysql.jdbc.Driver");
	  /*2.获取链接数据库的会话对象
	   * 链接地址
	   * 用户名
	   * 密码
	   */
	 String url="jdbc:mysql://localhost:3306/test01?useUnicode=true&characterEncoding=utf8";
	 String user="root";
	 String password="lwd123456"; 
      Connection conn= DriverManager.getConnection(url,user,password);
	 /*3.获取数据库的会话对象获取执行对象
	  *4.构造要执行的sql语句
	  */
      String  sql="select * from student  ";
      //通过数据库执行对象执行sql语句，并处理执行sql结果 
      Statement stmt=conn.createStatement();
     
      
      /*
       * 处理结果集对象
       * ResultSet java.sql.Statement.executeQuery(String sql) throws SQLException
       * 功能：执行查询的sql语句，并返回一个结果集对象
       * 返回值：返回一个存有查询结果的ResultSet对象
       * boolean java.sql.ResultSet.next()
       * 如果当前行有效返回true，如果无效返回false
       * 
       * boolean last()
       * 将光标移动到最后一行
       *
       * boolean first()
       * 将光标移动到第一行
       * 
       * boolean beforeFirst()
       * 将光标移动到表头
       * 
       * int getRow()
       * 获取当前数据行的行号
       * 
       * String getString（列名称）获取指定列字段值
       */
      ResultSet rs=stmt.executeQuery(sql);
//      
//      rs.next();
//      int row=rs.getRow();
//     
//      String id=   rs.getString("stu_id");
//      System.out.println(id );
      
      //遍历表中的数据
     while(rs.next()) {
    	 
    	System.out.println("id:"+rs.getString("stu_id")+"name:"+rs.getString("stu_name")+"pwd:"+rs.getString("stu_password"));
     }
      
      //释放资源
      stmt.close();
      conn.close();
	  /*5.使用数据库对象执行sql语句，并处理执行sql的状态结果
	  *6.释放资源
	  */	 
 }
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
	selectFindALLStudent();
	  
}
 
}
