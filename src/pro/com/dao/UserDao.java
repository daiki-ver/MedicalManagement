package pro.com.dao;

import java.util.*;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pro.com.bean.userBean;
import pro.com.utils.JDBCUtils;

public class UserDao {
	//提供插入方法
	public Boolean insert(userBean user) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new  QueryRunner(JDBCUtils.getDataSource());
		//写SQL语句
		String sql="insert into user values(?,?,?,?,?,?,?,?,?,?,?)";
		//执行sql，更新方法
		int num = runner.update(sql,user.getEmail(),user.getPassword(),user.getName(),
				user.getSex(),user.getUsername(),user.getJob(),user.getPhone(),user.getAddress(),
				user.getDescribe(),user.getRole(),user.getBirthday());
		if (num>0) {
			return true;
		}
		return false;
	}

	//提供一个修改方法
	public static Boolean update(userBean user) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="update user set password=?,name=?,username=?,sex=?,job=?,phone=?,"
				+ "address=?,`describe`=?,role=?,birthday=? where email=?";
		//执行sql调用更新方法
		int num = runner.update(sql,user.getPassword(),user.getName(),
				user.getUsername(),user.getSex(),user.getJob(),user.getPhone(),user.getAddress(),
				user.getDescribe(),user.getRole(),user.getBirthday(),user.getEmail());
		if(num>0) {
			return true;
		}
		return false;
	}
	
	//删除
	public static Boolean delete(String email) throws SQLException{
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="delete from user where email=?";
		int num = runner.update(sql,email);
		if (num>0) {
			return true;
		}
		return false;
	}
	
	//查询
	public List findAll() throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from user";
		List<userBean> list = runner.query(sql, new BeanListHandler<userBean>(userBean.class));
		return list;
	}
	
	
	
	//根据email查询一条记录，对应一个对象
	public userBean find(String email) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from user where email=?";
		userBean user=runner.query(sql, new BeanHandler<userBean>(userBean.class),email);
		return user;
	}
	//根据name查询一条记录，对应多个对象,返回姓名相同的用户list
	public List findEmail(String email) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from user where email=?";
		List<userBean> list = runner.query(sql, new BeanListHandler<userBean>(userBean.class),email);
		return list;
	}
	//根据name查询一条记录，对应多个对象,返回姓名相同的用户list
	public List findName(String name) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from user where name=?";
		List<userBean> list = runner.query(sql, new BeanListHandler<userBean>(userBean.class),name);
		return list;
	}
	//根据name查询一条记录，对应多个对象,返回用户名相同的用户list
	public List findUserName(String username) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from user where username=?";
		List<userBean> list = runner.query(sql, new BeanListHandler<userBean>(userBean.class),username);
		return list;
	}
	//根据name查询一条记录，对应多个对象,返回性别相同的用户list
	public List findSex(String sex) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from user where sex=?";
		List<userBean> list = runner.query(sql, new BeanListHandler<userBean>(userBean.class),sex);
		return list;
	}
	//根据name查询一条记录，对应多个对象,返回职位相同的用户list
	public List findJob(String job) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from user where job=?";
		List<userBean> list = runner.query(sql, new BeanListHandler<userBean>(userBean.class),job);
		return list;
	}
}

