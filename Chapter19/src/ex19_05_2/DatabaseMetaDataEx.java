// 章节19.05.2            DatabaseMetaData基本方法
package ex19_05_2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DatabaseMetaDataEx {

	public static void main(String[] args) {
		try {
			// 加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			
			// 打开数据库连接，test为数据源名称
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "11235813");
			
			// 定义DatabaseMetaData对象
			DatabaseMetaData dmd = conn.getMetaData();
			
			// 检索可在给定类别中使用的表的描述
			ResultSet rs = dmd.getTables(null, null, null, new String[] {"table"});
			
			// 定义ResultSetMetaData对象
			ResultSetMetaData rsmd = rs.getMetaData();
			
			// 返回此ResultSet对象中的列数
			int cols = rsmd.getColumnCount();
			for(int i = 1; i <= cols; i++)
				// 获取指定列的名称
				System.out.print(rsmd.getColumnName(i) + "\t");
			System.out.println();
			while(rs.next()) {
				for(int i = 1; i< cols; i++)
					System.out.print(rs.getString(i) + "\t");
				System.out.println();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
