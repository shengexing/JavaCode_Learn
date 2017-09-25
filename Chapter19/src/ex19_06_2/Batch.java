// �½�19.06.2            һ�������������
package ex19_06_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Batch {

	public static void main(String[] args) {
		try {
			// ������������
			Class.forName("com.mysql.jdbc.Driver");

			// �����ݿ����ӣ�testΪ����Դ����
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "11235813");
			
			// ����������
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			
			// �����������
			stmt.addBatch("INSERT INTO userlogin VALUES('����', '123456')");
			stmt.addBatch("INSERT INTO userlogin VALUES('����', '123456')");
			stmt.addBatch("INSERT INTO userlogin VALUES('����', '123456')");
			
			stmt.executeBatch();
			conn.commit();
			
			// �ָ�autoCommit����
			conn.setAutoCommit(true);
			
			// �ر�Statement����
			stmt.close();
			
			// �ر�Connection����
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
