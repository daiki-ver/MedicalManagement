package pro.com.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pro.com.bean.DoctorBean;
import pro.com.dao.DoctorDao;
import pro.com.utils.JDBCUtils;

public class DoctorAdminService {
	//Search方法，用于调用搜索框信息查询
	public static List<DoctorBean> Search(int id,String name,String room,String job) throws SQLException {
		List<DoctorBean> list=null;
		DoctorDao dao=new DoctorDao();
		if (id!=0) {
			list=dao.findId(id);
		}else {
			//单条件查询
			if(name!=""&&room==""&&job=="")
				list=dao.findName(name);
			if(name==""&&room!=""&&job=="")
				list=dao.findRoom(room);
			if(name==""&&room==""&&job!="")
				list=dao.findJob(job);
			//双条件查询
			if (name==""&&room!=""&&job!="") {
				QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());
				String sql="select * from doctor where droom=? and djob=?";
				list=runner.query(sql, new BeanListHandler<DoctorBean>(DoctorBean.class),room,job);
			}
			if (name!=""&&room==""&&job!="") {
				QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());
				String sql="select * from doctor where dname=? and djob=?";
				list=runner.query(sql, new BeanListHandler<DoctorBean>(DoctorBean.class),name,job);
			}
			if (name!=""&&room!=""&&job=="") {
				QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());
				String sql="select * from doctor where dname=? and droom=?";
				list=runner.query(sql, new BeanListHandler<DoctorBean>(DoctorBean.class),name,room);
			}
			//三条件查询
			if (name!=""&&room!=""&&job!="") {
				QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());
				String sql="select * from doctor where dname=? and droom=? and djob=?";
				list=runner.query(sql, new BeanListHandler<DoctorBean>(DoctorBean.class),name,room,job);
			}
		}
		return list;
	}
	public static Boolean DoctorAdd(String email,String password,String name,String room,
			String job,String sex,int age,String phone,String address,String role) throws SQLException {
		DoctorBean doctor=new DoctorBean();
		DoctorDao dao=new DoctorDao();
		doctor.setDemail(email);
		doctor.setDpassword(password);
		doctor.setDname(name);
		doctor.setDroom(room);
		doctor.setDjob(job);
		doctor.setDsex(sex);
		doctor.setDphone(phone);
		doctor.setDaddress(address);
		doctor.setDage(age);
		doctor.setRole(role);
		
		return dao.insert(doctor);
	}
}
