package com.utils;
/** 
 * <p>Title: TestMain.java</p> 
 * @author smallFish 
 * @date 2020��6��18�� 
 * @version 1.0 
 * <p>��������: </p>  
 */
public class TestMain {
	public static void main(String[] args) {
			//String sqls = "insert into student values(1006,'lisi2','abc',20,'��','��ɡȥ')";
			/*String sqls = "delete from student where stu_id=1008";
				
			DBUtils db = new DBUtils();
			db.doUpdate(sqls);
			db.getClose();*/
		String sqls = "select * from student";
		DBUtils db = new DBUtils();
		db.doQuery(sqls);
	}
}

 