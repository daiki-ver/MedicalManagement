package pro.com.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pro.com.bean.DoctorBean;
import pro.com.utils.JDBCUtils;

public class DoctorDao {
	//插入医生信息
	public Boolean insert(DoctorBean doctor) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new  QueryRunner(JDBCUtils.getDataSource());
		//写SQL语句
		String sql="insert into doctor values(null,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		//执行sql，更新方法
		int num = runner.update(sql,doctor.getDname(),doctor.getDusername(),doctor.getDroom(),doctor.getDemail(),
				doctor.getDpassword(),doctor.getDjob(),doctor.getDsex(),doctor.getDage(),doctor.getDid_card(),
				doctor.getDphone(),doctor.getDaddress(),doctor.getDdescribe(),doctor.getRole());
		if (num>0) {
			return true;
		}
		return false;
	}
	
	//修改医生信息
	public Boolean update(DoctorBean doctor) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="update doctor set dname=?,dusername=?,droom=?,demail=?,dpassword=?,djob=?,"
				+ "dsex=?,dage=?,did_card=?,dphone=?,daddress=?,ddescribe=?,role=? where id=?";
		//执行sql调用更新方法
		int num = runner.update(sql,doctor.getDname(),doctor.getDusername(),doctor.getDroom(),doctor.getDemail(),doctor.getDpassword(),
				doctor.getDjob(),doctor.getDsex(),doctor.getDage(),doctor.getDid_card(),doctor.getDphone(),doctor.getDaddress(),
				doctor.getDdescribe(),doctor.getRole(),doctor.getId());
		if(num>0) {
			return true;
		}
		return false;
	}
	
	//删除
	public Boolean delete(int id) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="delete from doctor where id=?";
		int num = runner.update(sql,id);
		if (num>0) {
			return true;
		}
		return false;
	}
	
	//查询所有医护信息
	public List findAll() throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from doctor";
		List<DoctorBean> list = runner.query(sql, new BeanListHandler<DoctorBean>(DoctorBean.class));
		return list;
	}
	
	//调用id查询
	public DoctorBean find(int id) throws SQLException{
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from doctor where id=?";
		DoctorBean doctorBean = runner.query(sql, new BeanHandler<DoctorBean>(DoctorBean.class),id);
		return doctorBean;
	}
	
	
	//调用id查询
	public List findId(int id) throws SQLException{
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from doctor where id=?";
		List<DoctorBean> list = runner.query(sql, new BeanListHandler<DoctorBean>(DoctorBean.class),id);
		return list;
	}
	
	//调用name查询
	public List findName(String name) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from doctor where dname=?";
		List<DoctorBean> list = runner.query(sql, new BeanListHandler<DoctorBean>(DoctorBean.class),name);
		return list;
	}
	
	//调用room查询
	public List findRoom(String room) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from doctor where droom=?";
		List<DoctorBean> list = runner.query(sql, new BeanListHandler<DoctorBean>(DoctorBean.class),room);
		return list;
	}
	
	//调用job查询
	public List findJob(String job) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from doctor where djob=?";
		List<DoctorBean> list = runner.query(sql, new BeanListHandler<DoctorBean>(DoctorBean.class),job);
		return list;
	}
	
}
