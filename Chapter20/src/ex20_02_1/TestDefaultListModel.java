// �½�20.02.1            ʹ��DefaultListModel����JList�б�
package ex20_02_1;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import ex20_01_1.TestDB;

public class TestDefaultListModel {

	public static void main(String[] args) {
		JFrame f = new JFrame("����");		// �����������
		Container contentPane = f.getContentPane();		// ��ô��������������
		String sql = "SELECT username FROM userlogin";		// ��ѯ���
		TestDB db = new TestDB();		// ����TestDBʵ��
		
		ResultSet rs = db.query(sql);	 		// ����query�����Ĳ�ѯ
		
		// ���´���Ϊ�������д������name��
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
			
			DefaultListModel<String> mode = new DefaultListModel<String>();			// �����б�ģ��
			for(int i = 0; i < name.length; i++)
				mode.addElement(name[i]);	 		// ����б���
			JList<String> list = new JList<String>(mode);		// �����б�
			list.setVisibleRowCount(3); 				// �����б���ѡ��СΪ3
			contentPane.add(new JScrollPane(list));			// ����б����ɹ�������ͼ��
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		f.pack(); 			// pack()���������������ڵĴ�С�����ʺ�list����ѡ��С
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {			// ���ü��������رմ��ں󣬳������
				System.exit(0);
			}
		});

	}

}
