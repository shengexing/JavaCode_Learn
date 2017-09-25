// �½�20.01.1            ʹ��JcomboBox��Ͽ�
package ex20_01_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {
	private Connection conn = null;		// �������ݿ����Ӷ���
	private Statement stmt = null;			// ����SQL������
	private ResultSet rs = null;				// �������������

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

	// �ͷ���Դ
	public void closeAll() {
		try {
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			System.err.print("�ͷ���Դʱ����\n" + e.toString());
		}
		System.out.println("�ɹ��ͷ���Դ��");
	}

	// ��ͨ��ѯ
	public ResultSet query(String sql) {
		try {
			getConnect(); 			// �������ݿ�

			// �����������ΪTYPE_SCROLL_SENSITIVE����������ΪCONCUR_READ_ONLY
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			rs = stmt.executeQuery(sql);
		}  catch(Exception e) {
			System.err.print("��ѯ����ʱ����\n" + e.toString());
		}

		return rs;
	}
	
	// �������
	public String[] getAllName() {
		ResultSet rs = query("SELECT username FROM userlogin");
		
		try {
			rs.last();		// �ƶ�������������һ��
			int rows = rs.getRow();		// �õ���������������rows
			rs.beforeFirst(); 			// �ƻؽ��������

			String name[] = new String[rows];		// ��������name������Ϊrows
			int index = 0;
			while(rs.next()) {
				name[index] = rs.getString(1);
				index++;
			}
			
			closeAll(); 		// �ͷ���Դ
			
			return name;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
