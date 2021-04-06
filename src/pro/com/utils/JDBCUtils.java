package pro.com.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;


public class JDBCUtils {
	public JDBCUtils() {
	// TODO Auto-generated constructor stub
    }
	//创建数据库连接池
		private static DataSource ds=null;
		static {
			Properties prop=null;
			try {
				//1.创建加载配置文件 
				prop=new Properties();
				//2.加载配置文件
				InputStream in = new JDBCUtils().getClass().getClassLoader().getResourceAsStream("pro/com/utils/DBconfig.properties");
				prop.load(in);
				//3.通过配置文件，创建数据源对象
				ds = BasicDataSourceFactory.createDataSource(prop);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static DataSource getDataSource(){
			return ds;
		}
		public static Connection getConnection() {
			try {
				return ds.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	
	
	public static void close(ResultSet rs, Statement st,Connection conn){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
