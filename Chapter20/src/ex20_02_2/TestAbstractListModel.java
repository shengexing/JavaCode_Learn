// �½�20.02.2            ʹ��ListModel����JList�б�
package ex20_02_2;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import ex20_01_1.TestDB;

public class TestAbstractListModel {
	
	public TestAbstractListModel() {
		JFrame f = new JFrame("JList");
		Container contentPane = f.getContentPane();
		
		ListModel mode = new DataModel();			// ����ListModel����
		JList list = new JList(mode);						// ����ListModel����һ��JList
		list.setVisibleRowCount(5); 							// ���ó���һ��ʱ���ܿ��������ݶ�����
		contentPane.add(new JScrollPane(list)); 		// ��������������JList���
		
		f.pack();
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {			// ���ü��������رմ��ں󣬳������
				System.exit(0);
			}
		});
	}
	
	// �����̳���AbstractListModel��������ڲ���DataModel
	class DataModel extends AbstractListModel {
		TestDB db = new TestDB();
		String[] dbName = null;
		
		public DataModel() {
			dbName = db.getAllName();
		}
		
		// getElementAt()�����еĲ���index��ϵͳ���Զ���0��ʼ���㣬����Ҫ�Լ����ۼӵĲ���
		@Override
		public String getElementAt(int index) {					// ʵ�ּ̳е�getElementAt()����
			return (index + 1) + "." + dbName[index++];
		}

		@Override
		public int getSize() {								// ʵ�ּ̳е�getSize()����
			return dbName.length;
		}
	
	}

	public static void main(String[] args) {
		new TestAbstractListModel();
	}

}
