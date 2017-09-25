// 章节20.02.2            使用ListModel创建JList列表
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
		
		ListModel mode = new DataModel();			// 创建ListModel对象
		JList list = new JList(mode);						// 利用ListModel建立一个JList
		list.setVisibleRowCount(5); 							// 设置程序一打开时所能看到的数据顶个数
		contentPane.add(new JScrollPane(list)); 		// 向内容面板中添加JList组件
		
		f.pack();
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {			// 设置监听器，关闭窗口后，程序结束
				System.exit(0);
			}
		});
	}
	
	// 创建继承自AbstractListModel抽象类的内部类DataModel
	class DataModel extends AbstractListModel {
		TestDB db = new TestDB();
		String[] dbName = null;
		
		public DataModel() {
			dbName = db.getAllName();
		}
		
		// getElementAt()方法中的参数index，系统会自动由0开始计算，不过要自己作累加的操作
		@Override
		public String getElementAt(int index) {					// 实现继承的getElementAt()方法
			return (index + 1) + "." + dbName[index++];
		}

		@Override
		public int getSize() {								// 实现继承的getSize()方法
			return dbName.length;
		}
	
	}

	public static void main(String[] args) {
		new TestAbstractListModel();
	}

}
