package com.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;

import com.endity.Student;




/**
* @ClassName: TestJDBC01
* @Description: TODO(������һ�仰��������������)
* @author liuweiduo
* @date 2020��6��17��
*
*/
public class TestJDBC01 {
 public static void addStudent(Student student) throws ClassNotFoundException, SQLException{
	 /*
	  *1.��������
	  *������������������WebAppLIBRARIES
	  */
	 Class.forName("com.mysql.jdbc.Driver");
	  /*2.��ȡ�������ݿ�ĻỰ����
	   * ���ӵ�ַ
	   * �û���
	   * ����
	   */
	 String url="jdbc:mysql://localhost:3306/test01?useUnicode=true&characterEncoding=utf8";
	 String user="root";
	 String password="lwd123456"; 
      Connection conn= DriverManager.getConnection(url,user,password);
	 /*3.��ȡ���ݿ�ĻỰ�����ȡִ�ж���
	  *4.����Ҫִ�е�sql���
	  */
      String  sql="insert into student values("+student.getStuID()+",'"+student.getStuName()+"','"+student.getStuPassWord()+"','"+student.getStuAge()+"','"+student.getStuSex()+"','"+student.getStuAddress()+"')";
      //ͨ�����ݿ�ִ�ж���ִ��sql��䣬������ִ��sql��� 
      Statement stmt=conn.createStatement();
      stmt.executeUpdate(sql);
      //�ͷ���Դ
      stmt.close();
      conn.close();
	  /*5.ʹ�����ݿ����ִ��sql��䣬������ִ��sql��״̬���
	  *6.�ͷ���Դ
	  */ 
 }
 
 public static void delStudent(String stu) throws ClassNotFoundException, SQLException{
	 /*
	  *1.��������
	  *������������������WebAppLIBRARIES
	  */
	 Class.forName("com.mysql.jdbc.Driver");
	  /*2.��ȡ�������ݿ�ĻỰ����
	   * ���ӵ�ַ
	   * �û���
	   * ����
	   */
	 String url="jdbc:mysql://localhost:3306/test01?useUnicode=true&characterEncoding=utf8";
	 String user="root";
	 String password="lwd123456"; 
      Connection conn= DriverManager.getConnection(url,user,password);
	 /*3.��ȡ���ݿ�ĻỰ�����ȡִ�ж���
	  *4.����Ҫִ�е�sql���
	  */
      String  sql="delete from student where stu_id="+stu;
      //ͨ�����ݿ�ִ�ж���ִ��sql��䣬������ִ��sql��� 
      Statement stmt=conn.createStatement();
      stmt.executeUpdate(sql);
      //�ͷ���Դ
      stmt.close();
      conn.close();
	  /*5.ʹ�����ݿ����ִ��sql��䣬������ִ��sql��״̬���
	  *6.�ͷ���Դ
	  */
	 
	 
 }
 
 public static void updateStudent() throws ClassNotFoundException, SQLException{
	 /*
	  *1.��������
	  *������������������WebAppLIBRARIES
	  */
	 Class.forName("com.mysql.jdbc.Driver");
	  /*2.��ȡ�������ݿ�ĻỰ����
	   * ���ӵ�ַ
	   * �û���
	   * ����
	   */
	 String url="jdbc:mysql://localhost:3306/test01?useUnicode=true&characterEncoding=utf8";
	 String user="root";
	 String password="lwd123456"; 
      Connection conn= DriverManager.getConnection(url,user,password);
	 /*3.��ȡ���ݿ�ĻỰ�����ȡִ�ж���
	  *4.����Ҫִ�е�sql���
	  */
      String  sql="update student set stu_name='������'where stu_id=1001";
      //ͨ�����ݿ�ִ�ж���ִ��sql��䣬������ִ��sql��� 
      Statement stmt=conn.createStatement();
      stmt.executeUpdate(sql);
      //�ͷ���Դ
      stmt.close();
      conn.close();
	  /*5.ʹ�����ݿ����ִ��sql��䣬������ִ��sql��״̬���
	  *6.�ͷ���Դ
	  */	 
 }
 
 public static void selectFindALLStudent() throws ClassNotFoundException, SQLException{
	 /*
	  *1.��������
	  *������������������WebAppLIBRARIES
	  */
	 Class.forName("com.mysql.jdbc.Driver");
	  /*2.��ȡ�������ݿ�ĻỰ����
	   * ���ӵ�ַ
	   * �û���
	   * ����
	   */
	 String url="jdbc:mysql://localhost:3306/test01?useUnicode=true&characterEncoding=utf8";
	 String user="root";
	 String password="lwd123456"; 
      Connection conn= DriverManager.getConnection(url,user,password);
	 /*3.��ȡ���ݿ�ĻỰ�����ȡִ�ж���
	  *4.����Ҫִ�е�sql���
	  */
      String  sql="select * from student  ";
      //ͨ�����ݿ�ִ�ж���ִ��sql��䣬������ִ��sql��� 
      Statement stmt=conn.createStatement();
     
      
      /*
       * ������������
       * ResultSet java.sql.Statement.executeQuery(String sql) throws SQLException
       * ���ܣ�ִ�в�ѯ��sql��䣬������һ�����������
       * ����ֵ������һ�����в�ѯ�����ResultSet����
       * boolean java.sql.ResultSet.next()
       * �����ǰ����Ч����true�������Ч����false
       * 
       * boolean last()
       * ������ƶ������һ��
       *
       * boolean first()
       * ������ƶ�����һ��
       * 
       * boolean beforeFirst()
       * ������ƶ�����ͷ
       * 
       * int getRow()
       * ��ȡ��ǰ�����е��к�
       * 
       * String getString�������ƣ���ȡָ�����ֶ�ֵ
       */
      ResultSet rs=stmt.executeQuery(sql);
//      
//      rs.next();
//      int row=rs.getRow();
//     
//      String id=   rs.getString("stu_id");
//      System.out.println(id );
      
      //�������е�����
     while(rs.next()) {
    	 
    	System.out.println("id:"+rs.getString("stu_id")+"name:"+rs.getString("stu_name")+"pwd:"+rs.getString("stu_password"));
     }
      
      //�ͷ���Դ
      stmt.close();
      conn.close();
	  /*5.ʹ�����ݿ����ִ��sql��䣬������ִ��sql��״̬���
	  *6.�ͷ���Դ
	  */	 
 }
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
	selectFindALLStudent();
	  
}
 
}
