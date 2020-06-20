package com.demo1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
* @ClassName: TestServlet04
* @Description: TODO(这里用一句话描述这个类的作用)
* @author liuweiduo
* @date 2020年6月18日
*1.String javax.servle.ServletRequest.getParameter(String arg0)
*获取url传递的单个参数值
*返回值类型String
*2.String[] javax.servlet.ServletRequest.getParameterValues(String name)
*获取url传递的多个参数值
*返回String类型的数组
*/
public class TestServlet04 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println("---TestServlet04--doget----");
	//   姓名：<input type="text" name="user"><br>
	//   密码：<input type="test" name="pwd"><br>
	String name=    req.getParameter("userName");
	String pass=   req.getParameter("userPassWord");
	/*
	 * 获取单选框的数值
	 * 获得单选框的值，要给标签设置一个value值
	 * 如<input type="radio" name="sex" value="参数值">男
	 */
    String sex=req.getParameter("sex");
    /*
     * 获取复选框的值
     * 获得复选框的值，要给标签设置一个value值
     * 如<input type="checkbox" name="habbies"  value="lol">LOL
         <input type="checkbox" name="habbies" value="dnf">DNF
     * 
     */
    String[]hobbys=req.getParameterValues("hobbies");
    String hobby="";
     for(int i=0;i<hobbys.length;i++) {
    	hobby+=hobbys[i]+",";
     }
	
	/*
	 * 下拉选的值设置name值，如果不想过去<option>标签对的值，可以设定value值
	 * 
	 *<select name="address">
      <option>北京</option>
      <option>上海</option>
      <option value="1001">深圳</option>
      </select>
	 */
      String add=req.getParameter("address");
      
      System.out.println("姓名："+name+"密码："+pass+"性别："+sex+"爱好："+hobby+"地址："+add);

	
	
	
	
	
	
	
	
	
	}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println("---TestServlet04--dopost----");
	//   姓名：<input type="text" name="user"><br>
	//   密码：<input type="test" name="pwd"><br>
	String name=    req.getParameter("user");
	String id=    req.getParameter("userID");
	String pass=   req.getParameter("pwd");
	System.out.println(id+""+name+" "+pass);
		}

}
