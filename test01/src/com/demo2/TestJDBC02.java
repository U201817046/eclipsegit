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
 * @date 2020��6��18�� 
 * @version 1.0 
 * <p>��������:ִ�ж��� </p> 
 * ����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣
 * ���������� SQL ���ͨ��ʹ�� Statement ����ִ�С� 
 * ������ִ����ͬ�� SQL ��䣬ʹ�� PreparedStatement ������ܸ���Ч�� 
 * 
 * jdbc������ִ�ж���
 * 	1��Statement
 * 			Statement stmt = conn.createStatement();
 * 		 1.1ִ��sql��亯��
 * 			stmt.executeQuery/Upadte(sql)
 *  2��PreparedStatement
 * 		PreparedStatement pstmt = conn.prepareStatement(sql);
 * 		2.1ִ��sql��亯��
 * 			pstmt.executeQuery/Upadte()
 *����
 *	����1��
 *	 Statement�������ִ�о�̬��sql���
 *	 PreparedStatement ����ִ�д���ռλ����sql���;�̬��sql���
 *
 *	����2��
 *		Statement������sqlע��ķ���
 *		PreparedStatement������Ч�Ĺ��sqlע��
 *
 *��̬��sql��䣺
 *	delete from student where stu_id=1001;
 *  select * from student
 *	....
 *
 *����ռλ����SQL��䣺
 *	delete from student where stu_id=?;
 *  insert into student values(?,?,?,?)
 */
public class TestJDBC02 {
	public static void main1(String[] args)throws Exception {
		//1����������
		Class.forName("com.mysql.jdbc.Driver");
		//2����ȡ�������ݿ�ĻỰ����
		//���ӵ�ַ
		String url = "jdbc:mysql://localhost:3306/test01";
		// �û���
		String user = "root";
		// �û����� ������ݿ�����
		String password = "lwd123456";

		Connection conn = DriverManager.getConnection(url, user, password);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ҫ��ѯ��ID��");
		String id = sc.nextLine();
		
		// 3������sql���
		String sql = "select * from student where stu_id="+id;
		// 4����ȡִ�ж���
		Statement stmt = conn.createStatement();
		// 5��ִ��sql��䣬������ִ��״̬���
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString("stu_id")+"  "
					+rs.getString("stu_name")+" "
					+rs.getString("stu_password")+"  "
					+rs.getString("stu_age")+" "
					+rs.getString("stu_sex")+" "
					+rs.getString("stu_address"));
		}
		// 6���ͷ���Դ
		rs.close();
		stmt.close();
		conn.close();
	}
	
	public static void main2(String[] args)throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		//2����ȡ�������ݿ�ĻỰ����
		//���ӵ�ַ
		String url = "jdbc:mysql://localhost:3306/test01";
		// �û���
		String user = "root";
		// �û����� ������ݿ�����
		String password = "lwd123456";


		Connection conn = DriverManager.getConnection(url, user, password);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ҫ��ѯ��ID��");
		String id = sc.nextLine();
		
		// 3������sql���
		String sql = "select * from student where stu_id=?";
		// 4����ȡִ�ж���
		 PreparedStatement stmt = conn.prepareStatement(sql);
		 
		 /*
		  * ��ռλ����ֵ
		  * void setObject(int parameterIndex, Object x)
		  * ���ܣ���ռλ����ֵ
		  * parameterIndex ��ʾռλ����������λ��
		  * x ��ռλ������Ĳ���ֵ
		  */
		 stmt.setObject(1, id);
		 
		 
		 System.out.println(stmt.toString());
		// 5��ִ��sql��䣬������ִ��״̬���
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("stu_id")+"  "
					+rs.getString("stu_name")+" "
					+rs.getString("stu_password")+"  "
					+rs.getString("stu_age")+" "
					+rs.getString("stu_sex")+" "
					+rs.getString("stu_address"));
		}
		// 6���ͷ���Դ
		rs.close();
		stmt.close();
		conn.close();
	}
	
	public static void main(String[] args)throws Exception {
		//1����������
		Class.forName("com.mysql.jdbc.Driver");
		//2����ȡ�������ݿ�ĻỰ����
		//���ӵ�ַ
		String url = "jdbc:mysql://localhost:3306/test01";
		// �û���
		String user = "root";
		// �û����� ������ݿ�����
		String password = "lwd123456";


		Connection conn = DriverManager.getConnection(url, user, password);
		
		// 3������sql���
		String sql = "update student set stu_name=?,stu_sex=?,stu_age=? where stu_id=?";
		// 4����ȡִ�ж���
		 PreparedStatement stmt = conn.prepareStatement(sql);
		 
		 /*
		  * ��ռλ����ֵ
		  * void setObject(int parameterIndex, Object x)
		  * ���ܣ���ռλ����ֵ
		  * parameterIndex ��ʾռλ����������λ��
		  * x ��ռλ������Ĳ���ֵ
		  * 
		  * stu_name=? 1   
		  * stu_sex=?  2
		  * stu_age=?  3
		  * tu_id=?    4
		  */
		 stmt.setObject(1, "ŷ����");
		 stmt.setObject(2, "Ů");
		 stmt.setObject(3, "43");
		 stmt.setObject(4, 1007);
		 
		 System.out.println(stmt.toString());
		// 5��ִ��sql��䣬������ִ��״̬���
		 stmt.executeUpdate();
		 
		// 6���ͷ���Դ
		stmt.close();
		conn.close();
	}
}

 