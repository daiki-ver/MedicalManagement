package pro.com.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pro.com.bean.MedicalBean;
import pro.com.dao.MedicalDao;
import pro.com.utils.JDBCUtils;

public class MedicalAdminService {
	public static List<MedicalBean> Search(int mid,String pname,String dname) throws SQLException{
		List<MedicalBean> list=null;
		MedicalDao dao=new MedicalDao();
		if (mid!=0) {
			list=dao.findMid(mid);
		}else {
			//单条件查询
			if(pname!=""&&dname=="")
				list=dao.findPname(pname);
			if(pname==""&&dname!="")
				list=dao.findDname(dname);
			//双条件查询
			if (pname!=""&&dname!="") {
				QueryRunner runner=new QueryRunner(JDBCUtils.getDataSource());
				String sql="select * from medical where pname=? and dname=?";
				list=runner.query(sql, new BeanListHandler<MedicalBean>(MedicalBean.class),pname,dname);
			}
		}
		return list;
	}
}
