// �½�20.01.1            ʹ��JcomboBox��Ͽ�
package ex20_01_1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class TestJComboBox {

	public static void main(String[] args) {
		JFrame f = new JFrame("����");		// �����ײ�����JFrame
		Container contentPane = f.getContentPane();		// ͨ��getContentPane�����������
		contentPane.setLayout(new FlowLayout());			// �����������Ĳ��ַ�ʽΪ��ʽ����
		
		String sql = "SELECT username FROM userlogin";		// ��ѯ���
		TestDB db = new TestDB();			// ����TestDBʵ��
		
		ResultSet rs = db.query(sql);			// ����query�������в�ѯ
		
		// ���´���Ϊ�����д������name��
		try {
			rs.last();		// �ƶ�������������һ��
			int rows = rs.getRow();		// �õ���������������rows
			rs.beforeFirst(); 					// �ƻص����������
			String name[] = new String[rows];		// ��������name������Ϊrows
			int index = 0;
			while(rs.next()) {
				name[index] = rs.getString(1);
				index++;
			}
			
			db.closeAll();		// �ͷ�TestDB�������Դ
			
			// ���������б�ʵ���б����ֵΪ����name
			JComboBox<String> combo1 = new JComboBox<String>(name);
			contentPane.add(combo1);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		f.setSize(100, 150); 			// ����������Ϊ100����Ϊ150
		f.setVisible(true); 				// ���������ɼ�
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {			// ���ü��������رմ��ں󣬳������
				System.exit(0);
			}
		});

	}

}
