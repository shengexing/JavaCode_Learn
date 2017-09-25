// 章节20.03.2            使用DefaultTableModel创建JTable表格
package ex20_03_2;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ex20_01_1.TestDB;

public class TestDefaultTableModel extends JFrame {
	
	Vector colsv = new Vector();	 	// 创建一个向量
	JTable table;					// 声明一个JTable对象
	DefaultTableModel tablemodel;			// 创建DefaultTableModel模型
	
	public TestDefaultTableModel() {
		this.setLayout(new FlowLayout());
		
		// 将String对象“编号”，“姓名”，“年龄”，“性别”和地址加入向量中用于显示表头
		colsv.add("用户名");
		colsv.add("密码");
		tablemodel = new DefaultTableModel(new Vector(), colsv);
		
		// 实例化表格模型，列值为向量colsv
		String sql = "SELECT * FROM userlogin";
		TestDB db = new TestDB();
		ResultSet rs = db.query(sql);				// 执行查询操作
		
		// 将查询出的结果集中的值放到vector
		Vector value = new Vector();
		try {
			while(rs.next()) {			// 循环遍历结果集rs中的记录
				Vector vc = new Vector();		// 创建向量对象
				vc.add(rs.getString("username")); 			// 将从当前记录中获得的相应字段的值添加到向量中
				vc.add(rs.getString("password"));
				value.add(vc);
			}
			
			db.closeAll(); 			// 释放资源
			
			tablemodel.setDataVector(value, colsv); 			// 在表格中写入新的行，其值为向量value
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		table = new JTable(tablemodel);				// 使用tablemodel创建表对象
		this.add(new JScrollPane(table));				// 将表格添加到滚动面板中
		this.setSize(500, 300); 					// 设置窗体大小
		this.setVisible(true); 						// 使窗体可见
		
		// 设置监听器，关闭窗口后，程序结束
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {	
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new TestDefaultTableModel();

	}

}
