package com.demo1;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
/**
* @ClassName: TestServlet02
* @Description: TODO(������һ�仰��������������)
* ����servlet�ķ�ʽ
* ���÷�ʽ��
* TRACE��DELETE��PUT�� GET�� POST
* get��
* 1.�������ַ��ֱ�����������ַ
* 2.������
* <a href="t2">testGET</a>
* 3.form��method="get"
* <form action="t2"method="get" >
     <input type="submit" value="testGET"><br>
   </form>
   post��
   <form action="t2" method="post">
     <input type="submit" value="testGET"><br>
   </form>
* @author liuweiduo
* @date 2020��6��17��
*
*/
public class TestServlet02 extends HttpServlet{
@Override 
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
System.out.println("---testservlet02---doget-----");
	 
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("---testservlet02---dopost-----");

	}
}
