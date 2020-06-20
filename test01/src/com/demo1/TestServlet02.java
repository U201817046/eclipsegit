package com.demo1;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
/**
* @ClassName: TestServlet02
* @Description: TODO(这里用一句话描述这个类的作用)
* 请求servlet的方式
* 常用方式：
* TRACE、DELETE、PUT、 GET、 POST
* get：
* 1.浏览器地址栏直接输入请求地址
* 2.超链接
* <a href="t2">testGET</a>
* 3.form的method="get"
* <form action="t2"method="get" >
     <input type="submit" value="testGET"><br>
   </form>
   post：
   <form action="t2" method="post">
     <input type="submit" value="testGET"><br>
   </form>
* @author liuweiduo
* @date 2020年6月17日
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
