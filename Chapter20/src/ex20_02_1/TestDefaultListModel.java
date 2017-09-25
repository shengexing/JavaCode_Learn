// 章节20.02.1            使用DefaultListModel创建JList列表
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
		JFrame f = new JFrame("姓名");		// 创建窗体对象
		Container contentPane = f.getContentPane();		// 获得窗体对象的内容面板
		String sql = "SELECT username FROM userlogin";		// 查询语句
		TestDB db = new TestDB();		// 创建TestDB实例
		
		ResultSet rs = db.query(sql);	 		// 调用query方法的查询
		
		// 以下代码为将结果集写入数组name中
		try {
			rs.last();		// 移动到结果集的最后一行
			int rows = rs.getRow();		// 得到行数，赋给变量rows
			rs.beforeFirst(); 			// 移回结果集首行

			String name[] = new String[rows];		// 创建数组name，长度为rows
			int index = 0;
			while(rs.next()) {
				name[index] = rs.getString(1);
				index++;
			}
			
			db.closeAll(); 		// 释放资源
			
			DefaultListModel<String> mode = new DefaultListModel<String>();			// 创建列表模型
			for(int i = 0; i < name.length; i++)
				mode.addElement(name[i]);	 		// 添加列表项
			JList<String> list = new JList<String>(mode);		// 创建列表
			list.setVisibleRowCount(3); 				// 设置列表首选大小为3
			contentPane.add(new JScrollPane(list));			// 添加列表至可滚动的视图中
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		f.pack(); 			// pack()方法用来调整窗口的大小，以适合list的首选大小
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {			// 设置监听器，关闭窗口后，程序结束
				System.exit(0);
			}
		});

	}

}
