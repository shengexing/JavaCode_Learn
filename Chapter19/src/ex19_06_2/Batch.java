// 章节19.06.2            一个批处理的例子
package ex19_06_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Batch {

	public static void main(String[] args) {
		try {
			// 加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");

			// 打开数据库连接，test为数据源名称
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "11235813");
			
			// 进行批处理
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			
			// 插入三条语句
			stmt.addBatch("INSERT INTO userlogin VALUES('张三', '123456')");
			stmt.addBatch("INSERT INTO userlogin VALUES('李四', '123456')");
			stmt.addBatch("INSERT INTO userlogin VALUES('王五', '123456')");
			
			stmt.executeBatch();
			conn.commit();
			
			// 恢复autoCommit设置
			conn.setAutoCommit(true);
			
			// 关闭Statement对象
			stmt.close();
			
			// 关闭Connection对象
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
