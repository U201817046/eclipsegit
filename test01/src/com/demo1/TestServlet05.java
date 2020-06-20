package com.demo1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * <p>Title: TestServlet5.java</p> 
 * @author smallFish 
 * @date 2020年6月17日 
 * @version 1.0 
 * <p>功能描述: 跳转动作</p>  
 */
public class TestServlet05 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println("-----TestServlet5--------doGet---------");
		 /*
		  * 转发：
		  * 	特点：内部跳转，只会发出一次请求
		  * 	格式：请求对象.getRequestDispatcher("要跳转的url").forward(请求对象, 响应对象);
		  * 	注意：转发属于内部跳转，所以浏览器地址不会发生改变
		  * 
		  *   * 	请求时地址：http://localhost:8080/hk-JavaEE-01/t5
		  * 	响应之后的地址栏：http://localhost:8080/hk-JavaEE-01/t5
		  * 
		  * req.getRequestDispatcher("testPage.html").forward(req, resp);
		  * 
		  * 转发不可以跳转外部网址
		  * 	req.getRequestDispatcher("http://www.baidu.com").forward(req, resp);
		  */
		 //req.getRequestDispatcher("http://www.baidu.com").forward(req, resp);
		 //可以跳转虚拟路径
		 req.getRequestDispatcher("t3").forward(req, resp);
		 /*
		  * 重定向
		  *   	特点：客户端跳转，至少发出两次请求
		  * 	格式： 响应对象.sendRedirect("跳转的url");
		  * 	注意：转发属于客户端跳转，所以浏览器地址会发生改变
		  * 
		  * 	请求时地址：http://localhost:8080/hk-JavaEE-01/t5
		  * 	响应之后的地址栏：http://localhost:8080/hk-JavaEE-01/testPage.html
		 		resp.sendRedirect("testPage.html");
		 		
		 		 * 重定向可以跳转外部网址
		 		 * resp.sendRedirect("http://www.baidu.com");
		  */
		 //可以跳转虚拟路径
//		 resp.sendRedirect("t3");
		 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println("-----TestServlet5--------doPost---------"); 
		  
	}
}

 