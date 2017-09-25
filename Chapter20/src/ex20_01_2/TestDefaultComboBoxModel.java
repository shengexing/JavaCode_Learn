// �½�20.01.2            ʹ��DefaultComboBoxModel����JcomboBox��Ͽ�
package ex20_01_2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import ex20_01_1.TestDB;

public class TestDefaultComboBoxModel {

	public static void main(String[] args) {
		JFrame f = new JFrame("����");		// �����������f
		Container contentPane = f.getContentPane();		// ��ô���f���������
		contentPane.setLayout(new FlowLayout());		// �����������Ĳ��ַ�ʽΪ��ʽ����
		String sql = "SELECT username FROM userlogin";		// ��ѯ���
		TestDB db = new TestDB();		// ����TestDBʵ��

		ResultSet rs = db.query(sql);

		// ���´��뽫�����д������name��
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
			
			db.closeAll(); 		// �ͷ���Դ

			DefaultComboBoxModel<String> mode = new DefaultComboBoxModel<String>();		// ���������б�ģ��
			for(int i = 0; i < name.length; i++)
				mode.addElement(name[i]);	 		// ����б���
			JComboBox<String> combo = new JComboBox<String>(mode);		// ���������б�
			contentPane.add(combo);
		} catch(SQLException e) {
			e.printStackTrace();
		}

		f.setSize(150, 200);			// ���ô���Ĵ�С
		f.setVisible(true); 				// ���ô���ɼ�
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {			// ���ü��������رմ��ں󣬳������
				System.exit(0);
			}
		});

	}

}
