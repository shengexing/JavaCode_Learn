// �½�20.04.1            ʹ��Result�������ݿ�
package ex20_04_1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ������ʾʹ��ResultSet�������ݿ�����ݡ������޸ġ������ɾ��
 */
public class UpdateWithResultSet {
	/**
	 * ʹ��ResultSet���Ը������ݿ�����ݣ�ǰ������֮������Statementû�б��ر�
	 * @param con
	 */
	public static void update(Connection conn) {
		String sql = "SELECT * FROM userlogin";
		Statement sm = null;
		ResultSet rs = null;
		try {
			// ����Statement
			// ResultSet.TYPE_SCROLL_SENSITIVE��ʾ��ResultSet�п���������������ǰ����ƶ��α�
			// ͬʱResultSet��ֵ�����ı��ʱ�������Եõ��ı������µ�ֵ
			// ResultSet.CONCUR_UPDATABLE��ʾ��ResultSet�е����ݼ�¼���������޸ģ�Ȼ��������ݿ�
			sm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = sm.executeQuery(sql);
			
			/** ��ResultSet���µ�һ������*/
			// ָ���Ƶ���һ������
			rs.absolute(1);
			// �޸�����
			rs.updateString(2, "666666");
			System.out.println("��Ҫ��ResultSet�޸�һ����¼��" + rs.getString(2));
			// ��������޸ģ���ʹ��updateRow�����ύ�޸�
			rs.updateRow();
			// �����ȡ����ǰ��¼���޸ģ�����ȡ��
			/*rs.cancelRowUpdates();*/
			rs.cancelRowUpdates();
			// ���޸��ύ������Դ
			OperateDB.showResultSet(rs);
			
			/** ��ResultSet����һ������*/
			System.out.println("׼����ResultSet����һ����¼��");
			// ָ���ƶ��������
			rs.moveToInsertRow();
			// Ϊ����������ֵ
			rs.updateString("username", "����");
			rs.updateString(2, "12345678");
			// �������ύ������Դ
			rs.insertRow();
			OperateDB.showResultSet(rs);
			
			/** ��ResultSetɾ��һ������*/
			rs.absolute(4);
			System.out.println("׼����ResultSetɾ�����һ����¼��");
			rs.deleteRow();
			OperateDB.showResultSet(rs);
			
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			// �ر�Statement
			OperateDB.closeStatement(sm);
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		String dbName = "test";
		String userName = "root";
		String password = "11235813";
		
		Connection conn = null;
		
		try {
			// ������ݿ�����
			conn = OperateDB.getMySQLConnection(dbName, userName, password);
			
			// �������ݿ�
			UpdateWithResultSet.update(conn);
		} finally {
			// �ر����ݿ�����
			OperateDB.closeConnection(conn);
		}

	}

}
