package com.utils;
<<<<<<< HEAD
/** 123456
=======
//5555
/** 51561456
>>>>>>> branch 'master' of https://github.com/U201817046/eclipsegit.git
 * <p>Title: TestMain.java</p> 
 * @author smallFish 
 * @date 2020骞�6鏈�18鏃� 
 * @version 1.0 
 * <p>鍔熻兘鎻忚堪: </p>  
 */
public class TestMain {
	public static void main(String[] args) {
			//String sqls = "insert into student values(1006,'lisi2','abc',20,'鐢�','绾紴鍘�')";
			
			/*
			 * String sqls = "delete from student where stu_id=1008";
			 * 
			 * DBUtils db = new DBUtils(); db.doUpdate(sqls); db.getClose();
			 */
			 
		String sqls = "select * from student";
		DBUtils db = new DBUtils();
		db.doQuery(sqls);
	}
}

 
