package com.demo1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
* @ClassName: TestServlet04
* @Description: TODO(������һ�仰��������������)
* @author liuweiduo
* @date 2020��6��18��
*1.String javax.servle.ServletRequest.getParameter(String arg0)
*��ȡurl���ݵĵ�������ֵ
*����ֵ����String
*2.String[] javax.servlet.ServletRequest.getParameterValues(String name)
*��ȡurl���ݵĶ������ֵ
*����String���͵�����
*/
public class TestServlet04 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println("---TestServlet04--doget----");
	//   ������<input type="text" name="user"><br>
	//   ���룺<input type="test" name="pwd"><br>
	String name=    req.getParameter("userName");
	String pass=   req.getParameter("userPassWord");
	/*
	 * ��ȡ��ѡ�����ֵ
	 * ��õ�ѡ���ֵ��Ҫ����ǩ����һ��valueֵ
	 * ��<input type="radio" name="sex" value="����ֵ">��
	 */
    String sex=req.getParameter("sex");
    /*
     * ��ȡ��ѡ���ֵ
     * ��ø�ѡ���ֵ��Ҫ����ǩ����һ��valueֵ
     * ��<input type="checkbox" name="habbies"  value="lol">LOL
         <input type="checkbox" name="habbies" value="dnf">DNF
     * 
     */
    String[]hobbys=req.getParameterValues("hobbies");
    String hobby="";
     for(int i=0;i<hobbys.length;i++) {
    	hobby+=hobbys[i]+",";
     }
	
	/*
	 * ����ѡ��ֵ����nameֵ����������ȥ<option>��ǩ�Ե�ֵ�������趨valueֵ
	 * 
	 *<select name="address">
      <option>����</option>
      <option>�Ϻ�</option>
      <option value="1001">����</option>
      </select>
	 */
      String add=req.getParameter("address");
      
      System.out.println("������"+name+"���룺"+pass+"�Ա�"+sex+"���ã�"+hobby+"��ַ��"+add);

	
	
	
	
	
	
	
	
	
	}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println("---TestServlet04--dopost----");
	//   ������<input type="text" name="user"><br>
	//   ���룺<input type="test" name="pwd"><br>
	String name=    req.getParameter("user");
	String id=    req.getParameter("userID");
	String pass=   req.getParameter("pwd");
	System.out.println(id+""+name+" "+pass);
		}

}
