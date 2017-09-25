// �½�19.07.1            Java���ݿ�Ӧ�ó���������ݿ��ȫ����
package ex19_07_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDB {
	private Connection conn = null;		// ���ݿ������
	private Statement stmt = null;
	private ResultSet rs =null;

	public TestDB() {
		
	}

	// �������ݿ�
	private void getConnect() {
		// ������
		try {
			String driver = "com.mysql.jdbc.Driver";		// ������������
			String url = "jdbc:mysql://localhost:3306/test";		// test��������Դ������
			String user = "root";		// login��������Դ�ĵ�¼��
			String password = "11235813";		// 11235813��������Դ������

			Class.forName(driver);		// �������ݿ����������
			conn = DriverManager.getConnection(url, user, password);		// �������ݿ�
			if(conn != null)
				System.out.println("���ݿ����ӳɹ���");
		} catch(Exception e) {
			System.err.print("���ݿ�����ʧ�ܣ�\n" + e.toString());
		}
	}

	// ��ͨ��ѯ
	public void query(String sql) {
		getConnect();		// ��ȡ���ݿ�����
		
		try {
			stmt = conn.createStatement();		// �õ�Statement��ʵ��
			rs = stmt.executeQuery(sql);		// ִ��SQL��䣬���ؽ����
			while(rs.next()) {
				String userName = rs.getString("username");
				String password = rs.getString("password");
				System.out.println("�û�����" + userName + "�����룺" + password);
			}
		} catch(Exception e) {
			System.err.print("��ѯ����ʱ����\n" + e.toString());
		}
		
		closeAll(); 	// �ͷ���Դ
	}
	
	// ��ӡ�ɾ��������
	public void add_update_Delete(String sql) {
		getConnect();		// ��ȡ���ݿ�����
		
		try {
			stmt = conn.createStatement();		// �õ�Statement��ʵ��
			int line = stmt.executeUpdate(sql);
			System.out.println("�����ɹ���" + line);
		} catch(Exception e) {
			System.err.print("��������ʱ����\n" + e.toString());
		}
		
		closeAll(); 	// �ͷ���Դ
	}

	// �ͷ���Դ
	public void closeAll() {
		if(rs != null)
			rs = null;
		if(stmt != null)
			stmt = null;
		if(conn != null)
			conn = null;
		System.out.println("�ɹ��ͷ���Դ��");
	}

	public static void main(String[] args) {
		TestDB test = new TestDB();
		String querySQL, updateSQL;

		// ִ�в�ѯ����
		querySQL = "SELECT * FROM userlogin";
		test.query(querySQL);
		
		// ִ����Ӳ���
		updateSQL = "INSERT into userlogin VALUES('����', '123456')";
		test.add_update_Delete(updateSQL);
		test.query(querySQL);
		
		// ִ��ɾ������
		updateSQL = "DELETE FROM userlogin WHERE username='����'";
		test.add_update_Delete(updateSQL);
		test.query(querySQL);
		
		// ִ���޸Ĳ���
		updateSQL = "UPDATE userlogin SET username='����' WHERE username='����'";
		test.add_update_Delete(updateSQL);
		test.query(querySQL);
	}

}
