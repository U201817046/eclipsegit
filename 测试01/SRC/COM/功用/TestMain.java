package com.utils;
/** 
 * <p>Title: TestMain.java</p> 
 * @author smallFish 
 * @date 2020年6月18日 
 * @version 1.0 
 * <p>功能描述: </p>  
 */haixng
public class TestMain {
	public static void main(String[] args) {
			//String sqls = "insert into student values(1006,'lisi2','abc',20,'男','红伞去')";
			/*String sqls = "delete from student where stu_id=1008";
				
			DBUtils db = new DBUtils();
			db.doUpdate(sqls);
			db.getClose();*/
		String sqls = "select * from student";
		DBUtils db = new DBUtils();
		db.doQuery(sqls);
	}
}

 
