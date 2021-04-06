package pro.com.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import pro.com.bean.MedicalBean;
import pro.com.utils.JDBCUtils;

public class PageMedicalAdminDao {
	//限制查询count起始位置，offset为步长
	public static List<MedicalBean> getMedicalList(int count,int offset) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from medical ORDER BY mid ASC limit ?,?";
		List<MedicalBean> list = runner.query(sql, new BeanListHandler<MedicalBean>(MedicalBean.class),
				count,offset);
		return list;
	}

	//返回一个整数为查询结果条数
	//查询全部获得总记录数
	//select count(*) from user;
	public static Integer totleCount() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select count(*) from medical";
		Integer totleCount = 0;
		totleCount=((Long)runner.query(sql, new ScalarHandler<>())).intValue();
        return totleCount;
	}
}
