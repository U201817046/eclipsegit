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
 * @date 2020��6��18�� 
 * @version 1.0 
 * <p>��������:�������ݿ�Ĺ�����</p>  
 */
public class DBUtils {
	// ���ӵ�ַ
	private String url = "jdbc:mysql://localhost:3306/test01?useUnicode=true&characterEncoding=utf8";
	// �û���
	private String user = "root";
	// �û����� ������ݿ�����
	private String password = "lwd123456";
	//���ݿ����Ӷ���
	private  Connection conn = null;
	
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	/**
		1����������
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
	  *<p>��������:��ȡ�������ݿ�ĻỰ����</p>
	 * @throws SQLException 
	  */
	private void getConnect() {
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("�������ݿ�ɹ�����");
		} catch (SQLException e) {
			System.out.println("�������ݿ�ʧ�ܣ�����");
			e.printStackTrace();
		}

	}
	
	/**
	 *<p>Title: doUpdate</p> 
	 *<p>��������:ִֻ��ִ����ɾ�ĵ�sql </p>
	 *@return int i ��ʾִ��sql��Ӱ������
	 *@param String Sqls ��ʾҪִ�е���ɾ�ĵ�sql���
	 */
	public int doUpdate(String Sqls) {
		//�������Ӷ���ĺ���
		getConnect();
		int i=0;
		try {
			//��ȡִ�ж���
			stmt = conn.prepareStatement(Sqls);
			
			//ִ��sql��䣬������ִ��״̬���
			i = stmt.executeUpdate();
			System.out.println("ִ��״̬��"+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	/**
	 *<p>Title: doQuery</p> 
	 *<p>��������: ִֻ�в�ѯ��sql���</p> 
	 * @param String Sqls ��ʾ��ѯ��sql���
	 * @return ����һ��ResultSet���������
	 */
	public ResultSet doQuery(String Sqls) {

		// �������Ӷ���ĺ���
		getConnect();
		try {
			// ��ȡִ�ж���
			stmt = conn.prepareStatement(Sqls);

			// ִ��sql��䣬������ִ��״̬���
			rs = stmt.executeQuery();
			
			//������������
			if (rs.next()) {//������һ�����ݼ�¼
				//������Ƶ���һ������֮ǰ
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
	 *<p>��������: �ͷ���Դ</p>
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

 