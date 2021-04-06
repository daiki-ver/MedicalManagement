package pro.com.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import pro.com.bean.userBean;
import pro.com.utils.JDBCUtils;

public class PageUserAdminDao {
	//限制查询count起始位置，offset为步长
	public static List<userBean> getUserList(int count,int offset) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select * from user ORDER BY role ASC limit ?,?";
		List<userBean> list = runner.query(sql, new BeanListHandler<userBean>(userBean.class),
				count,offset);
		return list;
	}
	
	
	//返回一个整数为查询结果条数
	//查询全部获得总记录数
	//select count(*) from user;
	public static Integer totleCount() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="select count(*) from user";
		Integer totleCount = 0;
		totleCount=((Long)runner.query(sql, new ScalarHandler<>())).intValue();
        return totleCount;
	}
}
