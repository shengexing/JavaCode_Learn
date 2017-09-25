// 章节20.04.2            使用Result更新数据库
package ex20_04_2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.Predicate;
import javax.sql.rowset.WebRowSet;

import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.FilteredRowSetImpl;
import com.sun.rowset.JdbcRowSetImpl;
import com.sun.rowset.JoinRowSetImpl;
import com.sun.rowset.WebRowSetImpl;

import ex20_04_1.OperateDB;

/**
 * 本例演示如何使用RowSet接口。RowSet继承ResultSet，比ResultSet更好用
 * 是JDK1.5的新特征之一
 */
public class UsingRowSet {
	/**
	 * 使用CachedRowSet
	 * 一旦获得数据，CachedRowSet就可以断开与数据库的连接
	 * 直到往数据库写入数据的时候才需建立连接
	 */
	public static void usingCachedRowSet() throws SQLException {
		CachedRowSet crs = new CachedRowSetImpl();
		
		// 设置CachedRowSet的属性，用它可以直接连接数据库
		crs.setUrl("jdbc:mysql://localhost:3306/test");
		crs.setUsername("root");
		crs.setPassword("11235813");
		crs.setCommand("SELECT * FROM userlogin");
		
		try {
			// 需要先加载驱动，否则在使用执行时会找不到驱动类
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			System.err.print("加载驱动类失败：类没有找到！！！\n");
			e.printStackTrace();
		}
		
		// CachedRowSet的execute方法执行SQL语句
		// 首先会创建与数据库的连接，然后结果集取出来，再关闭连接
		crs.execute();
		// 此时的CachedRowSet与数据库是断开连接的
		System.out.println("使用CachedRowSet操作数据前：");
		OperateDB.showResultSet(crs);
		
		// 在断开连接的情况下可以操作数据
		crs.beforeFirst();
		
		while(crs.next()) {
			System.out.println("sssssssssssssssssssssssssssss");
			if(crs.getString("username").equals("李四")) {
				crs.updateString("password", "7777777");
				// 要想将更新的数据提交到数据库，必须进行下面两步
				// 首先确认要修改
				crs.updateRow();
				// 再调用acceptChanges()方法获得与数据库的连接，将修改提交到数据库
				crs.acceptChanges();
				break;
			}
		}
		
		System.out.println("使用CachedRowSet操作数据后：");
		OperateDB.showResultSet(crs);
		
		crs.close();
	}
	
	/**
	 * 使用JdbcRowSet
	 * JdbcRowSet功能与ResultSet类似，JdbcRowSet在操作时保持与数据库的连接
	 * JdbcRowSet返回的结果默认是可以上下滚动和可更新的
	 */
	public static void usingJdbcRowSet() throws SQLException {
		JdbcRowSet jdbcrs = new JdbcRowSetImpl();
		
		// 设置JdbcRowSet的属性，用它可以直接连接数据库
		jdbcrs.setUrl("jdbc:mysql://localhost:3306/test");
		jdbcrs.setUsername("root");
		jdbcrs.setPassword("11235813");
		jdbcrs.setCommand("SELECT * FROM userlogin");
		
		try {
			// 需要先加载驱动，否则在执行时会找不到驱动类
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			System.err.print("加载驱动类失败：类没有找到！！！\n");
			e.printStackTrace();
		}
		
		// JdbcRowSet的execute方法执行SQL语句，首先获得数据库连接，再获取结果集
		// 与CachedRowSet的execute方法不同，执行完后它不关闭连接，它会一直保持该连接，直到调用close方法
		jdbcrs.execute();
		System.out.println("使用JdbcRowSet操作数据前：");
		OperateDB.showResultSet(jdbcrs);
		
		// 然后操作数据
		jdbcrs.beforeFirst();
		while(jdbcrs.next())
			if(jdbcrs.getString("username").equals("李四")) {
				jdbcrs.updateString("password", "777777");
				// 提交到数据库
				jdbcrs.updateRow();
				// 因为它本身是连接到数据库的，所以和CachedRowSet不同，它不需要再次获得连接
				break;
			}
		
		System.out.println("使用CachedRowSet操作数据后：");
		OperateDB.showResultSet(jdbcrs);
		
		// 关闭结果集，此时关闭数据库连接
		jdbcrs.close();
	}
	
	/**
	 * 使用FilteredRowSet
	 * FilteredRowSet接口中规定了可以设定过滤器，其过滤器接口为Predicate接口
	 * 必须实现Predicate接口中的evalucate方法
	 */
	public static void usingFilteredRowSet() throws SQLException {
		FilteredRowSet frs = new FilteredRowSetImpl();
		
		// 设置FilteredRowSet的属性，用它可以直接连数据库
		frs.setUrl("jdbc:mysql://localhost:3306/test");
		frs.setUsername("root");
		frs.setPassword("11235813");
		frs.setCommand("SELECT * FROM userlogin");
		
		try {
			// 需要先加载驱动，否则在执行时会找不到驱动类
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			System.err.print("加载驱动类失败：类没有找到！！！\n");
			e.printStackTrace();
		}
		
		// FilteredRowSet继承CachedRowSet
		// 所以execute方法功能与CachedRowSet的execute方法一样
		frs.execute();
		
		// 此时的CachedRowSet与数据库是断开连接的
		System.out.println("使用FilteredRowSet过滤数据之前：");
		OperateDB.showResultSet(frs);
		
		// 设置过滤器，过滤器必须实现Predicate接口定义的三个execute方法
		frs.setFilter(new Predicate() {
			
			@Override
			public boolean evaluate(Object value, String columnName) throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean evaluate(Object value, int column) throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean evaluate(RowSet rs) {
				CachedRowSet crs = (CachedRowSet)rs;
				
				// 如果名字为“李四”则返回true
				try {
					if(crs.getString("username").equals("李四"))
						return true;
				} catch(SQLException e) {
					System.err.print("出现SQL异常！！！\n");
					e.printStackTrace();
				}
				return false;
			}
		});
		
		System.out.println("使用FilteredRowSet过滤数据之后：");
		OperateDB.showResultSet(frs);
		
		frs.close();
	}
	
	/**
	 * 使用JoinRowSet
	 * JoinRowSet可以将多个RowSet对象进行join合并
	 * Join的列可以通过每个RowSet调用setMatchColumn方法设置。
	 * setMatchColumn方式是Joinable接口定义的方法，五种类型的RowSet规定都需要实现该接口。
	 * JoinRowSet继承CachedRowSet，也不需要保持与数据库的连接。
	 */
	public static void usingJoinRowSet() throws SQLException {
		JoinRowSet joinrs = new JoinRowSetImpl();
		
		CachedRowSet crs = new CachedRowSetImpl();
		
		// 设置CachedRowSet的属性，用它可以直接连接数据库
		crs.setUrl("jdbc:mysql://localhost:3306/test");
		crs.setUsername("root");
		crs.setPassword("11235813");
		crs.setCommand("SELECT * FROM userlogin");
		
		try {
			// 需要先加载驱动，否则在执行时会找不到驱动类
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			System.err.print("加载驱动类失败：类没有找到！！！\n");
			e.printStackTrace();
		}
		
		// 获取结果集
		crs.execute();
		// 设置结果集在Join时匹配的列名
		crs.setMatchColumn("username");
		// 将结果集数据放入JoinRowSet
		joinrs.addRowSet(crs);
		crs.close();
		
		// 查另一个表
		crs.setCommand("SELECT * FROM student");
		crs.execute();
		crs.setMatchColumn("name");
		joinrs.addRowSet(crs);
		crs.close();
		
		System.out.println("使用JoinRowSet对多个结果集进行Join操作：");
		// 此时两个结果集已经Join在一起了
		// 表userlogin的username列和表student的name列进行匹配
		while(joinrs.next()) {
			// name属性共有，password为表userlogin所有
			System.out.print(joinrs.getString("name") + "\t");
			System.out.print(joinrs.getString("password") + "\t");
			// sex、stu_id属性为表student所有
			System.out.print(new String(joinrs.getString("sex")) + "\t");
			System.out.println(new String(joinrs.getString("stu_id")));
		}
		
		joinrs.close();
	}
	
	/**
	 * 使用WebRowSet
	 * WebRowSet继承自CachedRowSet，支持XML格式的查询，更新等操作
	 * 下面将WebRowSet对象输出成XML格式到文件
	 */
	public static void usingWebRowSet() throws SQLException {
		WebRowSet wrs = new WebRowSetImpl();
		
		//设置CachedRowSet的属性，用它可以直接连数据库
		wrs.setUrl("jdbc:mysql://localhost:3306/test");
		wrs.setUsername("root");
		wrs.setPassword("11235813");
		wrs.setCommand("SELECT * FROM userlogin");
		
		try {
			// 需要先加载驱动，否则在执行时会找不到驱动类
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			System.err.print("加载驱动类失败：类没有找到！！！\n");
			e.printStackTrace();
		}
		
		// 获取结果集
		wrs.execute();
		
		// 输出到XML文件
		try {
			FileOutputStream out = new FileOutputStream("userlogin.xml");
			wrs.writeXml(out);
			out.close();
		} catch(FileNotFoundException e) {
			System.err.print("XML文件没有找到！！！\n");
			e.printStackTrace();
		} catch(IOException e) {
			System.err.print("XML文件输入/出异常！！！\n");
			e.printStackTrace();
		}
		
		wrs.close();
	}

	public static void main(String[] args) throws SQLException{
		UsingRowSet.usingCachedRowSet();

	}

}
