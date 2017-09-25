// 章节20.01.2            使用DefaultComboBoxModel创建JcomboBox组合框
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
		JFrame f = new JFrame("姓名");		// 创建窗体对象f
		Container contentPane = f.getContentPane();		// 获得窗体f的内容面板
		contentPane.setLayout(new FlowLayout());		// 设置内容面板的布局方式为流式布局
		String sql = "SELECT username FROM userlogin";		// 查询语句
		TestDB db = new TestDB();		// 创建TestDB实例

		ResultSet rs = db.query(sql);

		// 以下代码将结果集写入数组name中
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

			DefaultComboBoxModel<String> mode = new DefaultComboBoxModel<String>();		// 创建下拉列表模型
			for(int i = 0; i < name.length; i++)
				mode.addElement(name[i]);	 		// 添加列表项
			JComboBox<String> combo = new JComboBox<String>(mode);		// 创建下拉列表
			contentPane.add(combo);
		} catch(SQLException e) {
			e.printStackTrace();
		}

		f.setSize(150, 200);			// 设置窗体的大小
		f.setVisible(true); 				// 设置窗体可见
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {			// 设置监听器，关闭窗口后，程序结束
				System.exit(0);
			}
		});

	}

}
