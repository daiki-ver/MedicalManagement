package pro.com.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pro.com.bean.PatientBean;
import pro.com.dao.PatientDao;
import pro.com.utils.JDBCUtils;

public class PatientAdminService {
	//Search方法，用于查询搜索框中给出的信息对应患者资料
	public static List<PatientBean> Search(int id,String natplace,String name,String sex) throws SQLException{
		List<PatientBean> list=null;
		PatientDao dao=new PatientDao();
		if (id!=0) {
			list=dao.findId(id);
		}else {
			//单条件查询
			if(natplace!=""&&name==""&&sex=="")
				list=dao.findNatplace(natplace);
			if(natplace==""&&name!=""&&sex=="")
				list=dao.findName(name);
			if(natplace==""&&name==""&&sex!="")
				list=dao.findSex(sex);
			//双条件查询
			if(natplace==""&&name!=""&&sex!="") {
				QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());
				String sql="select * from patient where pname=? and psex=?";
				list=runner.query(sql, new BeanListHandler<PatientBean>(PatientBean.class),name,sex);
			}
			if (natplace!=""&&name==""&&sex!="") {
				QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());
				String sql="select * from patient where pnatplace=? and psex=?";
				list=runner.query(sql, new BeanListHandler<PatientBean>(PatientBean.class),natplace,sex);
			}
			if (natplace!=""&&name!=""&&sex=="") {
				QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());
				String sql="select * from patient where pnatplace=? and pname=?";
				list=runner.query(sql, new BeanListHandler<PatientBean>(PatientBean.class),natplace,name);
			}
			//三条件查询
			if (natplace!=""&&name!=""&&sex!="") {
				QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());
				String sql="select * from patient where pnatplace=? and pname=? and psex=?";
				list=runner.query(sql, new BeanListHandler<PatientBean>(PatientBean.class),natplace,name,sex);
			}
		}
		return list;
	}
	
	//添加患者服务
	public static Boolean PatientAdd (String name,String email,String password,String nation,int age,String sex,
			String address) throws SQLException {
		PatientBean patient=new PatientBean();
		PatientDao dao=new PatientDao();
		patient.setPname(name);
		patient.setPemail(email);
		patient.setPpassword(password);
		patient.setPnation(nation);
		patient.setPage(age);
		patient.setPsex(sex);
		patient.setPaddress(address);
		return dao.insert(patient);
	}
}
