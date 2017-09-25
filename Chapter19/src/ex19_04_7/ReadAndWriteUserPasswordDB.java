// 章节19.04.7            装载数据库驱动程序的示例
package ex19_04_7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 定义一个类
public class ReadAndWriteUserPasswordDB {
	private Connection conn;		// 定义一个数据库连接对象
	private Statement stmt;			// 定义一个声明对象
	private ResultSet rs;				// 定义一个结果集对象
	private String getResult = null;
	private boolean passFlag = false;
	
	// 定义并实现一个方法，该方法完成数据库驱动程序的加载和完成数据库的连接
	public ReadAndWriteUserPasswordDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");		// 加载数据库驱动程序
		} catch(ClassNotFoundException ex) {
			System.err.println("加载失败");
			ex.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/test";		// 定义URL
		try {
			conn = DriverManager.getConnection(url, "root", "11235813");		// 获得数据库连接对象
			stmt = conn.createStatement();		// 通过数据库连接对象建立数据库声明对象
		} catch(SQLException ex) {		// 捕获异常并处理异常
			ex.printStackTrace();
		}
	}

	// 定义并实现一个方法，该方法读数据库，并搜索与用户名匹配的密码
	// 如用户名不存在或该用户的密码输入不正确，则设置标志passFalg为false
	public String readDB(String username, String password) throws Exception {
		getResult = null;
		
		// 执行SELECT语句，返回与username相同的用户的密码
		rs = stmt.executeQuery("SELECT password FROM userlogin WHERE username=" + "'" + username + "'");
		if(rs.next()) {
			getResult = rs.getString("password");
			if(getResult.equals(password))
				this.passFlag = true;
			else
				this.passFlag = false;
		} else
			this.passFlag = false;
		
		// 如果没有数据，则返回null
		return getResult;
	}
	
	// 关闭数据库连接
	public void close() throws Exception {
		rs.close();
		stmt.close();
		conn.close();
	}
	
	public static void main(String[] args) {
		ReadAndWriteUserPasswordDB test = new ReadAndWriteUserPasswordDB();
		
		try {
			System.out.println(test.readDB("神歌行", "1123581321"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
