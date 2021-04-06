package pro.com.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pro.com.bean.PatientBean;
import pro.com.utils.JDBCUtils;

public class PatientDao {
	//添加一名病人
	public Boolean insert(PatientBean patient) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new  QueryRunner(JDBCUtils.getDataSource());
		//写SQL语句
		String sql="insert into patient values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'patient')";
		//执行SQL语句，调用update方法；
		int num=runner.update(sql,patient.getPemail(),patient.getPname(),patient.getPusername(),patient.getPpassword(),
				patient.getPage(),patient.getPsex(),patient.getPjob(),patient.getPmarriage(),
				patient.getPnation(),patient.getPnatplace(),patient.getPaddress(),patient.getPphone(),
				patient.getAllergy(),patient.getPid_card(),patient.getPdiseases(),patient.getPdescribe());
		if (num>0) {
			return true;
		}
		return false;
	}
	
	//修改患者信息
	public Boolean update(PatientBean patient) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new  QueryRunner(JDBCUtils.getDataSource());
		//写SQL语句
		String sql="update patient set pname=?,pusername=?,ppassword=?,page=?,psex=?,pjob=?,pmarriage=?,pnation=?,pnatplace=?,"
				+ "paddress=?,pphone=?,allergy=?,pid_card=?,pdiseases=?,pdescribe=?,role=? where pid=?";
		//执行SQL语句
		int num=runner.update(sql,patient.getPname(),patient.getPusername(),patient.getPpassword(),patient.getPage(),
				patient.getPsex(),patient.getPjob(),patient.getPmarriage(),patient.getPnation(),patient.getPnatplace(),
				patient.getPaddress(),patient.getPphone(),patient.getAllergy(),patient.getPid_card(),patient.getPdiseases(),
				patient.getPdescribe(),patient.getRole(),patient.getPid());
		if (num>0) {
			return true;
		}
		return false;
	}
	
	//删除
	public Boolean delete(int id) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new  QueryRunner(JDBCUtils.getDataSource());
		//写SQL语句
		String sql="delete from patient where pid=?";
		int num=runner.update(sql,id);
		if (num>0) {
			return true;
		}
		return false;
	}
	
	//查询所有患者信息，返回一个list
	public List findAll() throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from patient";
		List<PatientBean> list = runner.query(sql, new BeanListHandler<PatientBean>(PatientBean.class));
		return list;
	}
	public PatientBean find(int pid) throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from patient where pid=?";
		PatientBean patientBean=runner.query(sql,new BeanHandler<PatientBean>(PatientBean.class),pid);
		return patientBean;
	}
	
	
	//根据id编号查询一条记录，对应多个对象,返回姓名相同的用户list
	public List findId(int id) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from patient where pid=?";
		List<PatientBean> list = runner.query(sql, new BeanListHandler<PatientBean>(PatientBean.class),id);
		return list;
	}
	//根据natplace（籍贯）查找，返回籍贯相同的list
	public List findNatplace(String natplace) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from patient where pnatplace=?";
		List<PatientBean> list = runner.query(sql, new BeanListHandler<PatientBean>(PatientBean.class),natplace);
		return list;
	}
	//根据name（姓名）查找，返回姓名相同的list
	public List findName(String name) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from patient where pname=?";
		List<PatientBean> list = runner.query(sql, new BeanListHandler<PatientBean>(PatientBean.class),name);
		return list;
	}
	//根据name（姓名）查找，返回姓名相同的list
	public List findSex(String psex) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from patient where psex=?";
		List<PatientBean> list = runner.query(sql, new BeanListHandler<PatientBean>(PatientBean.class),psex);
		return list;
	}
	
	
	
}
