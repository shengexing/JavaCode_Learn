// 章节20.01.1            使用JcomboBox组合框
package ex20_01_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {
	private Connection conn = null;		// 声明数据库连接对象
	private Statement stmt = null;			// 声明SQL语句对象
	private ResultSet rs = null;				// 声明结果集对象

	public TestDB() {

	}

	// 连接数据库
	private void getConnect() {
		// 桥连接
		try {
			String driver = "com.mysql.jdbc.Driver";		// 声明驱动程序
			String url = "jdbc:mysql://localhost:3306/test";		// test就是数据源的名字
			String user = "root";		// login就是数据源的登录名
			String password = "11235813";		// 11235813就是数据源的密码

			Class.forName(driver);		// 加载数据库的驱动程序
			conn = DriverManager.getConnection(url, user, password);		// 连接数据库
			if(conn != null)
				System.out.println("数据库连接成功！");
		} catch(Exception e) {
			System.err.print("数据库连接失败！\n" + e.toString());
		}
	}

	// 释放资源
	public void closeAll() {
		try {
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			System.err.print("释放资源时出错！\n" + e.toString());
		}
		System.out.println("成功释放资源！");
	}

	// 普通查询
	public ResultSet query(String sql) {
		try {
			getConnect(); 			// 连接数据库

			// 结果集类型设为TYPE_SCROLL_SENSITIVE并发类型设为CONCUR_READ_ONLY
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			rs = stmt.executeQuery(sql);
		}  catch(Exception e) {
			System.err.print("查询数据时出错！\n" + e.toString());
		}

		return rs;
	}
	
	// 获得数据
	public String[] getAllName() {
		ResultSet rs = query("SELECT username FROM userlogin");
		
		try {
			rs.last();		// 移动到结果集的最后一行
			int rows = rs.getRow();		// 得到行数，赋给变量rows
			rs.beforeFirst(); 			// 移回结果集首行

			String name[] = new String[rows];		// 创建数组name，长度为rows
			int index = 0;
			while(rs.next()) {
				name[index] = rs.getString(1);
				index++;
			}
			
			closeAll(); 		// 释放资源
			
			return name;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
