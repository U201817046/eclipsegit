package com.demo1;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo2.TestJDBC01;
import com.endity.Student;

/**
* @ClassName: TestServlet01
* @Description: TODO(这里用一句话描述这个类的作用)
* @author liuweiduo
* @date 2020年6月17日
* 继承javax.servlet.http.HttpServlet;
* 2.重写doGet和doPost函数
**/

public class TestServlet01 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         System.out.println("---TestServlet--doget----");
//         姓名：<input type="text" name="user"><br>
//         密码：<input type="test" name="pwd"><br>
     String name=    req.getParameter("user");
     String id=    req.getParameter("userID");
     String pass=   req.getParameter("pwd");
     System.out.println(name+" "+pass);
     //将前台发送的数据封存到实体类中
     Student stu=new Student();
     stu.setStuID(id!=null?Integer.parseInt(id):0);
     stu.setStuName(name);
     stu.setStuPassWord(pass);
     stu.setStuAge("20");
     stu.setStuSex("女");
     stu.setStuAddress("北京"); 
       //调用jdbc服务
     try {
		TestJDBC01.addStudent(stu);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
     
	}
	@Override
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---TestServlet--dopost---");
	}

}
  