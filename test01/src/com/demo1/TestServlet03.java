package com.demo1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @ClassName: TestServlet03
* @Description: TODO(������һ�仰��������������)
* @author liuweiduo
* @date 2020��6��18��
* 1.get:��form����method=getʱ��������actionֵ��Я��������
* �������ݻᶪʧ
* ����1�������õ�ֵ
* <form action="t3" method="get">
    ѧ�ţ�<input type="text" name="userID"><br>
    ������<input type="text" name="user"><br>
    ���룺<input type="test" name="pwd"><br>
    <input type="submit" value="test03"><br>
   </form>
   �ύʱ�����ַ������
   ����2���ò���ֵ
    <form action="t3?userID=1002" method="get">
<!--     ѧ�ţ�<input type="text" name="userID"><br> -->
    ������<input type="text" name="user"><br>
    ���룺<input type="test" name="pwd"><br>
    <input type="submit" value="test03"><br>
   </form>
  2.������ƴ��ֵ���Ի�ȡ����
  ǰ̨���棺 <a href="t3?userID=1001&user=tom&pwd=abc">test03-get03</a>
 3.post
 ע����ʹ��post�ύ�����ʽʱ��post�ύ�����ݸ�ʽΪFormData
 ����һ��ƴ�������ݣ���ôƴ�ӵ�����ΪQueryStringParameters
 ��<form action="t3?userID=1002" method="post">
<!--     ѧ�ţ�<input type="text" name="userID"><br> -->
    ������<input type="text" name="user"><br>
    ���룺<input type="test" name="pwd"><br>
    <input type="submit" value="test03-post02"><br>
   </form>
 
 ����userID=1002���ݸ�ʽΪQueryStringParameters
 user��pwdΪFormData
 
 
 
 �����url������ʽ
 httpЭ�飺//����������1=����ֵ1&����2=����ֵ2
 
*
*
*/
public class TestServlet03 extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 System.out.println("---TestServlet03--doget----");
//   ������<input type="text" name="user"><br>
//   ���룺<input type="test" name="pwd"><br>
String name=    req.getParameter("user");
String id=    req.getParameter("userID");
String pass=   req.getParameter("pwd");
System.out.println(id+""+name+" "+pass);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 System.out.println("---TestServlet03--dopost----");
//   ������<input type="text" name="user"><br>
//   ���룺<input type="test" name="pwd"><br>
String name=    req.getParameter("user");
String id=    req.getParameter("userID");
String pass=   req.getParameter("pwd");
System.out.println(id+""+name+" "+pass);
	}
}
