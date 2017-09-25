// 章节20.04.1            使用Result更新数据库
package ex20_04_1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 本例演示使用ResultSet更新数据库的数据。包括修改、插入和删除
 */
public class UpdateWithResultSet {
	/**
	 * 使用ResultSet可以更新数据库的数据，前提是与之相连的Statement没有被关闭
	 * @param con
	 */
	public static void update(Connection conn) {
		String sql = "SELECT * FROM userlogin";
		Statement sm = null;
		ResultSet rs = null;
		try {
			// 创建Statement
			// ResultSet.TYPE_SCROLL_SENSITIVE表示在ResultSet中可以随心所欲地向前向后移动游标
			// 同时ResultSet的值有所改变的时候，它可以得到改变后的最新的值
			// ResultSet.CONCUR_UPDATABLE表示在ResultSet中的数据记录可以任意修改，然后更新数据库
			sm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = sm.executeQuery(sql);
			
			/** 用ResultSet更新第一条数据*/
			// 指针移到第一条数据
			rs.absolute(1);
			// 修改数据
			rs.updateString(2, "666666");
			System.out.println("将要用ResultSet修改一条记录！" + rs.getString(2));
			// 如果决定修改，则使用updateRow方法提交修改
			rs.updateRow();
			// 如果想取消当前记录的修改，可以取消
			/*rs.cancelRowUpdates();*/
			rs.cancelRowUpdates();
			// 将修改提交到数据源
			OperateDB.showResultSet(rs);
			
			/** 用ResultSet插入一条数据*/
			System.out.println("准备用ResultSet插入一条记录！");
			// 指针移动到插入点
			rs.moveToInsertRow();
			// 为新数据设置值
			rs.updateString("username", "张三");
			rs.updateString(2, "12345678");
			// 将插入提交到数据源
			rs.insertRow();
			OperateDB.showResultSet(rs);
			
			/** 用ResultSet删除一条数据*/
			rs.absolute(4);
			System.out.println("准备用ResultSet删除最后一条记录！");
			rs.deleteRow();
			OperateDB.showResultSet(rs);
			
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭Statement
			OperateDB.closeStatement(sm);
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		String dbName = "test";
		String userName = "root";
		String password = "11235813";
		
		Connection conn = null;
		
		try {
			// 获得数据库连接
			conn = OperateDB.getMySQLConnection(dbName, userName, password);
			
			// 更新数据库
			UpdateWithResultSet.update(conn);
		} finally {
			// 关闭数据库连接
			OperateDB.closeConnection(conn);
		}

	}

}
