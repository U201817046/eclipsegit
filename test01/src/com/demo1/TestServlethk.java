package com.demo1;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo2.TestJDBC01;
import com.endity.Student;
import com.utils.DBUtils;

public class TestServlethk extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String name=    req.getParameter("userName");
    String id=    req.getParameter("userID");
    String pwd=   req.getParameter("userPassWord");
    String age = req.getParameter("userAge");
    String sex = req.getParameter("userSex");
    String address = req.getParameter("userAddress");

  
    String  sql="insert into student values("+id+",'"+name+"','"+pwd+"','"+age+"','"+sex+"','"+address+"')";
    DBUtils db = new DBUtils();
	db.doUpdate(sql);
	db.getClose();
 
}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	
	String name=    req.getParameter("userName");
     String id=    req.getParameter("userID");
     String pwd=   req.getParameter("userPassWord");
     String age = req.getParameter("userAge");
     String sex = req.getParameter("userSex");
     String address = req.getParameter("userAddress");
     //鐏忓棗澧犻崣鏉垮絺闁胶娈戦弫鐗堝祦鐏忎礁鐡ㄩ崚鏉跨杽娴ｆ挾琚稉锟�
     Student stu=new Student();
     stu.setStuID(id!=null?Integer.parseInt(id):0);
     stu.setStuName(name);
     stu.setStuPassWord(pwd);
     stu.setStuAge(age);
     stu.setStuSex(sex);
     stu.setStuAddress(address); 
       //鐠嬪啰鏁dbc閺堝秴濮�
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
}
