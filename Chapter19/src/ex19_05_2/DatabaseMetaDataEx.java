// �½�19.05.2            DatabaseMetaData��������
package ex19_05_2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DatabaseMetaDataEx {

	public static void main(String[] args) {
		try {
			// ������������
			Class.forName("com.mysql.jdbc.Driver");
			
			// �����ݿ����ӣ�testΪ����Դ����
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "11235813");
			
			// ����DatabaseMetaData����
			DatabaseMetaData dmd = conn.getMetaData();
			
			// �������ڸ��������ʹ�õı������
			ResultSet rs = dmd.getTables(null, null, null, new String[] {"table"});
			
			// ����ResultSetMetaData����
			ResultSetMetaData rsmd = rs.getMetaData();
			
			// ���ش�ResultSet�����е�����
			int cols = rsmd.getColumnCount();
			for(int i = 1; i <= cols; i++)
				// ��ȡָ���е�����
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
