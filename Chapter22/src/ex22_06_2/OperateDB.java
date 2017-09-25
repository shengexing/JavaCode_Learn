package ex22_06_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OperateDB {
	
	public static Connection getMySQLConnection(String db, String user, String pwd) {
		Connection conn = null;
		// ������
		try {
			String driver = "com.mysql.jdbc.Driver";		// ������������
			String url = "jdbc:mysql://localhost:3306/" + db;		// test��������Դ������

			Class.forName(driver);		// �������ݿ����������
			conn = DriverManager.getConnection(url, user, pwd);		// �������ݿ�
			if(conn != null)
				System.out.println("���ݿ����ӳɹ���");
		} catch(Exception e) {
			System.err.print("���ݿ�����ʧ�ܣ�\n" + e.toString());
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
