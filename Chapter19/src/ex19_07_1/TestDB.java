// 章节19.07.1            Java数据库应用程序访问数据库的全过程
package ex19_07_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDB {
	private Connection conn = null;		// 数据库的连接
	private Statement stmt = null;
	private ResultSet rs =null;

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

	// 普通查询
	public void query(String sql) {
		getConnect();		// 获取数据库连接
		
		try {
			stmt = conn.createStatement();		// 得到Statement的实例
			rs = stmt.executeQuery(sql);		// 执行SQL语句，返回结果集
			while(rs.next()) {
				String userName = rs.getString("username");
				String password = rs.getString("password");
				System.out.println("用户名：" + userName + "；密码：" + password);
			}
		} catch(Exception e) {
			System.err.print("查询数据时出错！\n" + e.toString());
		}
		
		closeAll(); 	// 释放资源
	}
	
	// 添加、删除、更新
	public void add_update_Delete(String sql) {
		getConnect();		// 获取数据库连接
		
		try {
			stmt = conn.createStatement();		// 得到Statement的实例
			int line = stmt.executeUpdate(sql);
			System.out.println("操作成功！" + line);
		} catch(Exception e) {
			System.err.print("更新数据时出错！\n" + e.toString());
		}
		
		closeAll(); 	// 释放资源
	}

	// 释放资源
	public void closeAll() {
		if(rs != null)
			rs = null;
		if(stmt != null)
			stmt = null;
		if(conn != null)
			conn = null;
		System.out.println("成功释放资源！");
	}

	public static void main(String[] args) {
		TestDB test = new TestDB();
		String querySQL, updateSQL;

		// 执行查询操作
		querySQL = "SELECT * FROM userlogin";
		test.query(querySQL);
		
		// 执行添加操作
		updateSQL = "INSERT into userlogin VALUES('赵六', '123456')";
		test.add_update_Delete(updateSQL);
		test.query(querySQL);
		
		// 执行删除操作
		updateSQL = "DELETE FROM userlogin WHERE username='赵六'";
		test.add_update_Delete(updateSQL);
		test.query(querySQL);
		
		// 执行修改操作
		updateSQL = "UPDATE userlogin SET username='田七' WHERE username='张三'";
		test.add_update_Delete(updateSQL);
		test.query(querySQL);
	}

}
