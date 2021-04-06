package pro.com.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pro.com.bean.MedicalBean;
import pro.com.utils.JDBCUtils;

public class MedicalDao {
	//插入病历信息
	public Boolean insert(MedicalBean medical) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new  QueryRunner(JDBCUtils.getDataSource());
		//写SQL语句
		String sql="insert into medical values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		//执行sql，更新方法
		int num = runner.update(sql,medical.getId(),medical.getPid(),medical.getPid_card(),medical.getPname(),medical.getPsex(),medical.getDname(),
				medical.getDroom(),medical.getIndate(),medical.getOutDate(),medical.getDiagnosis(),medical.getOutresult(),medical.getHnum(),
				medical.getBnum(),medical.getCurepass(),medical.getSuit(),medical.getNowill(),medical.getOldill(),medical.getMarriagehis(),
				medical.getBodycheck(),medical.getOthercheck(),medical.getDescribe());
		if (num>0) {
			return true;
		}
		return false;
	}
	
	//修改医生信息
	public Boolean update(MedicalBean medical) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="update medical set id=?,pid=?,pid_card=?,pname=?,psex=?,dname=?,droom=?,indate=?,outdate=?,diagnosis=?,outresult=?,"
				+ "hnum=?,bnum=?,curepass=?,suit=?,nowill=?,oldill=?,marriagehis=?,bodycheck=?,othercheck=?,`describe`=? where mid=?";
		//执行sql调用更新方法
		int num = runner.update(sql,medical.getId(),medical.getPid(),medical.getPid_card(),medical.getPname(),medical.getPsex(),medical.getDname(),
				medical.getDroom(),medical.getIndate(),medical.getOutDate(),medical.getDiagnosis(),medical.getOutresult(),medical.getHnum(),
				medical.getBnum(),medical.getCurepass(),medical.getSuit(),medical.getNowill(),medical.getOldill(),medical.getMarriagehis(),
				medical.getBodycheck(),medical.getOthercheck(),medical.getDescribe(),medical.getMid());
		if(num>0) {
			return true;
		}
		return false;
	}
	
	//删除
	public Boolean delete(int mid) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="delete from medical where mid=?";
		int num = runner.update(sql,mid);
		if (num>0) {
			return true;
		}
		return false;
	}
	
	//通过病历编号mid查询
	public MedicalBean find(int mid) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from medical where mid=?";
		MedicalBean medical = runner.query(sql, new BeanHandler<MedicalBean>(MedicalBean.class),mid);
		return medical;
	}
	
	//通过患者id查询
	public List findPid(int pid) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from medical where pid=?";
		List<MedicalBean> list = runner.query(sql, new BeanListHandler<MedicalBean>(MedicalBean.class),pid);
		return list;
	}
	
	
	
	//查询所有病历信息
	public List findAll() throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from medical";
		List<MedicalBean> list = runner.query(sql, new BeanListHandler<MedicalBean>(MedicalBean.class));
		return list;
	}
	
	//调用mid查询
	public List findMid(int mid) throws SQLException{
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from medical where mid=?";
		List<MedicalBean> list = runner.query(sql, new BeanListHandler<MedicalBean>(MedicalBean.class),mid);
		return list;
	}
	
	//调用患者姓名pname查询
	public List findPname(String pname) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from medical where pname=?";
		List<MedicalBean> list = runner.query(sql, new BeanListHandler<MedicalBean>(MedicalBean.class),pname);
		return list;
	}
	
	//调用主治医生姓名dname查询
	public List findDname(String dname) throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from medical where dname=?";
		List<MedicalBean> list = runner.query(sql, new BeanListHandler<MedicalBean>(MedicalBean.class),dname);
		return list;
	}
	
}
