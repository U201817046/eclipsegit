package com.demo1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utils.DBUtils;

/**
 * Servlet implementation class TestServlethk1
 */
public class TestServlethk1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("userID");
		String sqls = "delete from student where stu_id="+id;
		
		DBUtils db = new DBUtils();
		db.doUpdate(sqls);
		db.getClose();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
