package com.demo1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * <p>Title: TestServlet5.java</p> 
 * @author smallFish 
 * @date 2020��6��17�� 
 * @version 1.0 
 * <p>��������: ��ת����</p>  
 */
public class TestServlet05 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println("-----TestServlet5--------doGet---------");
		 /*
		  * ת����
		  * 	�ص㣺�ڲ���ת��ֻ�ᷢ��һ������
		  * 	��ʽ���������.getRequestDispatcher("Ҫ��ת��url").forward(�������, ��Ӧ����);
		  * 	ע�⣺ת�������ڲ���ת�������������ַ���ᷢ���ı�
		  * 
		  *   * 	����ʱ��ַ��http://localhost:8080/hk-JavaEE-01/t5
		  * 	��Ӧ֮��ĵ�ַ����http://localhost:8080/hk-JavaEE-01/t5
		  * 
		  * req.getRequestDispatcher("testPage.html").forward(req, resp);
		  * 
		  * ת����������ת�ⲿ��ַ
		  * 	req.getRequestDispatcher("http://www.baidu.com").forward(req, resp);
		  */
		 //req.getRequestDispatcher("http://www.baidu.com").forward(req, resp);
		 //������ת����·��
		 req.getRequestDispatcher("t3").forward(req, resp);
		 /*
		  * �ض���
		  *   	�ص㣺�ͻ�����ת�����ٷ�����������
		  * 	��ʽ�� ��Ӧ����.sendRedirect("��ת��url");
		  * 	ע�⣺ת�����ڿͻ�����ת�������������ַ�ᷢ���ı�
		  * 
		  * 	����ʱ��ַ��http://localhost:8080/hk-JavaEE-01/t5
		  * 	��Ӧ֮��ĵ�ַ����http://localhost:8080/hk-JavaEE-01/testPage.html
		 		resp.sendRedirect("testPage.html");
		 		
		 		 * �ض��������ת�ⲿ��ַ
		 		 * resp.sendRedirect("http://www.baidu.com");
		  */
		 //������ת����·��
//		 resp.sendRedirect("t3");
		 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println("-----TestServlet5--------doPost---------"); 
		  
	}
}

 