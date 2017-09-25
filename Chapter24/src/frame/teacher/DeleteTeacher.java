// 章节24.05.3            删除老师信息
package frame.teacher;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import util.OperateDB;

public class DeleteTeacher extends JFrame implements ActionListener {

	JLabel  head_label = new JLabel("删除基本信息", JLabel.CENTER);		// 使用文本创建一个“头部”标签对象

	JLabel number_label = new JLabel("教师编号：");						// 创建一个“教师编号”标签对象
	JTextField number_field = new JTextField();						// 创建一个“学号”文本框对象

	JLabel name_label = new JLabel("姓名：");							// 创建一个“姓名”标签对象
	JTextField name_field = new JTextField();							// 创建一个“姓名”文本框对象

	// 创建按钮对象
	JButton delete_button = new JButton("删除");
	JButton reset_button = new JButton("重置");
	JButton exit_button = new JButton("退出");

	String sql = "";				// 定义SQL语句字符串

	/** 无参的构造器*/
	public DeleteTeacher() {
		this.setTitle("删除教师信息"); 				// 设置窗口标题
		getContentPane().setLayout(null); 								// 设置布局管理器为空

		// 设置头标签的相关属性
		head_label.setForeground(Color.red);
		head_label.setFont(new Font("宋体", Font.PLAIN, 19));
		head_label.setBounds(100, 30, 200, 40);
		getContentPane().add(head_label);

		// 设置学号标签及其文本框的相关属性
		number_label.setBounds(100, 120, 100, 20);
		getContentPane().add(number_label);
		number_field.setBounds(200, 120, 80, 20);
		getContentPane().add(number_field);

		// 设置姓名标签及其文本框的相关属性
		name_label.setBounds(100, 160	, 60, 20);
		getContentPane().add(name_label);
		name_field.setBounds(200, 160, 80, 20);
		getContentPane().add(name_field);

		// 设置3个按钮的相关属性
		delete_button.setBounds(80, 320, 90, 20);
		getContentPane().add(delete_button);
		delete_button.addActionListener(this);

		reset_button.setBounds(190, 320, 90, 20);
		getContentPane().add(reset_button);
		reset_button.addActionListener(this);

		exit_button.setBounds(300, 320, 90, 20);
		getContentPane().add(exit_button);
		exit_button.addActionListener(this);

		// 设置主窗体的相关属性
		this.setBounds(10, 10, 500, 400);
		this.setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	/** 处理按钮的动作事件*/
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();			// 获取监听事件源

		// 处理“删除”事件
		if(source == delete_button) {
			String number = number_field.getText(), 		// 将“学号”文本框中包含的文本传给字符串number
					name = name_field.getText(); 				// 将“姓名”文本框中包含的文本传给字符串name

			// 检索出ID等于number的学生的所有信息
			sql = "SELECT * FROM teacher WHERE number='" + number + "'";

			try {
				Connection conn = OperateDB.getMySQLConnection("school_schema", "root", "11235813");		// 获取数据库连接
				Statement stmt = conn.createStatement();				// 提交查询
				ResultSet rs = stmt.executeQuery(sql);					// 取得查询结果

				if(rs.next()) {		// 判断结果是否存在
					// 删除学号为number的学生的所有信息
					sql = "DELETE * FROM teacher WHERE number='" + number + "'";
					int line = stmt.executeUpdate(sql);			// 对数据库进行更新

					if(line > 0)
						JOptionPane.showMessageDialog(null, "删除成功！");
					else
						JOptionPane.showMessageDialog(null, "删除失败！");
				} else {
					JOptionPane.showMessageDialog(null, "此用户不存在！");
				}

			} catch(Exception e1) {

			}
		}

		// 处理“重置”事件
		if(source == reset_button) {
			number_field.setText(null);
			name_field.setText(null);
		}

		// 处理“”事件
		if(source == exit_button)
			setVisible(false);

	}

	/** 主方法*/
	public static void main(String[] args) {


	}

}
