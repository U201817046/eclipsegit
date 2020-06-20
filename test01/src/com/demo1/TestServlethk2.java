package com.demo1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utils.DBUtils;

/**
 * Servlet implementation class TestServlethk2
 */
public class TestServlethk2 extends HttpServlet {
		
		protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {


			String name=    req.getParameter("userName");
		    String id=    req.getParameter("userID");
		    String pwd=   req.getParameter("userPassWord");
		    String age = req.getParameter("userAge");
		    String sex = req.getParameter("userSex");
		    String address = req.getParameter("userAddress");
			String  sqls="update student set stu_name='"+name+
					"',stu_password='"+pwd+
					"',stu_age='"+age+
					"',stu_sex='"+sex+
					"',stu_address='"+address+
					"'where stu_id="+id;
			DBUtils db = new DBUtils();
			db.doUpdate(sqls);
			db.getClose();
		}

		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		}


}
