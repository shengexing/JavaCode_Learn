// 章节20.01.1            使用JcomboBox组合框
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
		JFrame f = new JFrame("姓名");		// 创建底层容器JFrame
		Container contentPane = f.getContentPane();		// 通过getContentPane创建内容面板
		contentPane.setLayout(new FlowLayout());			// 设置内容面板的布局方式为流式布局
		
		String sql = "SELECT username FROM userlogin";		// 查询语句
		TestDB db = new TestDB();			// 创建TestDB实例
		
		ResultSet rs = db.query(sql);			// 调用query方法进行查询
		
		// 以下代码为将结果写入数组name中
		try {
			rs.last();		// 移动到结果集的最后一行
			int rows = rs.getRow();		// 得到行数，赋给变量rows
			rs.beforeFirst(); 					// 移回到结果集首行
			String name[] = new String[rows];		// 创建数组name，长度为rows
			int index = 0;
			while(rs.next()) {
				name[index] = rs.getString(1);
				index++;
			}
			
			db.closeAll();		// 释放TestDB对象的资源
			
			// 创建下拉列表实例列表项的值为数组name
			JComboBox<String> combo1 = new JComboBox<String>(name);
			contentPane.add(combo1);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		f.setSize(100, 150); 			// 设置容器宽为100，高为150
		f.setVisible(true); 				// 设置容器可见
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {			// 设置监听器，关闭窗口后，程序结束
				System.exit(0);
			}
		});

	}

}
