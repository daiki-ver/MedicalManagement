package pro.com.test;

import java.sql.SQLException;
import java.util.List;

import pro.com.bean.userBean;
import pro.com.dao.UserDao;

public class test1 {
	private static UserDao dao = new UserDao();
	public static void testInsert() throws SQLException {
		userBean user = new userBean();
		user.setEmail("11111@qq.com");
		user.setPassword("31fdas45613");
		user.setName("ceshi");
		user.setSex("男");
		user.setUsername("kugui");
		user.setJob("医生");
		user.setPhone("1234564963");
		user.setAddress("dsjaiofjl");
		user.setDescribe("uaoigoajvoa");
		user.setRole("admin");
		boolean b = dao.insert(user);
		System.out.println(b);
	}
	
	public static void testDelete() throws SQLException {
		String email="11111@qq.com";
		boolean b=dao.delete(email);
		System.out.println(b);
	}
	
	public static void testUpdate() throws SQLException {
		userBean user = new userBean();
		user.setPassword("31fdas45613");
		user.setName("ceshi");
		user.setSex("男");
		user.setUsername("kugui");
		user.setJob("医生");
		user.setPhone("1234564963");
		user.setAddress("dsjaiofjl");
		user.setDescribe("uaoigoajvoa");
		user.setRole("admin");
		user.setEmail("7894546@qq.com");
		boolean b=dao.update(user);
		System.out.println(b);
	}
	
	public static void testFindAll() throws SQLException {
		List list = dao.findAll();
		System.out.println(list.size());
	}
	public static void testFind() throws SQLException {
		String email="admin@qq.com";
		userBean user = dao.find(email);
		System.out.println(user.getName()+"  |  "+user.getEmail()+"  |  "+user.getPassword());
	}
	public static void main(String[] args) throws SQLException{
		testFind();
	}
	
	
}
	