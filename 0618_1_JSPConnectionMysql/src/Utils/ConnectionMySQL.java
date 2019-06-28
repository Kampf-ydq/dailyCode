package Utils;

import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

public class ConnectionMySQL {
	
	public static ResultSet getResult(){
		//1.连接数据库
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String pwd = "123456";
		String sql = "select * from tb_user";

		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url,user,pwd);
			statement = conn.createStatement();
			rs = (ResultSet) statement.executeQuery(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
}
