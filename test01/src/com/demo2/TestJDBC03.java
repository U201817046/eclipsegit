package com.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.ResultSetMetaData;

public class TestJDBC03 {

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
		String sql = "select * from student";
		// 4����ȡִ�ж���
		Statement stmt = conn.createStatement();
		// 5��ִ��sql��䣬������ִ��״̬���
		ResultSet rs = stmt.executeQuery(sql);
		
		
		/*
		 * 
		 * ��ȡ���ֶ�ֵ
		 * String java.sql.ResultSet.getString(int columnIndex)
		 * ���ܣ���ȡָ���е��ֶ�ֵ
		 * columnIndex��ʾ��������±꣬�±��1��ʼ
		 *  stu_id | stu_name | stu_password | stu_age | stu_sex | stu_address |
		 *  1            2           3             4        5            6
		 *  rs.getString��2����ô��ʾָ��ľ���stu_name 
		 *  
		 * String java.sql.ResultSet.getString(String arg0) 
		 *  ���ܣ���ȡָ���ֶ��������е��ֶ�ֵ
		 *  
		 *  ��ȡĳ���ֶ�ֵ������
		 *  ���������.getXXX("�ֶ���"/�ֶ��±�)
		 *  �磺int rs.getInt("�ֶ���"/�ֶ��±�)
	
		 *  	String st1=	rs.getString(2);
             	System.out.println(st1);	
	            String st2=rs.getString("stu_name");
		
		 *  
		 *    
		 */
		 
		rs.next(); 
		
		
		/*��ȡ�ṹ��Ϣ��
		 * ResultSetMetaData getMetaData()
		 * ���ܣ���ȡ��resultset������еı�š����ͺ�����
		 * 	 *  
		 *  int getColumnCount()
		 *  ���ܣ����ش�ResultSe�����е�����
		 *  int count=metaData.getColumnCount();
		   System.out.println("������"+count);
		
		 *  String getColumnName(int column)
		 *  ���ܣ���ȡָ���е�����
		 * String columnName=metaData.getColumnName(3);
		   System.out.println("������"+columnName);
		 * 
		 * 
		 * 
		 * ����������
		 *   for(int i=0;i<metaData.getColumnCount();i++) {
        	String columnName=metaData.getColumnName(i+1);
 		   System.out.println("������"+columnName);
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
		
		
		// 6���ͷ���Դ
		rs.close();
		stmt.close();
		conn.close();
	}
}
