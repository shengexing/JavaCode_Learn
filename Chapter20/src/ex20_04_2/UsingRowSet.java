// �½�20.04.2            ʹ��Result�������ݿ�
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
 * ������ʾ���ʹ��RowSet�ӿڡ�RowSet�̳�ResultSet����ResultSet������
 * ��JDK1.5��������֮һ
 */
public class UsingRowSet {
	/**
	 * ʹ��CachedRowSet
	 * һ��������ݣ�CachedRowSet�Ϳ��ԶϿ������ݿ������
	 * ֱ�������ݿ�д�����ݵ�ʱ����轨������
	 */
	public static void usingCachedRowSet() throws SQLException {
		CachedRowSet crs = new CachedRowSetImpl();
		
		// ����CachedRowSet�����ԣ���������ֱ���������ݿ�
		crs.setUrl("jdbc:mysql://localhost:3306/test");
		crs.setUsername("root");
		crs.setPassword("11235813");
		crs.setCommand("SELECT * FROM userlogin");
		
		try {
			// ��Ҫ�ȼ���������������ʹ��ִ��ʱ���Ҳ���������
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			System.err.print("����������ʧ�ܣ���û���ҵ�������\n");
			e.printStackTrace();
		}
		
		// CachedRowSet��execute����ִ��SQL���
		// ���Ȼᴴ�������ݿ�����ӣ�Ȼ������ȡ�������ٹر�����
		crs.execute();
		// ��ʱ��CachedRowSet�����ݿ��ǶϿ����ӵ�
		System.out.println("ʹ��CachedRowSet��������ǰ��");
		OperateDB.showResultSet(crs);
		
		// �ڶϿ����ӵ�����¿��Բ�������
		crs.beforeFirst();
		
		while(crs.next()) {
			System.out.println("sssssssssssssssssssssssssssss");
			if(crs.getString("username").equals("����")) {
				crs.updateString("password", "7777777");
				// Ҫ�뽫���µ������ύ�����ݿ⣬���������������
				// ����ȷ��Ҫ�޸�
				crs.updateRow();
				// �ٵ���acceptChanges()������������ݿ�����ӣ����޸��ύ�����ݿ�
				crs.acceptChanges();
				break;
			}
		}
		
		System.out.println("ʹ��CachedRowSet�������ݺ�");
		OperateDB.showResultSet(crs);
		
		crs.close();
	}
	
	/**
	 * ʹ��JdbcRowSet
	 * JdbcRowSet������ResultSet���ƣ�JdbcRowSet�ڲ���ʱ���������ݿ������
	 * JdbcRowSet���صĽ��Ĭ���ǿ������¹����Ϳɸ��µ�
	 */
	public static void usingJdbcRowSet() throws SQLException {
		JdbcRowSet jdbcrs = new JdbcRowSetImpl();
		
		// ����JdbcRowSet�����ԣ���������ֱ���������ݿ�
		jdbcrs.setUrl("jdbc:mysql://localhost:3306/test");
		jdbcrs.setUsername("root");
		jdbcrs.setPassword("11235813");
		jdbcrs.setCommand("SELECT * FROM userlogin");
		
		try {
			// ��Ҫ�ȼ���������������ִ��ʱ���Ҳ���������
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			System.err.print("����������ʧ�ܣ���û���ҵ�������\n");
			e.printStackTrace();
		}
		
		// JdbcRowSet��execute����ִ��SQL��䣬���Ȼ�����ݿ����ӣ��ٻ�ȡ�����
		// ��CachedRowSet��execute������ͬ��ִ����������ر����ӣ�����һֱ���ָ����ӣ�ֱ������close����
		jdbcrs.execute();
		System.out.println("ʹ��JdbcRowSet��������ǰ��");
		OperateDB.showResultSet(jdbcrs);
		
		// Ȼ���������
		jdbcrs.beforeFirst();
		while(jdbcrs.next())
			if(jdbcrs.getString("username").equals("����")) {
				jdbcrs.updateString("password", "777777");
				// �ύ�����ݿ�
				jdbcrs.updateRow();
				// ��Ϊ�����������ӵ����ݿ�ģ����Ժ�CachedRowSet��ͬ��������Ҫ�ٴλ������
				break;
			}
		
		System.out.println("ʹ��CachedRowSet�������ݺ�");
		OperateDB.showResultSet(jdbcrs);
		
		// �رս��������ʱ�ر����ݿ�����
		jdbcrs.close();
	}
	
	/**
	 * ʹ��FilteredRowSet
	 * FilteredRowSet�ӿ��й涨�˿����趨����������������ӿ�ΪPredicate�ӿ�
	 * ����ʵ��Predicate�ӿ��е�evalucate����
	 */
	public static void usingFilteredRowSet() throws SQLException {
		FilteredRowSet frs = new FilteredRowSetImpl();
		
		// ����FilteredRowSet�����ԣ���������ֱ�������ݿ�
		frs.setUrl("jdbc:mysql://localhost:3306/test");
		frs.setUsername("root");
		frs.setPassword("11235813");
		frs.setCommand("SELECT * FROM userlogin");
		
		try {
			// ��Ҫ�ȼ���������������ִ��ʱ���Ҳ���������
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			System.err.print("����������ʧ�ܣ���û���ҵ�������\n");
			e.printStackTrace();
		}
		
		// FilteredRowSet�̳�CachedRowSet
		// ����execute����������CachedRowSet��execute����һ��
		frs.execute();
		
		// ��ʱ��CachedRowSet�����ݿ��ǶϿ����ӵ�
		System.out.println("ʹ��FilteredRowSet��������֮ǰ��");
		OperateDB.showResultSet(frs);
		
		// ���ù�����������������ʵ��Predicate�ӿڶ��������execute����
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
				
				// �������Ϊ�����ġ��򷵻�true
				try {
					if(crs.getString("username").equals("����"))
						return true;
				} catch(SQLException e) {
					System.err.print("����SQL�쳣������\n");
					e.printStackTrace();
				}
				return false;
			}
		});
		
		System.out.println("ʹ��FilteredRowSet��������֮��");
		OperateDB.showResultSet(frs);
		
		frs.close();
	}
	
	/**
	 * ʹ��JoinRowSet
	 * JoinRowSet���Խ����RowSet�������join�ϲ�
	 * Join���п���ͨ��ÿ��RowSet����setMatchColumn�������á�
	 * setMatchColumn��ʽ��Joinable�ӿڶ���ķ������������͵�RowSet�涨����Ҫʵ�ָýӿڡ�
	 * JoinRowSet�̳�CachedRowSet��Ҳ����Ҫ���������ݿ�����ӡ�
	 */
	public static void usingJoinRowSet() throws SQLException {
		JoinRowSet joinrs = new JoinRowSetImpl();
		
		CachedRowSet crs = new CachedRowSetImpl();
		
		// ����CachedRowSet�����ԣ���������ֱ���������ݿ�
		crs.setUrl("jdbc:mysql://localhost:3306/test");
		crs.setUsername("root");
		crs.setPassword("11235813");
		crs.setCommand("SELECT * FROM userlogin");
		
		try {
			// ��Ҫ�ȼ���������������ִ��ʱ���Ҳ���������
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			System.err.print("����������ʧ�ܣ���û���ҵ�������\n");
			e.printStackTrace();
		}
		
		// ��ȡ�����
		crs.execute();
		// ���ý������Joinʱƥ�������
		crs.setMatchColumn("username");
		// ����������ݷ���JoinRowSet
		joinrs.addRowSet(crs);
		crs.close();
		
		// ����һ����
		crs.setCommand("SELECT * FROM student");
		crs.execute();
		crs.setMatchColumn("name");
		joinrs.addRowSet(crs);
		crs.close();
		
		System.out.println("ʹ��JoinRowSet�Զ�����������Join������");
		// ��ʱ����������Ѿ�Join��һ����
		// ��userlogin��username�кͱ�student��name�н���ƥ��
		while(joinrs.next()) {
			// name���Թ��У�passwordΪ��userlogin����
			System.out.print(joinrs.getString("name") + "\t");
			System.out.print(joinrs.getString("password") + "\t");
			// sex��stu_id����Ϊ��student����
			System.out.print(new String(joinrs.getString("sex")) + "\t");
			System.out.println(new String(joinrs.getString("stu_id")));
		}
		
		joinrs.close();
	}
	
	/**
	 * ʹ��WebRowSet
	 * WebRowSet�̳���CachedRowSet��֧��XML��ʽ�Ĳ�ѯ�����µȲ���
	 * ���潫WebRowSet���������XML��ʽ���ļ�
	 */
	public static void usingWebRowSet() throws SQLException {
		WebRowSet wrs = new WebRowSetImpl();
		
		//����CachedRowSet�����ԣ���������ֱ�������ݿ�
		wrs.setUrl("jdbc:mysql://localhost:3306/test");
		wrs.setUsername("root");
		wrs.setPassword("11235813");
		wrs.setCommand("SELECT * FROM userlogin");
		
		try {
			// ��Ҫ�ȼ���������������ִ��ʱ���Ҳ���������
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			System.err.print("����������ʧ�ܣ���û���ҵ�������\n");
			e.printStackTrace();
		}
		
		// ��ȡ�����
		wrs.execute();
		
		// �����XML�ļ�
		try {
			FileOutputStream out = new FileOutputStream("userlogin.xml");
			wrs.writeXml(out);
			out.close();
		} catch(FileNotFoundException e) {
			System.err.print("XML�ļ�û���ҵ�������\n");
			e.printStackTrace();
		} catch(IOException e) {
			System.err.print("XML�ļ�����/���쳣������\n");
			e.printStackTrace();
		}
		
		wrs.close();
	}

	public static void main(String[] args) throws SQLException{
		UsingRowSet.usingCachedRowSet();

	}

}
