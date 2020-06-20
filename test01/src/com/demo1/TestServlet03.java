package com.demo1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @ClassName: TestServlet03
* @Description: TODO(这里用一句话描述这个类的作用)
* @author liuweiduo
* @date 2020年6月18日
* 1.get:当form表单的method=get时不可以在action值中携带参数，
* 否则数据会丢失
* 场景1：可以拿到值
* <form action="t3" method="get">
    学号：<input type="text" name="userID"><br>
    姓名：<input type="text" name="user"><br>
    密码：<input type="test" name="pwd"><br>
    <input type="submit" value="test03"><br>
   </form>
   提交时请求地址参数：
   场景2：拿不到值
    <form action="t3?userID=1002" method="get">
<!--     学号：<input type="text" name="userID"><br> -->
    姓名：<input type="text" name="user"><br>
    密码：<input type="test" name="pwd"><br>
    <input type="submit" value="test03"><br>
   </form>
  2.超链接拼接值可以获取参数
  前台界面： <a href="t3?userID=1001&user=tom&pwd=abc">test03-get03</a>
 3.post
 注意在使用post提交请求格式时，post提交的数据格式为FormData
 但是一旦拼接了数据，那么拼接的数据为QueryStringParameters
 如<form action="t3?userID=1002" method="post">
<!--     学号：<input type="text" name="userID"><br> -->
    姓名：<input type="text" name="user"><br>
    密码：<input type="test" name="pwd"><br>
    <input type="submit" value="test03-post02"><br>
   </form>
 
 最终userID=1002数据格式为QueryStringParameters
 user和pwd为FormData
 
 
 
 请求的url参数格式
 http协议：//域名？参数1=参数值1&参数2=参数值2
 
*
*
*/
public class TestServlet03 extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 System.out.println("---TestServlet03--doget----");
//   姓名：<input type="text" name="user"><br>
//   密码：<input type="test" name="pwd"><br>
String name=    req.getParameter("user");
String id=    req.getParameter("userID");
String pass=   req.getParameter("pwd");
System.out.println(id+""+name+" "+pass);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 System.out.println("---TestServlet03--dopost----");
//   姓名：<input type="text" name="user"><br>
//   密码：<input type="test" name="pwd"><br>
String name=    req.getParameter("user");
String id=    req.getParameter("userID");
String pass=   req.getParameter("pwd");
System.out.println(id+""+name+" "+pass);
	}
}
