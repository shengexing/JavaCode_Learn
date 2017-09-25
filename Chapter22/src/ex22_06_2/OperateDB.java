package ex22_06_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OperateDB {
	
	public static Connection getMySQLConnection(String db, String user, String pwd) {
		Connection conn = null;
		// 桥连接
		try {
			String driver = "com.mysql.jdbc.Driver";		// 声明驱动程序
			String url = "jdbc:mysql://localhost:3306/" + db;		// test就是数据源的名字

			Class.forName(driver);		// 加载数据库的驱动程序
			conn = DriverManager.getConnection(url, user, pwd);		// 连接数据库
			if(conn != null)
				System.out.println("数据库连接成功！");
		} catch(Exception e) {
			System.err.print("数据库连接失败！\n" + e.toString());
		}
		
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeStatement(Statement sm) {
		try {
			sm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void showResultSet(ResultSet rs) {
		try {
			rs.beforeFirst();
			while(rs.next())
				System.out.print(rs.getString("username") + "," + rs.getString("password") + "\t\t");
			System.out.println();
			rs.absolute(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
