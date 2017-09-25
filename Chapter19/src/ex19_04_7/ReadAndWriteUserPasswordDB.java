// �½�19.04.7            װ�����ݿ����������ʾ��
package ex19_04_7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// ����һ����
public class ReadAndWriteUserPasswordDB {
	private Connection conn;		// ����һ�����ݿ����Ӷ���
	private Statement stmt;			// ����һ����������
	private ResultSet rs;				// ����һ�����������
	private String getResult = null;
	private boolean passFlag = false;
	
	// ���岢ʵ��һ���������÷���������ݿ���������ļ��غ�������ݿ������
	public ReadAndWriteUserPasswordDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");		// �������ݿ���������
		} catch(ClassNotFoundException ex) {
			System.err.println("����ʧ��");
			ex.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/test";		// ����URL
		try {
			conn = DriverManager.getConnection(url, "root", "11235813");		// ������ݿ����Ӷ���
			stmt = conn.createStatement();		// ͨ�����ݿ����Ӷ��������ݿ���������
		} catch(SQLException ex) {		// �����쳣�������쳣
			ex.printStackTrace();
		}
	}

	// ���岢ʵ��һ���������÷��������ݿ⣬���������û���ƥ�������
	// ���û��������ڻ���û����������벻��ȷ�������ñ�־passFalgΪfalse
	public String readDB(String username, String password) throws Exception {
		getResult = null;
		
		// ִ��SELECT��䣬������username��ͬ���û�������
		rs = stmt.executeQuery("SELECT password FROM userlogin WHERE username=" + "'" + username + "'");
		if(rs.next()) {
			getResult = rs.getString("password");
			if(getResult.equals(password))
				this.passFlag = true;
			else
				this.passFlag = false;
		} else
			this.passFlag = false;
		
		// ���û�����ݣ��򷵻�null
		return getResult;
	}
	
	// �ر����ݿ�����
	public void close() throws Exception {
		rs.close();
		stmt.close();
		conn.close();
	}
	
	public static void main(String[] args) {
		ReadAndWriteUserPasswordDB test = new ReadAndWriteUserPasswordDB();
		
		try {
			System.out.println(test.readDB("�����", "1123581321"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
