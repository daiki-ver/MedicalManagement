package pro.com.test;

import java.sql.SQLException;

import pro.com.dao.PageUserAdminDao;

public class test_lineSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=0;
		try {
			a=PageUserAdminDao.totleCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(a);
	}

}
