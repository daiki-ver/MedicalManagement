package pro.com.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pro.com.bean.userBean;
import pro.com.dao.UserDao;
import pro.com.utils.JDBCUtils;

public class UserAdminService {
	//Search方法，用于查询搜索框中给出的信息对应用户资料
	public static List<userBean> Search(String email,String name,String username,String job,String sex) throws SQLException{
		List<userBean> list=null;
		UserDao dao=new UserDao();
		System.out.println(email);
		System.out.println(name);
		System.out.println(username);
		System.out.println(job);
		System.out.println(sex);
		if (email!="") {
			list=dao.findEmail(email);
		}else {
			//单条件查询
			if (name!=""&&username==""&&job==""&&sex=="")
				list=dao.findName(name);
			if (name==""&&username!=""&&job==""&&sex=="")
				list=dao.findUserName(username);
			if (name==""&&username==""&&job!=""&&sex=="")
				list=dao.findJob(job);
			if (name==""&&username==""&&job==""&&sex!="")
				list=dao.findSex(sex);
			//双条件查询
			if (name!=""&&username!=""&&job==""&&sex=="") {
				QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
				String sql="select * from user where name=? and username=?";
				list = runner.query(sql, new BeanListHandler<userBean>(userBean.class),name,username);
			}
			if (name!=""&&username==""&&job!=""&&sex=="") {
				QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
				String sql="select * from user where name=? and job=?";
				list = runner.query(sql, new BeanListHandler<userBean>(userBean.class),name,job);
			}
			if (name!=""&&username==""&&job==""&&sex!="") {
				QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
				String sql="select * from user where name=? and sex=?";
				list = runner.query(sql, new BeanListHandler<userBean>(userBean.class),name,sex);
			}
			if (name==""&&username!=""&&job!=""&&sex=="") {
				QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
				String sql="select * from user where username=? and job=?";
				list = runner.query(sql, new BeanListHandler<userBean>(userBean.class),username,job);
			}
			if (name==""&&username!=""&&job==""&&sex!="") {
				QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
				String sql="select * from user where username=? and sex=?";
				list = runner.query(sql, new BeanListHandler<userBean>(userBean.class),username,sex);
			}
			if (name==""&&username==""&&job!=""&&sex!="") {
				QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
				String sql="select * from user where job=? and sex=?";
				list = runner.query(sql, new BeanListHandler<userBean>(userBean.class),job,sex);
			}
			//三个条件查询
			if (name==""&&username!=""&&job!=""&&sex!="") {
				QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
				String sql="select * from user where username=? and job=? and sex=?";
				list = runner.query(sql, new BeanListHandler<userBean>(userBean.class),username,job,sex);
			}
			if (name!=""&&username==""&&job!=""&&sex!="") {
				QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
				String sql="select * from user where name=? and job=? and sex=?";
				list = runner.query(sql, new BeanListHandler<userBean>(userBean.class),name,job,sex);
			}
			if (name!=""&&username!=""&&job==""&&sex!="") {
				QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
				String sql="select * from user where name=? and username=? and sex=?";
				list = runner.query(sql, new BeanListHandler<userBean>(userBean.class),name,username,sex);
			}
			if (name!=""&&username!=""&&job!=""&&sex=="") {
				QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
				String sql="select * from user where name=? and username=? and job=?";
				list = runner.query(sql, new BeanListHandler<userBean>(userBean.class),name,username,job);
			}
			if (name!=""&&username!=""&&job!=""&&sex!="") {
				QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
				String sql="select * from user where name=? and username=? and job=? and sex=?";
				list = runner.query(sql, new BeanListHandler<userBean>(userBean.class),name,username,job,sex);
			}
		}
	return list;
	}
	//添加用户的方法，添加一个用户
	public static Boolean UserAdd(String email,String name,String username,String password,String address,
			String phone,String job,String sex,String role) throws SQLException {
		userBean user=new userBean();
		UserDao dao=new UserDao();
		user.setEmail(email);
		user.setPassword(password);
		user.setName(name);
		user.setUsername(username);
		user.setSex(sex);
		user.setJob(job);
		user.setPhone(phone);
		user.setAddress(address);
		user.setDescribe("");
		user.setRole(role);
		user.setBirthday(null);
		return dao.insert(user);
	}
	
}
